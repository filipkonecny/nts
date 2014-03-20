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

import org.antlr.runtime.Token;
import org.antlr.runtime.CommonToken;

public class Common {
	
	public static String at(Token aToken) {
		return "[l:"+aToken.getLine()+",c:"+(aToken.getCharPositionInLine())+"]";
	}
	public static String at(Expr aE) {
		return at(aE.token());
	}
	
	public static MBaseParser parser;
	
	// creating primed counters out of unprimed
	public static CommonToken createPrimed(CommonToken other) {
		return NTSParser.dummyPrimed(other);
	}
	
	public static char PR = '\'' ;
	public static boolean primed(String s) {
		return s.charAt(s.length()-1) == PR;
	}
	public static String unprime(String s) {
		if (!primed(s))
			throw new RuntimeException("internal error");
		return s.substring(0, s.length()-1);
	}
	
	public static Token tok_idn(String aName) {
		return NTSParser.dummyIDN_S(aName);
	}
	public static Token tok_idp(String aName) {
		return NTSParser.dummyIDP_S(aName);
	}
	public static Token copyToken(Token t) {
		if (t == null)
			return null;
		return new CommonToken(t);
	}
	public static List<Token> copyTokens(List<Token> l) {
		List<Token> ret = new LinkedList<Token>();
		for (Token t : l) {
			ret.add(copyToken(t));
		}
		return ret;
	}
}
