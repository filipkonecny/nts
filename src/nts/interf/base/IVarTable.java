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
 * A hierarchical variable table. There are three kinds of scopes:
 * the NTS (global) scope (for global variables), a subsystem scope (for local variables) 
 * and a scope for a quantifier-prefixed sub-formula (for logical variables).
 * Each scope keeps a reference to its parent scope. Note that the <tt>TID</tt> (thread ID)
 * is assigned to the global scope.
 * <p>
 * For each declared variable <tt>x</tt> with either of 
 * {@link EModifier#NO},{@link EModifier#IN},{@link EModifier#OUT} modifier, 
 * there are both unprimed <tt>x</tt> and primed <tt>x'</tt> entries in the symbol table.
 * For each declared variable <tt>x</tt> with either of 
 * {@link EModifier#PARAM},{@link EModifier#TID},{@link EModifier#LOGICAL} modifier,
 * there is only the unprimed <tt>x</tt> entry in the symbol table.
 */
public interface IVarTable extends IVisitable {
	/**
	 * @return an entry for a given key
	 */
	public IVarTableEntry get(String aKey);
	/**
	 * @return variable table for the parent scope
	 */
	public IVarTable parent();
	/**
	 * @return the scope to which this variable table belongs
	 */
	public IScope scope();
	/**
	 * @return all entries across variable table hierarchy (both primed and unprimed)
	 */
	public List<IVarTableEntry> visible();
	/**
	 * @return all unprimed entries across variable table hierarchy
	 */
	public List<IVarTableEntry> visibleUnprimed();
	/**
	 * @return entries in the innermost scope (both primed and unprimed)
	 */
	public List<IVarTableEntry> innermost();
	/**
	 * @return unprimed entries in the innermost scope
	 */
	public List<IVarTableEntry> innermostUnprimed();
}
