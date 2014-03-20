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

import java.util.List;


/**
 * An entry of a variable table. Note that if a variable is annotated, its annotation is stored only 
 * at its unprimed entry.
 * @see IVarTable
 *
 */
public interface IVarTableEntry extends IAnnotated, IVisitable {
	/**
	 * 
	 * @return the name of the variable
	 */
	public String name();
	/**
	 * 
	 * @return the type of the variable
	 */
	public IType type();
	/**
	 * @return the declared array size. The length of the returned list is equal to <tt>type().dimOwn()</tt>
	 */
	public List<IExpr> size();
	/**
	 * 
	 * @return the modifier of the variable
	 */
	public EModifier modifier();
	/**
	 * 
	 * @return the scope where the variable is declared
	 */
	public IScope scope();
	/**
	 * @return the variable table where the variable is declared
	 */
	public IVarTable varTable();
	/**
	 * 
	 * @return true if and only if the variable is declared in a quantifier scope
	 */
	public boolean isLogical();
	/**
	 * 
	 * @return true if and only if the variable is declared in a subsystem scope
	 */
	public boolean isLocal();
	/**
	 * 
	 * @return true if and only if the variable is declared in the global scope
	 */
	public boolean isGlobal();
	
	/**
	 * 
	 * @return null if this entry represents a parameter, logical variable of <tt>TID</tt>. 
	 * Otherwise, returns entry for <tt>x'</tt> if this entry represents <tt>x</tt>, 
	 * and entry for <tt>x</tt> if this represents <tt>x'</tt>.
	 */
	public IVarTableEntry counterpart();

	/**
	 * 
	 * @return true if and only if the variable name ends with the prime symbol \'
	 */
	public boolean isPrimed();
}
