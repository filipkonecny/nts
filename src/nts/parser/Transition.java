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

import org.antlr.runtime.Token;

import nts.interf.*;
import nts.interf.base.ILabel;
import nts.interf.base.IVisitor;

public class Transition extends AnnotatedBase implements ITransition {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	private Token id;
	private ControlState from, to;
	private ILabel label;
	
	public boolean hasID() { return id != null; }
	public String id() { return id == null? null : id.getText(); }
	public ControlState from() { return from; }
	public ControlState to() { return to; }
	public ILabel label() { return label; }
	void label(ILabel aL) { label = aL; }
	
	void to(ControlState aTo) { to = aTo; }
	void from(ControlState aFrom) { from = aFrom; }
	
	public Transition(Token aId, ControlState aFrom, ControlState aTo, ILabel aLabel) {
		id = aId;
		from = aFrom;
		to = aTo;
		label = aLabel;
	}
	
	public Transition copy(ControlState aFrom, ControlState aTo, boolean deep) {
		ILabel copy_l;
		if (label instanceof Call) {
			copy_l = ((Call)label).copy(deep);
		} else {
			copy_l = deep? ((Expr)label).syn_copy() : label;
		}
		Token copy_id = (id == null)? null : Common.copyToken(id);
		return new Transition(copy_id, aFrom, aTo, copy_l);
	}
}
