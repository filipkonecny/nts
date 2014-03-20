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
 * An indexed access -- an accesses of the form <tt>a[i1]..[im]</tt>, 
 * where <tt>m>0</tt> and <tt>a</tt> is an array variable.
 * <p>
 * Indexed access can also represent the left-hand side of an array assignment (see ).
 *
 */
public interface IAccessIndexed extends IAccess, IExpr {
	/**
	 * 
	 * @return variable table entry for the accessed variable
	 */
	public IVarTableEntry var();
	/**
	 * 
	 * @return a non-empty list of index-expressions used in the array access
	 */
	public List<IExpr> indices();
}
