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

import org.antlr.runtime.Token;

public class QDeclarBlock {
	public Token rangeStart;
	public Expr bnd_l, bnd_u;
	public List<VarTableEntry> vars;
	
	public QDeclarBlock(Token aRangeStart, Expr aBndL, Expr aBndR, List<VarTableEntry> aVars) {
		rangeStart = aRangeStart;
		bnd_l = aBndL;
		bnd_u = aBndR;
		vars = aVars;
	}
}
