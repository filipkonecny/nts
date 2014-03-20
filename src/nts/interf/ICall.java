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
package nts.interf;

import java.util.List;

import nts.interf.base.*;
import nts.interf.expr.IAccessBasic;

/**
 * Procedure call interface.
 * 
 */
public interface ICall extends ILabel, IVisitable {
	/**
	 * 
	 * @return name of the callee
	 */
	public ISubsystem callee();
	/**
	 * 
	 * @return the actual parameters
	 */
	public List<IExpr> actualParameters();
	/**
	 * 
	 * @return the return variables
	 */
	public List<IAccessBasic> returnVars();
	
	
	// deprecated //
	
	/**
	 * @deprecated  
	 * @return true iff the transition label contains a havoc part (transition of the form
	 * <tt> (y1', ... ,yn') = f(t1, ... ,tm) and havoc(x1, ... ,xo) </tt>
	 */
	//public boolean hasHavoc();
	/**
	 * @deprecated
	 * @return the havoc part of the transition label (null if there is not any)
	 */
	//public IHavoc havoc();
}
