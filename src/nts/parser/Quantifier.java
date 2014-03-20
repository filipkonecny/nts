/*******************************************************************************
 * Copyright (C) 2011 Filip Konecny
 * 
 * This file is part of NTS-lib-java.
 * 
 * NTS-lib-java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * NTS-lib-java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with NTS-lib-java.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package nts.parser;

import java.util.*;

import org.antlr.runtime.Token;

import nts.interf.base.EBasicType;
import nts.interf.base.IExprQ;
import nts.interf.base.IVarTableEntry;

public abstract class Quantifier extends Expr implements IExprQ {
	
	protected VarTable vt;
	public VarTable varTable() { return vt; }
	
	/**
	 *  quantif x : type[e1,e2], ... y : type[ee, en] . expr
	 *    <==>
	 *  quantif x : type, ... y : type . (e1 <= x <= e2 and ee <= y <= en) impl expr
	 */
	private Expr expr;
	
	// to be processed after parsing
	private List<QDeclarBlock> qd = new LinkedList<QDeclarBlock>();
	
	// interface
	public Expr operand() { return expr; }
	
	public Quantifier(Token aToken, VarTable aVt) {
		super(aToken, aToken);
		vt = aVt;
	}
	
	void addDeclBlock(QDeclarBlock aB) {
		qd.add(aB);
	}
	public void setExpr(Expr aE) {
		expr = aE;
	}

	public Expr semanticChecks(VarTable aVT, SemFlags aS) {
		 
		//  1) check if no variable declared in quantifier scope is not declared in the super-scope
		//  2) semantic-check interval bounds and expression
		//  3) make formula out of intervals
		
		// check if no variable declared in quantifier scope is not declared in the super-scope
		// (necessary for annotations, some of which are specified before declaration of global / local variables)
		vt.checkRedeclaration(aVT);
		
		Expr premise = null;
		for (QDeclarBlock qdb : qd) {
			if (qdb.bnd_l != null) {
				qdb.bnd_l = qdb.bnd_l.semanticChecks(vt,aS);
				qdb.bnd_u = qdb.bnd_u.semanticChecks(vt,aS);
				if (!qdb.bnd_l.type.matches(qdb.bnd_u.type)) {
					System.err.println("Semantic error at "+Common.at(qdb.rangeStart)+". Types of upper and lower bound don't match.");
					System.exit(1);
				}
				if (qdb.bnd_l.type.basicType().isBool()) {
					System.err.println("Semantic error at "+Common.at(qdb.rangeStart)+". Bounds permitted only for numeric types.");
					System.exit(1);
				}
				VarTableEntry v = qdb.vars.get(0);
				if (!qdb.bnd_l.type.matches(v.type())) {
					System.err.println("Semantic error at "+Common.at(qdb.rangeStart)+". Type of bounds doesn't match with the type of variable.");
					System.exit(1);
				}
				
				boolean b = true;
				for (VarTableEntry e : qdb.vars) {
					Access ab = new AccessBasic(e.nameToken());
					if (b) {
						b = false;
					} else { // copy to avoid sharing of AST
						qdb.bnd_l = qdb.bnd_l.syn_copy();
						qdb.bnd_u = qdb.bnd_u.syn_copy();
					}
					
					OpBin lb = new ExLeq(Common.parser.dummyLeq(), qdb.bnd_l, ab);
			        OpBin ub = new ExLeq(Common.parser.dummyLeq(), ab, qdb.bnd_u);
			        
			        if (premise == null) {
			        	premise = lb;
			        } else {
			        	premise = new ExAnd(Common.parser.dummyAnd(), premise, lb);
			        }
			        premise = new ExAnd(Common.parser.dummyAnd(), premise, ub);
				}
			}
		}
		
		// add premise
		if (premise != null) {
			expr = new ExImpl(Common.parser.dummyImpl(),premise,expr);
		}

		// check semantics
		expr = expr.semanticChecks(vt, aS);
		
		if (expr.type.isArray() || expr.type.basicType() != EBasicType.BOOL) {
			System.err.println("Semantic error at "+Common.at(expr.first)+". Logical expression expected.");
			System.exit(1);
		}
		
		type = new Type(EBasicType.BOOL);
		return this;
	}
	
	Expr syn_copy() {
		throw new RuntimeException("internal error");
	}
	
	public void renameVarTokens(Map<String,String> ren) {
		Map<String,String> ren_2 = new HashMap<String,String>(ren);
		for (IVarTableEntry v : vt.innermostUnprimed()) {
			String s1 = v.name();
			String s2 = "Q_"+s1;
			ren_2.put(s1,s2);
			vt.renameInnermost(s1, s2);
		}
		
		expr.renameVarTokens(ren_2);
	}
	
	public Expr expandHavoc(VarTable aVT) {
		expr = expr.expandHavoc(this.varTable());
		return this;
	}
}
