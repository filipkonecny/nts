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

import nts.interf.base.IAnnotated;

public abstract class AnnotatedBase implements IAnnotated {
	
	// annotation interface
	private Annotations ann;
	public boolean isAnnotated() { return ann != null; }
	public Annotations annotations() { return ann; }
	public void setAnnotations(Annotations aAnn) { ann = aAnn; }
	
	private static SemFlags sfGen = SemFlags.createGeneral();
	protected void semanticChecks(VarTable aVT) {
		if (this.isAnnotated())
			ann.semanticChecks(aVT, sfGen);
	}
}
