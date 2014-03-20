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

import nts.interf.base.IExprUn;

public abstract class OpUn extends Expr implements IExprUn {
	protected Expr op;
	
	public OpUn(Token aToken, Expr aOp) {
		super(aToken, aOp.first);
		op = aOp;
	}
	
	// interface
	public Expr operand() { return op; }
	/////////////////////////////////////////////////////
	
	public void operand(Expr aE) { op = aE; }
	
	public Expr semanticChecks(VarTable aVT, SemFlags seType) {
		
		op = op.semanticChecks(aVT,seType);
		
		return this;
	}
	
	public void renameVarTokens(Map<String,String> ren) {
		op.renameVarTokens(ren);
	}
	
	public Expr expandHavoc(VarTable aVT) {
		op = op.expandHavoc(aVT);
		return this;
	}
}
