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

import nts.interf.base.*;

import org.antlr.runtime.Token;

public class ParserListener implements IParserListenerSIL, IParserListenerExpr {

	// //////////////////////////////////
	// parsing of individual expressions
	// //////////////////////////////////
	private ResultExpr resultExpr = null;
	public void exprParsingInit() {
		resultExpr = new ResultExpr();
		VarTable vt = new VarTable(null);
		s_vt.push(vt);
	}
	public void exprParsingFinalize() {
		for (Expr e : s_ex) {
			e.semanticChecks(s_vt.peek(), SemFlags.createGeneral());
		}
		
		List<IExpr> ex_list = new LinkedList<IExpr>();
		while (!s_ex.isEmpty()) {
			ex_list.add(0, s_ex.pop());
		}
		resultExpr.setExprList(ex_list);
		resultExpr.setVarTable(s_vt.pop());

	}
	public ResultExpr retriveResultExpr() { return resultExpr; }

	// //////////////////////////////////
	// parsing of SIL formula
	// //////////////////////////////////
	private ResultSIL resultSIL = null;
	public void sil_check_sat() { resultSIL.setCheckSat(true); }
	public void sil_check_valid() { resultSIL.setCheckSat(false); }
	public void silParsingInit() {
		resultSIL = new ResultSIL();
		VarTable vt = new VarTable(null);
		s_vt.push(vt);
	}
	public void silParsingFinalize() {
		for (Expr e : s_ex) {
			e.semanticChecks(s_vt.peek(), SemFlags.createGeneral());
		}
		resultSIL.setVarTable(s_vt.pop());
		resultSIL.setExprList(s_ex.pop());
	}
	public ResultSIL retriveResultSIL() { return resultSIL; }
	
	// //////////////////////////////////
	// the actual NTS
	// //////////////////////////////////

	public NTS nts() {
		return nts;
	}

	// global NTS
	private NTS nts;
	// current subsystem
	private Subsystem sub;
	// variable table stack
	private Deque<VarTable> s_vt = new LinkedList<VarTable>();

	// has to be called after annotations are parsed
	public void ntsInit(Token aT) {
		VarTable vt = new VarTable(null);
		s_vt.push(vt);

		nts = new NTS(vt, aT);
		vt.setScope(nts);
		nts.setAnnotations(annot);

		// declare tid
		VarTableEntry tid = new VarTableEntry(Common.parser.dummyTid(),
				new Type(EBasicType.INT));
		tid.setModifier(EModifier.TID);
		tid.setScope(nts);
		vt.declare(tid);
	}

	public void ntsFinalize() {
		s_vt.pop();

		nts.semanticChecks();
	}

	public void instance(Token t) {
		nts.addInstance(t, s_ex.pop());
	}

	public void precondition() {
		nts.setPrecondition(s_ex.pop());
	}

	// has to be called after annotations are parsed
	public void subsystemInit(Token aT) {
		VarTable vt_glob = s_vt.peek();
		VarTable vt = new VarTable(vt_glob);
		s_vt.push(vt);

		sub = new Subsystem(vt, aT);
		sub.setAnnotations(annot);
		nts.addSubsystem(sub);

		vt.setScope(sub);
	}

	public void subsystemFinalize() {
		s_vt.pop();
		checkInitialMarking();
	}

	public void stateDeclaration(Token t) {
		sub.declareState(t, annot);
	}

	public void quantifierInit(Token t, boolean exists) {
		VarTable vt_last = s_vt.peek();
		VarTable vt = new VarTable(vt_last);
		s_vt.push(vt);

		Quantifier q = (exists) ? new ExExists(t, vt) : new ExForall(t, vt);
		vt.setScope(q);

		s_ex.push(q);

	}

	public void quantifierFinalize() {
		s_vt.pop();
		Expr e = s_ex.pop();
		Quantifier q = (Quantifier) s_ex.peek();

		q.setExpr(e);
	}

	private void checkRedeclaration(int n, String s, Token t) {
		if (n != 0) {
			System.err.println("Syntax error at " + Common.at(t)
					+ ": redeclaration of " + s + " states.");
			System.exit(1);
		}
	}

	public void checkInitFinErrRedeclaration(EMarkType mt, Token t) {
		switch (mt) {
		case INITIAL:
			checkRedeclaration(sub.marksInit().size(), "initial", t);
			break;
		case FINAL:
			checkRedeclaration(sub.marksFinal().size(), "final", t);
			break;
		case ERROR:
			checkRedeclaration(sub.marksError().size(), "error", t);
			break;
		default:
			throw new RuntimeException("internal error");
		}
	}

	public void markAdd(EMarkType type, Token t) {
		switch (type) {
		case INITIAL:
			sub.addInitial(t);
			break;
		case FINAL:
			sub.addFinal(t);
			break;
		case ERROR:
			sub.addError(t);
			break;
		default:
			throw new RuntimeException("internal error");
		}
	}

	private void checkInitialMarking() {
		if (sub.marksInit().size() == 0) {
			Token t = sub.nameToken();
			System.err
					.println("Error: No initial control state marked in subsystem '"
							+ t.getText() + "' (" + Common.at(t) + ").");
			System.exit(1);
		}
	}

	// current annotations
	private Annotations annot = null;

	public void setAnnotations(Annotations a) {
		annot = a;
	}

	public void setAnnotFirstTok(Token t) {
		annot.setFirstToken(t);
	}

	public void addAnnotIntRealBoolFormula(Token k, EAnnotType t) {
		Expr e = (Expr) s_ex.pop();
		switch (t) {
		case INT:
			annot.addInt(k, checkLitInt(e));
			break;
		case REAL:
			annot.addReal(k, checkLitReal(e));
			break;
		case BOOL:
			annot.addBool(k, checkLitBool(e));
			break;
		case FORMULA:
			annot.addFormula(k, e);
			break;
		default:
			throw new RuntimeException("internal error");
		}
	}

	public void addAnnotString(Token k, EAnnotType t, String s) {
		if (t != EAnnotType.STRING) {
			annotationErr(k);
		}
		annot.addString(k, s);
	}

	// current declaration modifier
	private EModifier modif = null;
	private Token modifTok = null;
	// variables waiting for basic type
	private List<VarTableEntry> s_ve = new LinkedList<VarTableEntry>();

	public void setModifier(Token t, EModifier m) {
		modif = m;
		modifTok = t;
		if ((m == EModifier.IN || m == EModifier.OUT) && sub == null) {
			System.err.println("Syntax error at " + Common.at(t)
					+ ": illegal modifier for the global scope: '"
					+ t.getText() + "'.");
			System.exit(1);
		}
		checkInOutMaxOnce(t, m);
	}

	public void setModifierNo() {
		modif = EModifier.NO;
		modifTok = null;
	}

	public void setModifier(EModifier m) {
		modif = m;
		modifTok = null;
	}

	public void declarationAdd(Token t, int own, int total) {
		Type type = new Type(total, own);

		VarTableEntry ve = new VarTableEntry(t, type, popNinterf(own));
		ve.setAnnotations(annot);
		ve.setModifier(modif);

		VarTable vt = s_vt.peek();
		ve.setScope(vt.scope());
		vt.declare(ve);

		// add in / out variables to input / output variable lists
		if (modif == EModifier.IN)
			sub.setIn(ve);
		if (modif == EModifier.OUT)
			sub.setOut(ve);

		// add to auxiliary list of declarations whose basic type is unknown yet
		s_ve.add(ve);
	}

	public void declarationSetBasicType(EBasicType t) {
		for (VarTableEntry ve : s_ve) {
			ve.setBasicType(t);
		}
		s_ve.clear();
	}

	public void checkInOutMaxOnce(Token aT, EModifier aM) {
		if (aM == EModifier.IN && !sub.varIn().isEmpty())
			errCheckDeclarInOut(aT, "input");
		if (aM == EModifier.OUT && !sub.varOut().isEmpty())
			errCheckDeclarInOut(aT, "output");
	}

	public void checkNoModifier() {
		if (modif != EModifier.NO) {
			System.err.println("Error at " + Common.at(modifTok)
					+ ". Unexpected modifier.");
			System.exit(1);
		}
	}

	public void checkNoAnnotation() {
		if (annot != null) {
			System.err.println("Error at " + Common.at(annot.first())
					+ ". Unexpected annotation.");
			System.exit(1);
		}
	}

	public void declarationQ(Token t) {
		Type type = new Type();
		VarTableEntry ve = new VarTableEntry(t, type, popNinterf(0));
		ve.setAnnotations(null);
		ve.setModifier(EModifier.LOGICAL);

		VarTable vt = s_vt.peek();
		ve.setScope(vt.scope());
		vt.declare(ve);

		// add to auxiliary list of declarations whose basic type is unknown yet
		s_ve.add(ve);
	}

	public void declarationQ(EBasicType type, Token bndTok) {
		Expr e1 = null;
		Expr e2 = null;
		if (bndTok != null) {
			e2 = s_ex.pop();
			e1 = s_ex.pop();

			if (type == EBasicType.BOOL) {
				System.err.println("Semantic error at " + Common.at(bndTok)
						+ ": Bounds on boolean variables not permitted.");
				System.exit(1);
			}
		}

		QDeclarBlock qdb = new QDeclarBlock(bndTok, e1, e2,
				new LinkedList<VarTableEntry>(s_ve));

		Quantifier q = (Quantifier) s_ex.peek();

		q.addDeclBlock(qdb);

		// set basic type and clear the list
		declarationSetBasicType(type);
	}

	private Call call;

	public void callInit() {
		call = new Call();
	}

	public void callSetCallee(Token aT) {
		call.setCallee(aT);
	}

	public void callAddArgRet(ECallArg code) {
		switch (code) {
		case ACTRET:
			call.addToAll(s_ex.pop());
			break;
		case ACT:
			call.addAct(s_ex.pop());
			break;
		case RET:
			call.addRet((AccessBasic) s_ex.pop());
			break;
		}
	}

	//public void callHavoc() {
	//	call.havoc((Havoc) s_ex.pop());
	//}

	public ILabel labelExpr() {
		return s_ex.pop();
	}

	public ILabel labelCall() {
		return call;
	}

	public ILabel labelDummyTrue(Token t) {
		return new LitBool(t, true);
	}

	public void transition(Token tName, Token tFrom, Token tTo, ILabel lab) {
		ControlState from = sub.getDeclareState(tFrom);
		ControlState to = sub.getDeclareState(tTo);
		Transition t = new Transition(tName, from, to, lab);
		t.setAnnotations(annot);

		sub.addTransition(t);
	}

	// expressions stack
	private Deque<Expr> s_ex = new LinkedList<Expr>();

	// private List<Expr> popN(int n) {
	// LinkedList<Expr> ret = new LinkedList<Expr>();
	// while (n > 0) {
	// n--;
	// ret.addFirst(s_ex.pop());
	// }
	// return ret;
	// }
	private List<IExpr> popNinterf(int n) {
		LinkedList<IExpr> ret = new LinkedList<IExpr>();
		while (n > 0) {
			n--;
			ret.addFirst(s_ex.pop());
		}
		return ret;
	}

	public void not(Token t) {
		s_ex.push(new ExNot(t, s_ex.pop()));
	}

	public void and(Token t) {
		s_ex.push(ExAnd.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	public void or(Token t) {
		s_ex.push(ExOr.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	public void impl(Token t) {
		s_ex.push(ExImpl.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	public void equiv(Token t) {
		s_ex.push(ExEquiv.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	// public void exprExists(Token t) { s_ex.push(new EExists(t, s_ex.pop()));
	// }
	// public void exprForall(Token t);

	public void eq(Token t) {
		s_ex.push(ExEq.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	public void neq(Token t) {
		s_ex.push(ExNeq.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	public void leq(Token t) {
		s_ex.push(ExLeq.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	public void lt(Token t) {
		s_ex.push(ExLt.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	public void geq(Token t) {
		s_ex.push(ExGeq.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	public void gt(Token t) {
		s_ex.push(ExGt.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	public void mult(Token t) {
		s_ex.push(ExMult.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	public void remainder(Token t) {
		s_ex.push(ExRemainder.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	public void divide(Token t) {
		s_ex.push(ExDivide.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	public void plus(Token t) {
		s_ex.push(ExPlus.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	public void minus(Token t) {
		s_ex.push(ExMinus.createRev(t, s_ex.pop(), s_ex.pop()));
	}

	public void unaryMinus(Token t) {
		s_ex.push(new ExUnaryMinus(t, s_ex.pop()));
	}

	public void access(Token t, int single, int multi) {
		Access a;
		if (single == 0 && multi == 0) {
			a = new AccessBasic(t);
		} else if (multi == 0) {
			a = new AccessIndexed(t, popNinterf(single));
		} else {
			a = new AccessMulti(t, popNinterf(multi), popNinterf(single));
		}
		s_ex.push(a);
	}

	public void exprList(Token t, int n) {
		if (n > 1)
			s_ex.push(new ExprList(t, popNinterf(n)));
		// else do nothing
	}

	public void arraySize(Token t) {
		Access e = (Access) s_ex.pop();
		if (e instanceof AccessMulti) {
			System.err
					.println("Error at "
							+ Common.at(t)
							+ ": Sizeof operator cannot be applied on multiple access.");
			System.exit(1);
		}
		s_ex.push(new ArraySize(t, e));
	}

	public void havoc(Token t, List<Token> l) {
		s_ex.push(new Havoc(t, l));
	}

	public void litTrue(Token t) {
		s_ex.push(new LitBool(t, true));
	}

	public void litFalse(Token t) {
		s_ex.push(new LitBool(t, false));
	}

	public void litInt(Token t) {
		s_ex.push(new LitInt(t));
	}

	public void litReal(Token t) {
		s_ex.push(new LitReal(t));
	}

	// ////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////
	void errExprClass(Token aT, String errText) {
		System.err.println("Syntax error at " + Common.at(aT) + ": " + errText
				+ " expected.");
		System.exit(1);
	}

	private void annotationErr(Token t) {
		System.err
				.println("Error at "
						+ Common.at(t)
						+ ". Annotation value does not match with the specified annotation type.");
		System.exit(1);
	}

	long checkLitInt(Expr aE) {
		Expr tmp = aE;
		long coef = 1;
		if (tmp instanceof ExUnaryMinus) {
			tmp = ((ExUnaryMinus) aE).operand();
			coef = -1;
		}
		if (!(tmp instanceof LitInt)) {
			errExprClass(aE.first(), "int-type literal");
		}
		return ((LitInt) tmp).value() * coef;
	}

	float checkLitReal(Expr aE) {
		Expr tmp = aE;
		int coef = 1;
		if (tmp instanceof ExUnaryMinus) {
			tmp = ((ExUnaryMinus) aE).operand();
			coef = -1;
		}
		if (!(tmp instanceof LitReal)) {
			errExprClass(aE.first(), "real-type literal");
		}
		return ((LitReal) tmp).value() * coef;
	}

	boolean checkLitBool(Expr aE) {
		if (!(aE instanceof LitBool)) {
			errExprClass(aE.first(), "bool-type literal");
		}
		return ((LitBool) aE).value();
	}

	// ///////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////

	void errCheckDeclarInOut(Token t, String errText) {
		System.err.println("Syntax error at " + Common.at(t) + ": " + errText
				+ " variables already declared.");
		System.exit(1);
	}

}
