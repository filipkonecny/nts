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

import nts.interf.base.IAnnotations;
import nts.interf.base.IExpr;
import nts.interf.base.IVisitor;

import org.antlr.runtime.Token;

public class Annotations implements IAnnotations {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	private Map<String,Long> a_int = new HashMap<String,Long>();
	private Map<String,Float> a_flo = new HashMap<String,Float>();
	private Map<String,Boolean> a_boo = new HashMap<String,Boolean>();
	private Map<String,String> a_str = new HashMap<String,String>();
	private Map<String,IExpr> a_expr = new HashMap<String,IExpr>();
	
	private Token first;
	private Map<String,Token> key2tok = new HashMap<String,Token>();
	
	Token first() { return first; }
	
	// interface methods
	
    public long getInt(String key) {
    	return a_int.get(key);
    }
	public float getReal(String key) {
		return a_flo.get(key);
	}
	public boolean getBool(String key) {
		return a_boo.get(key);
	}
	public String getString(String key) {
		return a_str.get(key);
	}
	public IExpr getFormula(String key) {
		return a_expr.get(key);
	}
	
	public Set<String> keysInt() { return a_int.keySet(); }
	public Set<String> keysReal() { return a_flo.keySet(); }
	public Set<String> keysBool() { return a_boo.keySet(); }
	public Set<String> keysString() { return a_str.keySet(); }
	public Set<String> keysFormula() { return a_expr.keySet(); }
	
	// sub-package methods
	
	private String setTokGetText(Token key) {
		String t = key.getText();
		key2tok.put(t, key);
		return t;
	}
	void addInt(Token key, long val) {
		a_int.put(setTokGetText(key), val);
	}
	void addReal(Token key, float val) {
		a_flo.put(setTokGetText(key), val);
	}
	void addBool(Token key, boolean val) {
		a_boo.put(setTokGetText(key), val);
	}
	void addString(Token key, String val) {
		a_str.put(setTokGetText(key), val);
	}
	void addFormula(Token key, Expr val) {
		a_expr.put(setTokGetText(key), val);
	}
	
	void setFirstToken(Token aToken) {
		first = aToken;
	}
	
	protected void semanticChecks(VarTable aVT, SemFlags seType) {
		for (IExpr ee : a_expr.values()) {
			Expr e = (Expr) ee;
			e.semanticChecks(aVT, seType);
		}
	}
	
}
