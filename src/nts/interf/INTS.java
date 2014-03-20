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
import java.util.Map;

import nts.interf.base.*;

/**
 * Interface for numerical transition systems (NTS).
 *
 */
public interface INTS extends IScope, IAnnotated, IVisitable {
	/**
	 * Name of the NTS.
	 */
	public String name();
	/**
	 * Initial condition (pre-condition) of the NTS. Returns 'true' expression if precondition is unspecified.
	 */
	public IExpr precondition();
	/**
	 * 
	 * @return list of subsystems
	 */
	public List<ISubsystem> subsystems();
	/**
	 * 
	 * @return map from subsystem names to number of instances
	 */
	public Map<String,IExpr> instances();
}
