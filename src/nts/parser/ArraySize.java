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

import nts.interf.base.*;
import nts.interf.expr.IExprArraySize;

public class ArraySize extends Expr implements IExprArraySize {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	private Access term;
	public Access access() { return term; }
	
	public ArraySize(Token aTok, Access aTerm) {
		super(aTok, aTok);
		term = aTerm;
	}
	
	public Expr semanticChecks(VarTable aVT, SemFlags aS) {
		
		if (aS.noArrSizeOp()) {
			SemFlags.error(this, "array-size operator");
		}
		
		term.semanticChecks(aVT, aS);
		
		term.checkInputArray();
		
		type = new Type(EBasicType.INT);
		return this;
	}
	
	ArraySize syn_copy() {
		return new ArraySize(Common.copyToken(token),term.syn_copy());
	}
	
	public Expr expandHavoc(VarTable aVT) {
		return this;
	}
}
