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

import nts.interf.base.IExpr;
import nts.interf.base.IVisitor;
import nts.interf.expr.IAccessIndexed;

public class AccessIndexed extends Access implements IAccessIndexed {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	// guarantees: size >= 1
	private List<IExpr> indices = new LinkedList<IExpr>();
	
	//void setToken(Token aToken) { token(aToken); }
	public int accessDepth() { return indices.size(); }
	public int multiAccess() { return 1; }
	
	// interface
	public List<IExpr> indices() { return indices; }	
	
	
	public AccessIndexed(Token aId, List<IExpr> aI) {
		super(aId);
		indices = aI;
	}
	
	public AccessIndexed(Token aId) {
		super(aId);
	}
	
	public void setInx(List<IExpr> aI) {
		indices = aI;
	}
	
	public Expr semanticChecks(VarTable aVT, SemFlags aS) {
		
		check_base(aVT,aS);
		
		// semantic checks for indices
		SemFlags s = SemFlags.addNoPrimed(aS);
		Expr.checkInt(indices, aVT, s);
		
		return this;
	}
	
	public AccessIndexed syn_copy() {
		AccessIndexed e = new AccessIndexed(Common.copyToken(token));
		for (IExpr ee : indices) {
			e.indices.add(((Expr)ee).syn_copy());
		}
		return e;
	}
}
