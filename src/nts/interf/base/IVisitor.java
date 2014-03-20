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
package nts.interf.base;

import nts.interf.*;
import nts.interf.expr.*;

/**
 * The visitor is responsible for determining the order of traversal. For instance, upon visiting the AND operator, 
 * the visitor is expected to invoke operand1.accept(this) and operand2.accept(this).
 *
 */
public interface IVisitor {
	public void visit(INTS e);
	public void visit(ISubsystem e);
	public void visit(IAnnotations e);
	public void visit(IControlState e);
	public void visit(ITransition e);
	public void visit(ICall e);
	// declarations
	public void visit(IVarTable e);
	public void visit(IVarTableEntry e);
	public void visit(IType e);
	// logical operators
	public void visit(IExprNot e);
	public void visit(IExprAnd e);
	public void visit(IExprOr e);
	public void visit(IExprImpl e);
	public void visit(IExprEquiv e);
	// quantifiers
	public void visit(IExprExists e);
	public void visit(IExprForall e);
	// relational operators
	public void visit(IExprEq e);
	public void visit(IExprNeq e );
	public void visit(IExprLeq e);
	public void visit(IExprLt e);
	public void visit(IExprGeq e);
	public void visit(IExprGt e);
	// arithmetical operators
	public void visit(IExprMult e);
	public void visit(IExprRemainder e);
	public void visit(IExprDivide e);
	public void visit(IExprPlus e);
	public void visit(IExprMinus e);
	public void visit(IExprUnaryMinus e);
	// array size
	public void visit(IExprArraySize e);
	// expression list
	public void visit(IExprList e);
	// variable access
	public void visit(IAccessBasic e);
	public void visit(IAccessIndexed e);
	public void visit(IAccessMulti e);
	// literals
	public void visit(ILitBool e);
	public void visit(ILitInt e);
	public void visit(ILitReal e);
	// havoc
	public void visit(IHavoc e);
}
