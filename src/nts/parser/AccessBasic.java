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

import nts.interf.expr.IAccessBasic;
import nts.interf.base.IVisitor;

import org.antlr.runtime.Token;

public class AccessBasic extends Access implements IAccessBasic {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	public AccessBasic(Token aId) {
		super(aId);
	}
	
	public int accessDepth() { return 0; }
	public int multiAccess() { return 1; }
	
	public AccessBasic syn_copy() {
		AccessBasic e = new AccessBasic(Common.copyToken(token));
		e.entry = entry;
		return e;
	}
	
	public Expr semanticChecks(VarTable aVT, SemFlags seType) {
		
		check_base(aVT,seType);
		
		return this;
	}
	
	public void replaceWithEntry(VarTableEntry aV) {
		this.token = Common.tok_idp(aV.name());
		this.entry = aV;
	}
}
