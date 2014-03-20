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
import nts.interf.expr.ILitReal;

import org.antlr.runtime.Token;

public class LitReal extends Expr implements ILitReal {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	private float val;
	public float value() { return val; }
	
	public LitReal(float aVal) {
		super(null,null);
		val = aVal;
	}
	public LitReal(Token aToken) {
		super(aToken, aToken);
		val = Float.parseFloat(aToken.getText());
	}
	
	public Expr semanticChecks(VarTable aVT, SemFlags seType) {
		type = new Type(EBasicType.REAL);
		return this;
	}
	
	LitReal syn_copy() {
		LitReal ret = new LitReal(Common.copyToken(token));
		ret.val = val;
		return ret;
	}
	
	public Expr expandHavoc(VarTable aVT) {
		return this;
	}
	
}
