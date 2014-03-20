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

import nts.interf.base.EBasicType;
import nts.interf.base.IVisitor;
import nts.interf.expr.ILitInt;

import org.antlr.runtime.Token;

public class LitInt extends Expr implements ILitInt {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	private long val;
	public long value() { return val; }
	
	public LitInt(int aVal) {
		super(null, null);
		val = aVal;
	}
	public LitInt(Token aToken) {
		super(aToken, aToken);
		val = Long.parseLong(aToken.getText());
	}
	
	public Expr semanticChecks(VarTable aVT, SemFlags seType) {
		type = new Type(EBasicType.INT);
		return this;
	}
	
	LitInt syn_copy() {
		LitInt ret = new LitInt(Common.copyToken(token));
		ret.val = val;
		return ret;
	}
	
	public Expr expandHavoc(VarTable aVT) {
		return this;
	}
}
