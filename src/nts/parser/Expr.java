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

import java.util.*;

import nts.interf.base.EBasicType;
import nts.interf.base.IExpr;
import nts.interf.base.ILabel;

import org.antlr.runtime.Token;

public abstract class Expr implements ILabel, IExpr {
	
	// lexical token that characterizes this expression
	// (e.g.  +,*,and,exists,?,| or e.g. 'id' in an array access id[e1]..[em] )
	protected Token token;
	// first token of the sub-phrase
	protected Token first;
	// type of the expression
	protected Type type;
	
	protected Expr(Token aToken, Token aFirst) {
		token = aToken;
		first = aFirst;
	}
	
	public Token token() { return token; }
	public Token first() { return first; }
	
	// interface //
	public Type type() { return type; }
	///////////////
	
	// blocking writes to all arrays and boolean scalars
	// can be unblocked by the '=' operator
	protected boolean blockWriteTo = true; // grants many-expr 
	
	public Expr semanticChecks(VarTable aVT) {
		return semanticChecks(aVT, SemFlags.createGeneral());
	}
	// abstract methods //
	public abstract Expr semanticChecks(VarTable aVT, SemFlags seType);
	abstract Expr syn_copy();
	//////////////////////
	
	public static Expr syn_copy(Expr aE) {
		return aE.syn_copy();
	}
	
	public void checkArrInx(VarTable aVT, SemFlags seType) {
		semanticChecks(aVT, seType);
		EBasicType bt = type.basicType();
		if (type.isArray() || bt != EBasicType.INT) {
			System.err.println("Semantic error at "+Common.at(first)+": expected type of expression: 'int' or 'nat'.");
			System.exit(1);
		}
	}
	public static void checkInt(List<IExpr> aL, VarTable aVT, SemFlags seType) {
		for (IExpr ee : aL) {
			Expr e = (Expr)ee;
			e.semanticChecks(aVT, seType);
			Type t = e.type();
			if (t.isArray() || !t.isInt()) {
				System.err.println("Semantic error at "+Common.at(e.first)+": expected type of expression: 'int'.");
				System.exit(1);
			}

		}
	}
	
	protected void checkArrSizeErr(String s) {
		System.err.println("Semantic error at "+Common.at(token)+". "+s+" cannot appear in array-size specification.");
		System.exit(1);
	}
	protected void checkArrSizeErrOp() {
		System.err.println("Semantic error at "+Common.at(token)+". Only operators {+,-,*,/,%,|..|} can appear in array-size definition.");
		System.exit(1);
	}
	protected void checkArrSizeErrType() {
		System.err.println("Semantic error around "+Common.at(token)+". " +
				"Size of arrays has to be a function of " +
				"\n\t1) integer parameters and " +
				"\n\t2) array-size operators on input array parameters of a subsystem.");
		System.exit(1);
	}
	
	// static methods
	static void copy(List<Expr> aFrom, List<IExpr> aTo) {
		for (Expr e : aFrom) {
			aTo.add(e);
		}
	}
	
	void checkBool() {
		if (!type.isBool()) {
			System.err.println("Semantic error at "+Common.at(first)+": boolean expression expected.");
			System.exit(1);
		}
	}
	void checkNum() {
		if (!type.isNum()) {
			System.err.println("Semantic error at "+Common.at(first)+": numerical expression expected.");
			System.exit(1);
		}
	}
	void checkInt() {
		if (!type.isInt()) {
			System.err.println("Semantic error at "+Common.at(first)+": integer expression expected.");
			System.exit(1);
		}
	}
	protected void checkBasic() {
		if (!type.isScalar()) {
			System.err.println("Semantic error at "+Common.at(first)+": basic type expression expected.");
			System.exit(1);
		}
	}
	protected void checkArray() {
		if (!type.isArray()) {
			System.err.println("Semantic error at "+Common.at(first)+": array expression expected.");
			System.exit(1);
		}
	}
	
	protected void checkBoolAtImplAsgn() {
		if (!type.isBool()) {
			//System.err.println("Syntax error after "+C.at(token())+": assignment operator expected.");
			System.err.println("Syntax error after "+Common.at(token)+": Invalid assignment to numerical array. Expected form: a' INDEXING OP RHS.");
			System.exit(1);
		}
	}
	
	public void renameVarTokens(Map<String,String> ren) {
		//throw new RuntimeException("internal error");
	}
	
	public abstract Expr expandHavoc(VarTable aVT);
}
