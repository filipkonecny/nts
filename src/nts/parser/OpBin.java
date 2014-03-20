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

import java.util.Map;

import org.antlr.runtime.Token;

import nts.interf.base.IExprBin;

public abstract class OpBin extends Expr implements IExprBin {
	protected Expr op1, op2;
	
	protected OpBin(Token aT, Expr aE1, Expr aE2) {
		super(aT,aE1.first);
		op1 = aE1;
		op2 = aE2;
	}
	
	// implement IExprBin interface in the abstract class
	public Expr operand1() { return op1; }
	public Expr operand2() { return op2; }
	/////////////////////////////////////////////////////
	
	public void operand1(Expr aE) { op1 = aE; }
	public void operand2(Expr aE) { op2 = aE; }
	
	static void errNoMatch(Token aTok) {
		System.err.println("Semantic error around operator "+aTok.getText()+" "+Common.at(aTok)+": types of operands don't match.");
		System.exit(1);
	}
	
	public Expr semanticChecks(VarTable aVT, SemFlags seType) {
		
		op1 = op1.semanticChecks(aVT, seType);
		op2 = op2.semanticChecks(aVT, seType);
		
		Type t1 = op1.type();
		Type t2 = op2.type();
		
		if (!t1.matches(t2)) {
			errNoMatch(token);
		}
		
		// only basic type
		op1.checkBasic();

		return this;
	}
	
	public void renameVarTokens(Map<String,String> ren) {
		op1.renameVarTokens(ren);
		op2.renameVarTokens(ren);
	}
	
	public Expr expandHavoc(VarTable aVT) {
		op1 = op1.expandHavoc(aVT);
		op2 = op2.expandHavoc(aVT);
		return this;
	}
}



