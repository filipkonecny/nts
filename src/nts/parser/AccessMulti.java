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
import java.util.*;

import nts.interf.base.IExpr;
import nts.interf.expr.IAccessMulti;
import nts.interf.base.IVisitor;

// syntax: a[i1]..[im][j1,..,jn]
public class AccessMulti extends Access implements IAccessMulti {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	// guarantees: size >= 0
	private List<IExpr> single = new LinkedList<IExpr>();
	// guarantees: size >= 2
	private List<IExpr> multi = new LinkedList<IExpr>();
	
	public List<IExpr> singleInxs() { return single; }
	public List<IExpr> multiInxs() { return multi; }
	
	public int accessDepth() { return single.size() + 1; }
	public int multiAccess() { return multi.size(); }
	
	AccessMulti(Token aId, List<IExpr> aM, List<IExpr> aS) {
		super(aId);
		single = aS;
		multi = aM;
	}
	AccessMulti(Token aId) {
		super(aId);
	}
	
	void setSingle(List<IExpr> aI) {
		single = aI;
	}
	void setMulti(List<IExpr> aI) {
		multi = aI;
	}
	
	public Expr semanticChecks(VarTable aVT, SemFlags aS) {
		
		this.check_base(aVT, aS);
		
		// semantic checks for indices
		SemFlags s = SemFlags.addNoPrimed(aS);
		Expr.checkInt(single, aVT, s);
		Expr.checkInt(multi, aVT, s);
		
		return this;
	}
	
	public AccessMulti syn_copy() {
		AccessMulti e = new AccessMulti(Common.copyToken(token));
		for (IExpr ee : single) {
			e.single.add(((Expr)ee).syn_copy());
		}
		for (IExpr ee : multi) {
			e.multi.add(((Expr)ee).syn_copy());
		}
		return e;
	}
}
