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

import java.util.Map;

import org.antlr.runtime.Token;

import nts.interf.base.EModifier;
import nts.interf.base.IAccess;

public abstract class Access extends Expr implements IAccess {
	
	// interface
	protected VarTableEntry entry;
	public VarTableEntry var() { return entry; }
	
	public String varName() { return token.getText(); }
	
	public abstract int accessDepth();
	public abstract int multiAccess();
	public abstract Access syn_copy();
	
	protected Access(Token aId) {
		super(aId,aId);
	}
	
	private void errorArrSizeSpec() {
		System.err.println("Semantic error at "+Common.at(token)+". Argument of the array-size operator " +
			"in array-size definition has to be an input array variable of a subsystem.");
		System.exit(1);
	}
	public void checkInputArray() {
		
		if (	entry.type().isScalar() ||
				entry.modifier() != EModifier.IN
				) {
			errorArrSizeSpec();
		}
	}
	
	// checks if declared, correct use of primed variable, parameters, correct depth of access
	protected void check_base(VarTable aVT, SemFlags seType) {
		
		// check if the variable is declared
		entry = aVT.checkDeclared(token);
		boolean b = entry.isPrimed();
		
		// correct use of primed variables
		if (seType.noPrimed() && entry.isPrimed()) {
			System.err.println("Error at "+Common.at(token)+": unprimed variable expected.");
			System.exit(1);
		}
		if (seType.onlyPrimed() && !entry.isPrimed()) {
			System.err.println("Error at "+Common.at(token)+": primed variable expected.");
			System.exit(1);
		}
		
		// correct use of parameters
		if (seType.onlyParameters() && entry.modifier() != EModifier.PARAM) {
			System.err.println("Error at "+Common.at(token)+": parameter expected.");
			System.exit(1);
		}
		
		// correct use of parameters
		if (seType.paramsOrInputSize() && 
				(entry.modifier() != EModifier.PARAM &&
				(!entry.type().isArray() || entry.modifier() != EModifier.IN) )) {
			errorArrSizeSpec();
		}
		
		Type tDeclar = entry.type();
		int ad = accessDepth();
		
		// check indexing
		if (seType.noIndexing() && ad > 0) {
			System.err.println("Error at "+Common.at(token)+": indexing not permitted in this context.");
			System.exit(1);
		}
		
		// indexing only arrays
		if (ad > 0 && !tDeclar.isArray()) {
			System.err.println("Semantic error at"+Common.at(token)+": Only array variables can be indexed.");
			System.exit(1);
		}
		
		
		// implicitly, writes to arrays and boolean scalars are blocked, as are all 
		if (this.blockWriteTo) {
			Type t = entry.type();
			//if (entry.isPrimed() && (t.isArray() || (t.isBool()) )) {
			if (entry.isPrimed() && t.isArray()) {
				System.err.println("Error at "+Common.at(token)+": writes to arrays can be done only using '=' operator.");
				System.exit(1);
			}
			if (this.multiAccess() > 1) {
				System.err.println("Error at "+Common.at(token)+": multi-access valid only in array-writes of the form a'[i1,..,im] = [e1,..,em].");
				System.exit(1);
			}
		} else {
			// unset
			this.blockWriteTo = true;
		}
		
		// checks if the access depth is OK
		int dT = tDeclar.dimTotal();
		int dO = tDeclar.dimOwn();
		if ( 	(b && ad != dT && ad != dO && ad != 0) ||
				(!b && ad > dT) ) {
			String aux;
			if (!b) {
				aux = "{0.."+dT+"}";
			} else {
				aux = ""+dO;
				if (dT!=dO)
					aux = aux + " or "+dT;
			}
			String aux2 = (b)? "written to" : "read";
			System.err.println("Semantic error at"+Common.at(token)+": Variable "+varName()+" can only be accessed ("+aux2+") at depth "+aux+".");
			System.exit(1);
		}
		
		// infer type of the access
		// inferred type: pure reference or basic type
		int ma = multiAccess()>1? multiAccess() : 0;
		type = Type.dummyManyPureArrRef(tDeclar.basicType(), dT-ad, ma);
	}
	
	public void renameVarTokens(Map<String,String> ren) {
		token.setText(ren.get(token.getText()));
		
		if (!(this instanceof AccessBasic))
			throw new RuntimeException("internal error");
	}
	
	public Expr expandHavoc(VarTable aVT) {
		return this;
	}
	
}
