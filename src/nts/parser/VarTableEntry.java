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

import java.util.*;

import java.lang.System;

import org.antlr.runtime.Token;
import org.antlr.runtime.CommonToken;

import nts.interf.base.*;

// symbol table entry
public class VarTableEntry extends AnnotatedBase implements IVarTableEntry { 
	
	public void accept(IVisitor v) { v.visit(this); }
	
	private CommonToken nameToken;
	private Type type;
	private EModifier modif;
	private IScope scope = null;
	
	private VarTableEntry counterpart = null;
	private IVarTable varTable = null;
	
	private boolean primed = false;
	
	private List<IExpr> size;
	
	public String toString() { return name(); }
	
	public CommonToken nameToken() { return nameToken; }
	
	// interface
	public String name() { return nameToken.getText(); }
	public Type type() { return type; }
	public EModifier modifier() { return modif; }
	public IScope scope() { return scope; }
	public boolean isLogical() { return scope instanceof Quantifier; }
	public boolean isLocal() { return scope instanceof Subsystem; }
	public boolean isGlobal() { return scope instanceof NTS; }
	public VarTableEntry counterpart() { return counterpart; }
	public boolean isPrimed() { return primed; }
	public List<IExpr> size() { return size; }
	public IVarTable varTable() { return varTable; }
	
	public boolean isParam() { return modif == EModifier.PARAM; }
	
	VarTableEntry createPrimed() {
		VarTableEntry e2 = new VarTableEntry(this);
		e2.nameToken = Common.createPrimed(nameToken);
		e2.primed = true;
		
		this.setCounterpart(e2);
		e2.setCounterpart(this);
		
		return e2;
	}
	
	VarTableEntry(VarTableEntry other) {
		nameToken = other.nameToken;
		type = other.type;
		modif = other.modif;
		scope = other.scope;
		counterpart = other.counterpart;
		varTable = other.varTable;
		primed = other.primed;
		size = other.size;
	}
	
	VarTableEntry copy_unprimed() {
		List<IExpr> copy_size = new LinkedList<IExpr>();
		for (IExpr e : size) {
			copy_size.add(((Expr)e).syn_copy());
		}
		VarTableEntry copy = new VarTableEntry(Common.copyToken(nameToken),type.copy(),copy_size);
		copy.modif = this.modif;
		return copy;
	}
	
	// expects a name without prime 
	public VarTableEntry(String aName, Type aType) {
		this(NTSParser.dummyIDN_S(aName), aType);
	}
	
	public VarTableEntry(Token aToken, Type aType) {
		this(aToken, aType, new LinkedList<IExpr>());
	}
	VarTableEntry(Token aToken, Type aType, List<IExpr> aSize) {
		this(new CommonToken((CommonToken)aToken), aType, aSize);
	}
	VarTableEntry(CommonToken aToken, Type aType, List<IExpr> aSize) {
		nameToken = aToken;
		type = aType;
		size = aSize;
	}
	void setScope(IScope aScope) {
		scope = aScope;
	}
	void setBasicType(EBasicType aType) {
		type.setBasicType(aType);
	}
	void setCounterpart(VarTableEntry aVE) {
		counterpart = aVE;
	}
	void setVarTable(IVarTable aVT) {
		varTable = aVT;
	}
	public void setModifier(EModifier aModif) {
		if (	type.isArray() &&
				!type.isRefToArray() && 
				(aModif == EModifier.IN || aModif == EModifier.OUT)) {
			System.err.println("Semantic error at "+Common.at(nameToken)+", declaration of '"+nameToken.getText()+"'. Input and output arrays must be pure references.");
			System.exit(1);
		}
		
		modif = aModif;
	}
	
	static void setScope(IScope aScope, List<VarTableEntry> entries) {
		for (VarTableEntry e : entries) {
			e.setScope(aScope);
		}
	}
	
	public void renameToken(String aName) {
		nameToken.setText(aName);
	}
}
