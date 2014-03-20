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
package nts.interf.expr;

import java.util.List;

import nts.interf.base.IAccess;
import nts.interf.base.IExpr;
import nts.interf.base.IVarTableEntry;

/**
 * Array Assignments. 
 * An array assignment has one of these forms: <pre> 
 *   (1)  a' = e
 *   (2)  a'[i1]..[in] OP [e1,..,en]   (when n > 0)
 *   (3)  a'[i1]..[im][j1,..,jn] OP [e1,..,en]   (where m >= 0, n >= 2)</pre>
 * <p>
 * where <tt>ik,jk,ek</tt> are expressions without further references to primed array variables, and <tt>OP</tt> is either
 * <ul>
 * <li>the <tt>'='</tt> operator (when the array access exposes an array) or
 * <li>a relational operator from <tt>{=,!=,<,<=,>,>=}</tt> (when the array access exposes a numerical value) or
 * <li>a logical operator from <tt>{&&,||,->,<->}</tt> (when the array access exposes a boolean value).
 * </ul>
 * <p>
 * 
 * Array assignments are represented by a AST sub-tree rooted at an operator node, 
 * with either IAccessBasic, IAccessIndexed, or IAccessMulti as its left child. In case
 * of a multiple assignment (case (3) above), the right child is IExprMany. 
 *
 */
public interface IAccessMulti extends IAccess, IExpr {
	/**
	 * 
	 * @return variable table entry for the accessed variable
	 */
	public IVarTableEntry var();
	/**
	 * 
	 * @return a non-empty list of index-expressions used in the array access
	 */
	public List<IExpr> singleInxs();
	public List<IExpr> multiInxs();
}
