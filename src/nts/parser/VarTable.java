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

import java.lang.System;
import java.util.*;

import org.antlr.runtime.Token;

import nts.interf.base.*;

public class VarTable implements IVarTable {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	private Map<String, IVarTableEntry> table = new HashMap<String, IVarTableEntry>();
	private VarTable parent;
	private IScope scope;
	
	void parent(VarTable aParent) { parent = aParent; }
	
	// interface
	public IVarTable parent() { return parent; }
	public IScope scope() { return scope; }
	public List<IVarTableEntry> innermost() { 
		return new LinkedList<IVarTableEntry>(table.values()); 
	}
	public List<IVarTableEntry> innermostUnprimed() {
		List<IVarTableEntry> ret = new LinkedList<IVarTableEntry>();
		for (IVarTableEntry e : table.values()) {
			if (!e.isPrimed())
				ret.add(e);
		}
		return ret;
	}
	public List<IVarTableEntry> innermostUnprimedParam(boolean aParam) {
		List<IVarTableEntry> ret = innermostUnprimed();
		Iterator<IVarTableEntry> i = ret.iterator();
		while (i.hasNext()) {
			VarTableEntry e = (VarTableEntry) i.next();
			if (e.isParam() != aParam) {
				i.remove();
			}
		}
		return ret;
	}
	public List<IVarTableEntry> visible() {
		List<IVarTableEntry> ret = new LinkedList<IVarTableEntry>();
		VarTable ptr = this;
		while (ptr != null) {
			ret.addAll(ptr.innermost());
			ptr = ptr.parent;
		}
		return ret;
	}
	public List<IVarTableEntry> visibleUnprimed() {
		List<IVarTableEntry> ret = new LinkedList<IVarTableEntry>();
		VarTable ptr = this;
		while (ptr != null) {
			ret.addAll(ptr.innermostUnprimed());
			ptr = ptr.parent;
		}
		return ret;
	}
	
	public VarTable(VarTable aParent) {
		parent = aParent;
	}
	void setScope(IScope aScope) { scope = aScope; }
	
	public VarTable copy(VarTable aParent, IScope aScope) {
		VarTable copy = new VarTable(aParent);
		copy.setScope(aScope);
		
		for (IVarTableEntry iv : this.innermostUnprimed()) {
			VarTableEntry v = (VarTableEntry) iv;
			VarTableEntry copy_v = v.copy_unprimed();
			copy.declare(copy_v);
		}
		
		return copy;
	}
	
	public String toString() {
		String aux = table.keySet().toString();
		if (parent != null) {
			aux += "-->"+parent.toString();
		}
		return aux;
	}
	
	// return the entry for the given key if it exists or null
	public VarTableEntry get(String key) {
		VarTable ptr = this;
		while (ptr != null) {
			VarTableEntry ret = (VarTableEntry)ptr.table.get(key);
			if (ret != null)
				return ret;
			ptr = ptr.parent;
		}
		return null;
	}
	public boolean contains(String key) {
		return get(key) != null;
	}
	
	void declare(List<VarTableEntry> entries) {
		for (VarTableEntry e : entries) {
			declare(e);
		}
	}
	
	public void undeclare(String key) {
		VarTableEntry e = (VarTableEntry) table.remove(key);
		VarTableEntry e2 = e.counterpart();
		if (e2 != null) {
			table.remove(e2.name());
		}
	}
	
	// adds a new entry, check for re-declaration
	// (variable hiding from different scopes not allowed)
	public void declare(VarTableEntry entry) {
		
		entry.setVarTable(this);
		
		add(entry.name(), entry);
		
		// add entry for the primed version
		// (not for logical variables, parameters and TID)
		if (!entry.isLogical()) {
			switch (entry.modifier()) {
			case NO:
			case IN:
			case OUT:
			//case PARAM:
			//case LOGICAL:
			//case TID:
				VarTableEntry e2 = entry.createPrimed();
				add(e2.name(), e2);
				break;
			default:
				break;
			}
		}
	}
	private static void errRedeclaration(Token t1, Token t2) {
		System.err.println("Semantic error at "+Common.at(t1)+": Redeclaration of variable '"+t1.getText()+"' (already declared at "+Common.at(t2)+").");
		System.exit(1);
	}
	// adds and copies the scope
	private void add(String key, VarTableEntry entry) {
		IVarTableEntry e;
		if ((e = get(key)) != null) {
			Token t = entry.nameToken();
			Token t2 = ((VarTableEntry)e).nameToken();
			errRedeclaration(t,t2);
		}
		table.put(key, entry);
		entry.setScope(scope);
	}
	
	VarTableEntry checkDeclared(Token aT) {
		String s = aT.getText();
		VarTableEntry ret = get(s);
		
		// check if declared
		if (ret == null) {
			
			// to give better error messages ( = avoid "not declared" errors)
			// check that parameters, tid, logical variables are not accessed via primed versions
			String s_unp = s;
			if (Common.primed(s)) {
				s_unp = Common.unprime(s);
				VarTableEntry aux = get(s_unp);
				if (aux != null) {
					System.err.println("Semantic error at "+Common.at(aT)+": Primed access (\""+aT.getText()+"\") for parameters, tid, and logical vaiables is illegal.");
					System.exit(1);
				}
			}
			
			System.err.println("Semantic error at "+Common.at(aT)+": Variable \""+s_unp+"\" is not declared.");
			System.exit(1);
		}
		
		return ret;
	}
	
	private static SemFlags sfSize = SemFlags.createArraySizeSpec();
	private void checkArrSize() {
		for (IVarTableEntry ee : this.innermost()) {
			VarTableEntry e = (VarTableEntry)ee;
			if (e.type().isArray()) {
				if (	(e.modifier() == EModifier.IN || e.modifier() == EModifier.OUT) && 
						!e.type().isRefToArray() ) {
					System.err.println("Semantic error at "+Common.at(e.nameToken())+": Input and output array parameters must be pure array references.");
					System.exit(1);
				}
				//SemFlags s = SemFlags.create(SemFlags.fOnlyParam | SemFlags.fNoPrime | SemFlags.fIsInIndexTerm);
				for (IExpr eex : e.size()) {
					Expr ex = (Expr)eex;
					ex.semanticChecks(this, sfSize);
//					ex.checkArrDefSize(this);
				}
			}
		}
	}
	
	// check if variables in this scope are not hiding variables in super-scopes
	// (important for logical variables in global NTS / subsystem annotations -- which are specified before declaration of global / local variables)
	void checkRedeclaration(VarTable aParent) {
		
		if (aParent == parent)
			return;
		
		parent = aParent;
		
		VarTableEntry e2;
		for (IVarTableEntry ei : table.values()) {
			VarTableEntry e = (VarTableEntry) ei;
			if (e.isPrimed())
				continue;
			String s = e.name();
			if ((e2 = parent.get(s)) != null) {
				errRedeclaration(e.nameToken(),e2.nameToken());
			}
		}
	}
	
	//private static SemFlags sfGen = SemFlags.createGeneral();
	public void semanticChecks() {
		// annotations
		for (IVarTableEntry e : table.values()) {
			((VarTableEntry)e).semanticChecks(this);
		}
		
		checkArrSize();
	}
	
	public VarTableEntry declareLocalInt(String aName, EModifier aModif, IScope aScope) {
		VarTableEntry e = new VarTableEntry(aName, new Type(EBasicType.INT));
		e.setModifier(aModif);
		e.setScope(aScope);
		declare(e);
		return e;
	}
	public void declareLocalInt(List<String> aNames, EModifier aModif, IScope aScope) {
		for (String name : aNames) {
			declareLocalInt(name, aModif, aScope);
		}
	}
	public void renameInnermost(String aName, String aNameNew) {
		VarTableEntry v = (VarTableEntry) table.remove(aName);
		v.renameToken(aNameNew);
		declare(v);
	}

	public void eraseInnermostNonparam() {
		Iterator<Map.Entry<String, IVarTableEntry>> i = table.entrySet().iterator();
		while ( i.hasNext()) {
			if (!((VarTableEntry)(i.next().getValue())).isParam()) {
				i.remove();
			}
		}
	}
	public void eraseKey(String aK) {
		table.remove(aK);
	}
	public VarTableEntry declareNewWithPrefix(String aPref) {
		String name = aPref;
		if (this.get(aPref) != null) {
			int cnt=0;
			while (true) {
				name = aPref+cnt;
				if (this.get(name) == null) {
					break;
				}
				cnt++;
			}
		}
		return declareLocalInt(name, EModifier.NO, this.scope);
	}
}
