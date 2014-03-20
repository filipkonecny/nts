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

import java.util.LinkedList;
import java.util.List;

import nts.interf.base.*;

import org.antlr.runtime.Token;

public class ASTWithoutToken {

	private static Token accessToken(String aName) {
		Token tok;
		if (aName.charAt(aName.length() - 1) == '\'') {
			tok = NTSParser.dummyIDP_S(aName);
		} else {
			tok = NTSParser.dummyIDN_S(aName);
		}
		return tok;
	}
	public static AccessBasic accessBasic(String aName) { 
		return new AccessBasic(accessToken(aName));
	}
	public static AccessIndexed accessIndexed(String aName, List<IExpr> aI) { 
		return new AccessIndexed(accessToken(aName), aI);
	}
	public static AccessMulti accessMulti(String aName, List<IExpr> aM, List<IExpr> aS) { 
		return new AccessMulti(accessToken(aName), aM, aS);
	}

	public static ExExists exExists(VarTable aVT, Expr aE) { 
		ExExists ret = new ExExists(aVT);
		ret.setExpr(aE);
		return ret;
	}
	public static ExForall exForall(VarTable aVT, Expr aE) {
		ExForall ret = new ExForall(aVT);
		ret.setExpr(aE);
		return ret;
	}
	public static ExAnd exAnd(Expr aE1, Expr aE2) { return new ExAnd(aE1,aE2); }
	public static ExDivide exDivide(Expr aE1, Expr aE2) { return new ExDivide(aE1,aE2); }
	public static ExEq exEq(Expr aE1, Expr aE2) { return new ExEq(aE1,aE2); }
	public static ExEquiv exEquiv(Expr aE1, Expr aE2) { return new ExEquiv(aE1,aE2); }
	public static ExGeq exGeq(Expr aE1, Expr aE2) { return new ExGeq(aE1,aE2); }
	public static ExGt exGt(Expr aE1, Expr aE2) { return new ExGt(aE1,aE2); }
	public static ExImpl exImpl(Expr aE1, Expr aE2) { return new ExImpl(aE1,aE2); }
	public static ExLeq exLeq(Expr aE1, Expr aE2) { return new ExLeq(aE1,aE2); }
	public static ExLt exLt(Expr aE1, Expr aE2) { return new ExLt(aE1,aE2); }
	public static ExMinus exMinus(Expr aE1, Expr aE2) { return new ExMinus(aE1,aE2); }
	public static ExMult exMult(Expr aE1, Expr aE2) { return new ExMult(aE1,aE2); }
	public static ExNeq exNeq(Expr aE1, Expr aE2) { return new ExNeq(aE1,aE2); }
	public static ExNot exNot(Expr aE) { return new ExNot(aE); }
	public static ExOr exOr(Expr aE1, Expr aE2) { return new ExOr(aE1,aE2); }
	public static ExPlus exPlus(Expr aE1, Expr aE2) { return new ExPlus(aE1,aE2); }
	public static ExRemainder exRemainder(Expr aE1, Expr aE2) { return new ExRemainder(aE1,aE2); }
	public static ExUnaryMinus exUnaryMinus(Expr aE) { return new ExUnaryMinus(aE); }
	
	public static Havoc havoc(List<Token> aL) { return new Havoc(aL); }
	public static Havoc havoc_s(List<String> aL) {
		List<Token> l = new LinkedList<Token>();
		for (String s : aL) {
			l.add(NTSParser.dummyIDP_S(s));
		}
		return new Havoc(l);
	}
	
	public static LitBool litBool(boolean aB) { return new LitBool(aB); }
	public static LitInt litInt(int aVal) { return new LitInt(aVal); }
	public static LitReal litReal(int aVal) { return new LitReal(aVal); }
	
	public static void declareInt(VarTable aVarTable, String aName) {
		VarTableEntry e = new VarTableEntry(aName,new Type(EBasicType.INT));
		e.setModifier(EModifier.NO);
		aVarTable.declare(e);
	}
	public static void declareIntLogical(VarTable aVarTable, String aName) {
		VarTableEntry e = new VarTableEntry(aName,new Type(EBasicType.INT));
		e.setModifier(EModifier.LOGICAL);
		aVarTable.declare(e);
	}
}
