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
package nts.interf.base;

/**
 * Basic types of variables.
 *
 */
public enum EBasicType {
	BOOL, INT, REAL;
	public boolean isBool() { return this == BOOL; }
	public boolean isInt() { return this == INT; }
	public boolean isReal() { return this == REAL; }
	/**
	 * 
	 * @return true if and only if either <tt>INT</tt> or <tt>REAL</tt>
	 */
	public boolean isNumeric() { return this != BOOL; }
}
