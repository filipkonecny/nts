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
import nts.interf.expr.IExprEq;

import org.antlr.runtime.Token;

public class ExEq extends OpBinRel implements IExprEq {

	public void accept(IVisitor v) { v.visit(this); }
	
	public ExEq(Expr aE1, Expr aE2) { this(null,aE1,aE2); }
	public ExEq(Token aT, Expr aE1, Expr aE2) { super(aT,aE1,aE2); }
	
	public static ExEq createRev(Token aT, Expr aE2, Expr aE1) { return new ExEq(aT,aE1,aE2); }
	
	ExEq syn_copy() { return new ExEq(Common.copyToken(token),op1.syn_copy(),op2.syn_copy()); }
	
//	private boolean isArrayWriteOrBool(VarTable aVT, Expr aE) {
//		if (op1 instanceof Access) {
//			Access a = (Access)op1;
//			VarTableEntry e = aVT.checkDeclared(a.token());
//			//VarTableEntry e = aVT.get(a.varName());
//			if (e.isPrimed() && (e.type().isArray() || e.type().isBool()) ) {
//				return true;
//			}
//		}
//		return false;
//	}
	private boolean isArrayWrite(VarTable aVT, Expr aE) {
		if (op1 instanceof Access) {
			Access a = (Access)op1;
			VarTableEntry e = aVT.checkDeclared(a.token());
			//VarTableEntry e = aVT.get(a.varName());
			if (e.isPrimed() && e.type().isArray()) {
				return true;
			}
		}
		return false;
	}

	private Expr semChecksArrayWrite(VarTable aVT, SemFlags aS, Expr eTo, Expr eFrom) {
		eTo.blockWriteTo = false;
		eTo.semanticChecks(aVT, aS);
		
		//eFrom.blockWriteFrom = false;
		SemFlags f = SemFlags.addNoPrimed(aS);
		eFrom.semanticChecks(aVT, f);
		
		// check if types match
		Type t1 = op1.type();
		Type t2 = op2.type();
		
		if (!t1.matches(t2)) {
			errNoMatch(token);
		}
		
		type = new Type(EBasicType.BOOL);
		
		return this;
	}
	
	public Expr semanticChecks(VarTable aVT, SemFlags aS) {
		
		// check for the array-assignment pattern
		if (!aS.noPrimed()) {
			
			if (isArrayWrite(aVT, op1)) {
				
				return semChecksArrayWrite(aVT,aS,op1,op2);
				
			} else if (isArrayWrite(aVT, op2)) {
				
				return semChecksArrayWrite(aVT,aS,op2,op1);
			}
		}
		
		//return super.semanticChecks(aVT, aS);
		return super.semanticChecksNumBool(aVT, aS);
	}
}
