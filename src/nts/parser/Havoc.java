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

import org.antlr.runtime.Token;

import nts.interf.base.EBasicType;
import nts.interf.base.IVarTableEntry;
import nts.interf.base.IVisitor;
import nts.interf.expr.IAccessBasic;
import nts.interf.expr.IHavoc;

import java.util.*;

public class Havoc extends Expr implements IHavoc {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	// unprimed variables in the havoc
	private List<Token> varsTok;
	private List<IAccessBasic> vars;
	
	// interface
	public List<IAccessBasic> vars() { return vars; }
	public Type type() { return new Type(EBasicType.BOOL); }
	
	boolean isEmpty() { return vars.isEmpty(); }
	
	public Havoc(List<Token> aL) { this(null, aL); }
	public Havoc(Token aTok, List<Token> aL) {
		super(aTok, aTok);
		varsTok = aL;
	}
	
	public Expr semanticChecks(VarTable aVT, SemFlags aS) {
		
		vars = new LinkedList<IAccessBasic>();
		
		SemFlags sf = SemFlags.addNoPrimed(aS);
		for (Token t : varsTok) {
			//VarTableEntry e = aVT.checkIfDeclar(t);
			AccessBasic a = new AccessBasic(t);
			a.semanticChecks(aVT, sf);
			vars.add(a);
		}
		
		type = new Type(EBasicType.BOOL);
		return this;
	}
	
	Havoc syn_copy() {
		Havoc e = new Havoc(Common.copyToken(token), Common.copyTokens(varsTok));
		//e.varsTok = new LinkedList<Token>(varsTok);
		if (vars != null) {
			e.vars = new LinkedList<IAccessBasic>();
			for (IAccessBasic a : vars) {
				e.vars.add(((AccessBasic)a).syn_copy());
			}
		}
		return e;
	}
	
	public void renameVarTokens(Map<String,String> ren) {
		vars.clear();
		for (Token t : varsTok) {
			t.setText(ren.get(t.getText()));
		}
	}
	
	public Expr expandHavoc(VarTable aVT) {
		Set<String> aux = new HashSet<String>();
		for (IVarTableEntry iv : aVT.visibleUnprimed()) {
			VarTableEntry v = (VarTableEntry) iv;
			if (!v.isParam()) {
				aux.add(v.name());
			}
		}
		for (Token t : varsTok) {
			aux.remove(t.getText());
		}
		
		Expr ret = null;
		
		for (String s : aux) {
			Expr eq = ASTWithoutToken.exEq(
						ASTWithoutToken.accessBasic(s+"'"),
						ASTWithoutToken.accessBasic(s)
						);
			if (ret == null) {
				ret = eq;
			} else {
				ret = ASTWithoutToken.exAnd(ret,eq);
			}
		}
		
		return ret;
	}
	
	public void addHavocToken(String id_unprimed) {
		varsTok.add(Common.tok_idn(id_unprimed));
	}
}
