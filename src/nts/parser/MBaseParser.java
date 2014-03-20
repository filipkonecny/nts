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

import org.antlr.runtime.*;

import nts.interf.base.EModifier;

public abstract class MBaseParser extends org.antlr.runtime.Parser {

	public MBaseParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	public abstract CommonToken dummyTrue();
	public abstract CommonToken dummyAnd();
	public abstract CommonToken dummyImpl();
	public abstract CommonToken dummyEquiv();
	public abstract CommonToken dummyLeq();
	public abstract CommonToken dummyTid();
	public abstract CommonToken dummyIDN(String s);
	public abstract CommonToken dummyIDP(String s);
	public abstract CommonToken dummyNum(int aVal);
	public abstract CommonToken dummyLparS();
	public abstract boolean isPrimedId(Token aToken);
	public abstract EModifier token2modifier(Token aToken);
}
