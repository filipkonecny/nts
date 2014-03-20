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

import org.antlr.runtime.Token;

public abstract class OpBinRel extends OpBin {
	
	protected OpBinRel(Token aT, Expr aE1, Expr aE2) { super(aT,aE1,aE2); }
	
	public Expr semanticChecks(VarTable aVT, SemFlags seType) {
		
		super.semanticChecks(aVT, seType);
		
		op1.checkNum();
		op2.checkNum();
		
		type = new Type(EBasicType.BOOL);
		
		return this;
		
	}
	Expr semanticChecksNumBool(VarTable aVT, SemFlags seType) {
		
		super.semanticChecks(aVT, seType);
		
		type = new Type(EBasicType.BOOL);
		
		return this;
		
	}
		
}
