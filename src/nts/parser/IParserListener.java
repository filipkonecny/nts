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

import java.util.List;

import nts.interf.base.EBasicType;
import nts.interf.base.EModifier;
import nts.interf.base.ILabel;

import org.antlr.runtime.Token;

public interface IParserListener {
	public void not(Token t);
	public void and(Token t);
	public void or(Token t);
	public void impl(Token t);
	public void equiv(Token t);
	
	public void eq(Token t);
	public void neq(Token t);
	public void leq(Token t);
	public void lt(Token t);
	public void geq(Token t);
	public void gt(Token t);
	
	public void mult(Token t);
	public void remainder(Token t);
	public void divide(Token t);
	public void plus(Token t);
	public void minus(Token t);
	public void unaryMinus(Token t);
	
	public void access(Token t, int single, int multi);
	public void exprList(Token t, int n);
	public void arraySize(Token t);
	public void havoc(Token t, List<Token> l);
	
	public void litTrue(Token t);
	public void litFalse(Token t);
	public void litInt(Token t);
	public void litReal(Token t);
	
	public void ntsInit(Token aT);
	public void ntsFinalize();
	public void instance(Token t);
	public void precondition();
	
	public void subsystemInit(Token aT);
	public void subsystemFinalize();
	public void stateDeclaration(Token t);
	public void checkInitFinErrRedeclaration(EMarkType mt, Token t);
	public void markAdd(EMarkType type, Token t);

	public void quantifierInit(Token t, boolean exists);
	public void quantifierFinalize();
	
	public void setAnnotations(Annotations a);
	public void setAnnotFirstTok(Token t);
	public void addAnnotIntRealBoolFormula(Token k, EAnnotType t);
	public void addAnnotString(Token k, EAnnotType t, String s);
	
	public void setModifier(Token t, EModifier m);
	public void setModifierNo();
	public void setModifier(EModifier m);
	
	public void declarationAdd(Token t, int own, int total);
	public void declarationSetBasicType(EBasicType t);
	public void checkInOutMaxOnce(Token aT, EModifier aM);
	public void checkNoModifier();
	public void checkNoAnnotation();
	
	public void declarationQ(Token t);
	public void declarationQ(EBasicType type, Token bndTok);
	
	public void callInit();
	public void callSetCallee(Token aT);
	public void callAddArgRet(ECallArg code);
	//public void callHavoc();
	
	public ILabel labelExpr();
	public ILabel labelCall();
	public ILabel labelDummyTrue(Token t);
	
	public void transition(Token tName, Token tFrom, Token tTo, ILabel lab);
	
}
