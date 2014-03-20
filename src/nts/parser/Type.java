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

import nts.interf.base.*;

public class Type implements IType {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	private EBasicType basicType;
	
	private int dimOwn, dimRef, dimTotal; // dimTotal = dimNonRel + dimRef;
	
	// artificial type for expression lists
	// 0 -- not using expression lists
	// x>0 -- expression list of size x
	private int many_expr = 0;
	
	////////////////////////
	// Interface methods ---
	public EBasicType basicType() { return basicType; }
	
	public boolean isScalar() { return many_expr == 0 && dimTotal == 0; }
	public boolean isArray() { return many_expr == 0 && dimTotal != 0; }
	
	public boolean isArrayOfBasic() { return many_expr == 0 && dimOwn != 0 && dimRef == 0; }
	public boolean isRefToArray() { return many_expr == 0 && dimOwn == 0 && dimRef != 0; }
	public boolean isArrayOfRef() { return many_expr == 0 && dimOwn != 0 && dimRef != 0; }
	
	public int dimRef() { return dimRef; }
	public int dimOwn() { return dimOwn; }
	public int dimTotal() { return dimTotal; }
	
	// --- Interface methods
	////////////////////////
	
	void setBasicType(EBasicType aType) {
		basicType = aType;
	}
	
	public Type() {
		this(0,0);
	}
	public Type(int aDimTotal, int aDimOwn) {
		dimTotal = aDimTotal;
		dimOwn = aDimOwn;
		dimRef = dimTotal - dimOwn;
	}
	// scalar type  -- for quantifier-scoped declarations (no arrays)
	public Type(EBasicType aType) {
		basicType = aType;
		dimOwn = 0; dimRef = 0; dimTotal = 0;
	}
	// pure reference
	private Type(EBasicType aType, int aDRef) {
		basicType = aType;
		dimRef = aDRef;
		dimTotal = aDRef;
		dimOwn = 0;
	}
	static Type dummyPureArrRef(EBasicType aType, int aN) {
		return new Type(aType, aN);
	}
	static Type dummyManyPureArrRef(EBasicType aType, int aN, int c) {
		Type t = new Type(aType, aN);
		t.many_expr = c;
		return t;
	}

	Type copy() {
		Type copy = new Type();
		copy.basicType = this.basicType;
		copy.dimOwn = this.dimOwn;
		copy.dimRef = this.dimRef;
		copy.dimTotal = this.dimTotal;
		copy.many_expr = this.many_expr;
		return copy;
	}
	
	// type-checking methods
	boolean isInt() { 
		return isScalar() && basicType == EBasicType.INT;
	}
	boolean isReal() { 
		return isScalar() && basicType == EBasicType.REAL;
	}
	boolean isBool() { 
		return isScalar() && basicType == EBasicType.BOOL;
	}
	boolean isNum() { 
		return isScalar() && (basicType == EBasicType.INT || basicType == EBasicType.REAL);
	}
	boolean matches(Type other) {
		return
			basicType == other.basicType &&
			dimTotal == other.dimTotal &&
			dimRef == other.dimRef &&
			many_expr == other.many_expr;
	}
//	// true if one can be replaced by the other on the RHS and still make a valid assignment
//	boolean matchesForAsgn(Type other) {
//		return
//			basicType == other.basicType &&
//			dimTotal == other.dimTotal &&
//			many_expr == other.many_expr;
//	}
	
}
