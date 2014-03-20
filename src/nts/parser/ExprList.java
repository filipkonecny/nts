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

import nts.interf.base.IExpr;
import nts.interf.base.IVisitor;
import nts.interf.expr.IExprList;

import org.antlr.runtime.Token;

import java.util.*;

// syntax: [e1,..en] where ei is Expr
public class ExprList extends Expr implements IExprList {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	private List<IExpr> l = new LinkedList<IExpr>(); // length >= 1
	
	// interface //////
	public List<IExpr> expressions() {
		return l;
	}
	///////////////////
	
	ExprList(Token aTok, List<IExpr> aL) {
		super(aTok,aTok);
		l = aL;
	}
	
	ExprList(Token aTok) {
		super(aTok,aTok);
	}
	
	void addExpr(Expr aE) {
		l.add(aE); 
	}
	
	public Expr semanticChecks(VarTable aVT, SemFlags sFlags) {
		
		Type t = null;
		for (IExpr e : l) {
			Expr ee = ((Expr)e).semanticChecks(aVT, sFlags);
			Type aux = ee.type();
			if (t == null) {
				t = aux;
			} else if (!t.matches(aux)) {
				System.err.println("Semantic error in expression list ("+Common.at(token)+"): types of expression at " +
						Common.at(ee.token) +" and "+Common.at(((Expr)l.get(0)).token)+" differ.");
				System.exit(1);
			}
		}
		type = Type.dummyManyPureArrRef(t.basicType(), t.dimTotal(), l.size());
		return this;
	}
	
	ExprList syn_copy() {
		ExprList ret = new ExprList(Common.copyToken(token));
		for (IExpr ee : l) {
			ret.addExpr(((Expr)ee).syn_copy());
		}
		return ret;
	}
	
	public Expr expandHavoc(VarTable aVT) {
		return this;
	}
}
