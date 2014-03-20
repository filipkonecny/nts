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

/**
 * Interface for subsystems of numerical transition systems.
 *
 */
public interface ISubsystem extends IScope, IAnnotated, IVisitable {
	/**
	 * @return the name of the subsystem
	 */
	public String name();
	/**
	 * @return number of instances of the subsystem
	 */
	public IExpr instances();
	/**
	 * @return list of all control states 
	 */
	public List<IControlState> controlStates();
	/**
	 * @return list of control states marked as initial 
	 */
	public List<IControlState> marksInit();
	/**
	 * @return list of control states marked as final 
	 */
	public List<IControlState> marksFinal();
	/**
	 * @return list of control states marked as error 
	 */
	public List<IControlState> marksError();
	/**
	 * @return list of variables declared as input variables
	 */
	public List<IVarTableEntry> varIn();
	/**
	 * @return list of variables declared as output variables
	 */
	public List<IVarTableEntry> varOut();
	/**
	 * @return list of transitions
	 */
	public List<ITransition> transitions();
}
