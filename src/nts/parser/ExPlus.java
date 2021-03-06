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
import nts.interf.expr.IExprPlus;

import org.antlr.runtime.Token;

public class ExPlus extends OpBinArith implements IExprPlus {

	public void accept(IVisitor v) { v.visit(this); }
	
	public ExPlus(Expr aE1, Expr aE2) { this(null,aE1,aE2); }
	public ExPlus(Token aT, Expr aE1, Expr aE2) { super(aT,aE1,aE2); }
	
	public static ExPlus createRev(Token aT, Expr aE2, Expr aE1) { return new ExPlus(aT,aE1,aE2); }
	
	ExPlus syn_copy() { return new ExPlus(Common.copyToken(token),op1.syn_copy(),op2.syn_copy()); }
}
