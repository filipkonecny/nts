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
import nts.interf.expr.ILitBool;

import org.antlr.runtime.Token;

public class LitBool extends Expr implements ILitBool {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	private boolean b;
	
	public boolean value() { return b; }
	
	public LitBool(boolean aB) { this(null, aB); }
	public LitBool(Token aT, boolean aB) {
		super(aT,aT);
		b = aB;
	}
	
	public static LitBool dummyTrue() {
		return new LitBool(Common.parser.dummyTrue(),true);
	}
	
	public Expr semanticChecks(VarTable aVT, SemFlags seType) {
		type = new Type(EBasicType.BOOL);
		return this;
	}
	
	LitBool syn_copy() {
		LitBool ret = new LitBool(Common.copyToken(token), b);
		ret.b = b;
		return ret;
	}
	
	public Expr expandHavoc(VarTable aVT) {
		return this;
	}
}
