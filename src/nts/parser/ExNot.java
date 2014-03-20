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

import nts.interf.base.IVisitor;
import nts.interf.expr.IExprNot;

import org.antlr.runtime.Token;

public class ExNot extends OpUn implements IExprNot {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	public ExNot(Expr aE) { this(null,aE); }
	public ExNot(Token aT, Expr aE) { super(aT,aE); }
	
	ExNot syn_copy() { return new ExNot(Common.copyToken(token),op.syn_copy()); }
	
	public Expr semanticChecks(VarTable aVT, SemFlags seType) {
		
		super.semanticChecks(aVT,seType);
		
		op.checkBool();
		type = op.type;
		
		return this;
	}
}
