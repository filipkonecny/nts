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

import org.antlr.runtime.Token;

import nts.interf.*;
import nts.interf.base.*;
import nts.interf.expr.IAccessBasic;

public class Subsystem extends AnnotatedBase implements ISubsystem {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	private VarTable vt;
	
	private Token nameToken;
	private Expr inst = null;
	
	private Map<String,IControlState> states = new HashMap<String,IControlState>();
	private List<IControlState> sInit = new LinkedList<IControlState>(),
			sFin = new LinkedList<IControlState>(),
			sErr = new LinkedList<IControlState>();
	
	private List<IVarTableEntry> in = new LinkedList<IVarTableEntry>(), out = new LinkedList<IVarTableEntry>();
	private List<ITransition> tt = new LinkedList<ITransition>();
	
	public Subsystem(VarTable aSt, Token aT) {
		vt = aSt;
		nameToken = aT;
	}
	
	public Subsystem copy_notDeep(String aName, VarTable aParent) {
		return new Subsystem(this, aName, aParent, false);
	}
	public Subsystem copy(String aName, VarTable aParent) {
		return new Subsystem(this, aName, aParent, true);
	}
	private Subsystem(Subsystem other, String aName, VarTable aParent, boolean deep) {
		//this(other.vt, NTSParser.dummyIDN_S(aName));
		nameToken = Common.tok_idn(aName);
		inst = (other.inst == null)? null : other.inst.syn_copy();
		
		// control states
		for (IControlState is : other.controlStates()) {
			ControlState s = (ControlState) is;
			this.getDeclareState(s.name());
		}
		for (IControlState is : other.marksInit()) {
			sInit.add(getState(is.name()));
		}
		for (IControlState is : other.marksFinal()) {
			sFin.add(getState(is.name()));
		}
		for (IControlState is : other.marksError()) {
			sErr.add(getState(is.name()));
		}
		
		// transitions
		for (ITransition it : other.tt) {
			Transition t = (Transition) it;
			ControlState from = this.getState(it.from().name());
			ControlState to = this.getState(it.to().name());
			this.addTransition(t.copy(from, to, deep));
		}
		
		// variable table
		this.vt = other.vt.copy(aParent, this);

		// in, out
		for (IVarTableEntry iv : other.in) {
			in.add(vt.get(iv.name()));
		}
		for (IVarTableEntry iv : other.out) {
			out.add(vt.get(iv.name()));
		}
		
	}
	void updateCallees(Map<Subsystem,Subsystem> aM) {
		for (ITransition it : tt) {
			if (it.label() instanceof Call) {
				Call c = (Call)it.label();
				c.setCallee(aM.get(c.callee()));
			}
		}
	}
	
	// interface
	public String name() { return nameToken.getText(); }
	public VarTable varTable() { return vt; }
	public Expr instances() { return inst; }
	public List<IControlState> marksInit() { return sInit; }
	public List<IControlState> marksFinal() { return sFin; }
	public List<IControlState> marksError() { return sErr; }
	public List<IVarTableEntry> varIn() { return in; }
	public List<IVarTableEntry> varOut() { return out; }
	public List<ITransition> transitions() { return tt; }
	
	void rename(String aName) {
		nameToken.setText(aName);
	}
	
	Token nameToken() { return nameToken; }
	
	void setInstances(Expr aInst) { inst = aInst; }
	public void addTransition(Transition aT) { tt.add(aT); }
	
//	public void declareState(ControlState aS) {
//		String name = aS.name();
//		if (states.get(name) != null) {
//			System.err.println("Semantic error at "+Common.at(aS.nameToken())+": redeclaration of a control state "+name+".");
//			System.exit(1);
//		}
//		states.put(name,aS);
//	}
	
//	public void declareState(String aName) {
//		declareState(Common.tok_idn(aName));
//	}
//	public void declareState(Token aT) {
//		declareState(aT,null);
//	}
	void declareState(Token aT, Annotations aAnnot) {
		String name = aT.getText();
		if (states.get(name) != null) {
			System.err.println("Semantic error at "+Common.at(aT)+": redeclaration of a control state "+name+".");
			System.exit(1);
		}
		ControlState s = getDeclareState(aT);
		s.setAnnotations(aAnnot);
	}
	public ControlState getState(String aName) {
		return (ControlState) states.get(aName);
	}
	public ControlState getDeclareState(String aName) {
		return (ControlState) getDeclareState(NTSParser.dummyIDN_S(aName));
	}
	public ControlState getDeclareState(Token aT) {
		String name = aT.getText();
		ControlState s = (ControlState)states.get(name);
		if (s == null) {
			s = new ControlState(aT);
			states.put(name, s);
		}
		return s;
	}
	private void checkAdd(Token aT, List<IControlState> aL) {
		IControlState s = getDeclareState(aT);
		if (aL.contains(s)) {
			System.err.println("Semantic error at "+Common.at(aT)+": multiple marking of a control state "+aT.getText()+".");
			System.exit(1);
		}
		aL.add(s);
	}
	void addInitial(Token aT) { checkAdd(aT,sInit); }
	void addFinal(Token aT) { checkAdd(aT,sFin); }
	void addError(Token aT) { checkAdd(aT,sErr); }
	
	public void unsetInital(ControlState aS) {
		sInit.remove(aS);
	}
	public void setInital(ControlState aS) {
		if (!sInit.contains(aS)) {
			sInit.add(aS);
		}
	}
	public void setFinal(ControlState aS) {
		if (!sFin.contains(aS)) {
			sFin.add(aS);
		}
	}
	
	public void setIn(VarTableEntry aVE) {
		in.add(aVE);
	}
	public void setOut(VarTableEntry aVE) {
		out.add(aVE);
	}
	
	private static void checkCallMatch(Subsystem caller, Subsystem callee, Call call) {
		// return values
		List<IAccessBasic> callerRet = call.returnVars();
		List<IVarTableEntry> calleeRet = callee.varOut();
		for (int i=0; i<callerRet.size(); i++) {
			
			AccessBasic a1 = (AccessBasic)callerRet.get(i);
			Type t1 = a1.type();
			//VarTableEntry e2 = (VarTableEntry)callee.vt.get(calleeRet.get(i));
			Type t2 = (Type)calleeRet.get(i).type();
			
			//if (!t1.matchesForAsgn(t2)) {
			if (!t1.matches(t2)) {
				System.err.println("Semantic error at "+Common.at(a1.first)+": type does not match with the callee's return type.");
				System.exit(1);
			}
		}
		
		// actual parameters
		List<IExpr> callerAct = call.actualParameters();
		List<IVarTableEntry> calleeIn = callee.varIn();
		for (int i=0; i<callerAct.size(); i++) {
			
			// note: expressions over NAT have integer type
			// check: 1) type of expression must match 
			
			Expr e1 = (Expr)callerAct.get(i);
			Type t1 = e1.type();
			
			//VarTableEntry e2 = (VarTableEntry)callee.vt.get(calleeIn.get(i));
			Type t2 = (Type)calleeIn.get(i).type();
			
			if (!t1.matches(t2)) {
				System.err.println("Semantic error at "+Common.at(e1.first())+": type of the expression does not match with the type of corresponding formal parameters.");
				System.exit(1);
			}
		}
	}
	
	void semanticChecks(VarTable aVT, Map<String, Subsystem> aSubs) {
		
		// semantic checks for declaration
		// annotations of local variables
		vt.semanticChecks();
		
		// annotations of subsystem
		super.semanticChecks(vt);
		// annotations of control states
		for (IControlState s : this.controlStates()) {
			((ControlState)s).semanticChecks(vt);
		}
		// annotations of transitions
		for (ITransition t : tt) {
			((Transition)t).semanticChecks(vt);
		}
		
		for (ITransition t : tt) {
			ILabel l = t.label();
			if (l instanceof Call) {
				Call c = (Call)l;
				Subsystem callee = aSubs.get(c.calleeToken().getText());
				c.setCallee(callee);
				if (callee == null) {
					System.err.println("Semantic error at "+Common.at(c.calleeToken())+": callee '"+c.calleeToken().getText()+"' is not defined.");
					System.exit(1);
				}
				
				// separate input and output arguments of calls, infer types
				c.semantic(callee.varIn().size(), callee.varOut().size(),vt);
				
				checkCallMatch(this,callee,c);
			} else {
				Expr e = ((Expr)l);
				SemFlags s = SemFlags.createGeneral();
				e = e.semanticChecks(vt,s);
				e.checkBool();
				((Transition)t).label(e);
			}
		}
	}
	public void expandHavoc() {
		for (ITransition t : transitions()) {
			ILabel lab = ((Transition)t).label();
			if (lab instanceof Expr) {
				Expr e = (Expr)lab; 
				((Transition)t).label(e.expandHavoc(vt));
			}
		}
	}
	
	@Override
	public List<IControlState> controlStates() {
		return new LinkedList<IControlState>(states.values());
	}
	
	
	public void renameVarTokens(Map<String,String> ren) {
		
		for (ITransition t : transitions()) {
			ILabel lab = ((Transition)t).label();
			if (lab instanceof Expr) {
				((Expr)lab).renameVarTokens(ren);
			} else {
				((Call)lab).renameVarTokens(ren);
			}
		}
		
	}
	
	public void prefixControlStates(String pref) {
		List<IControlState> states_cp = new LinkedList<IControlState>(states.values());
		states.clear();
		for (IControlState s : states_cp) {
			((ControlState)s).prefixControlState(pref);
			states.put(s.name(), s);
		}
	}
	
	public void renameCallees() {
		for (ITransition t : transitions()) {
			ILabel lab = ((Transition)t).label();
			if (lab instanceof Call) {
				((Call)lab).renameCalleeToken();
			}
		}
	}
	
	// "pastes" in the specified order in the beginning of "in" and "out"
	public void addInOutForGlobals(List<String> l_gi, List<String> l_go) {
		int aux = -1;
		for (String s : l_gi) {
			aux++;
			in.add(aux, vt.get(s));
		}
		aux = -1;
		for (String s : l_go) {
			aux++;
			out.add(aux, vt.get(s));
		}
	}
	
	public void passGlobalsViaCall(List<String> l_gi) {
		for (ITransition t : transitions()) {
			ILabel lab = ((Transition)t).label();
			if (lab instanceof Call) {
				((Call)lab).passGlobalsViaCall(l_gi);
			}
		}
	}

	private String giveStateWithPrefix(String aPref) {
		String name = aPref;
		if (this.states.containsKey(name)) {
			int aux = 0;
			while (true) {
				if (!this.states.containsKey(name+aux)) {
					name = name+aux;
					break;
				}
			}
		}
		return name;
	}
	
	private void uniqueIFEState(String aPref, boolean aIsInit, List<IControlState> aList) {
		String name = giveStateWithPrefix(aPref);
		
		ControlState s_new = this.getDeclareState(NTSParser.dummyIDN_S(name));

		for (IControlState is : aList) {
			ControlState s = (ControlState) is;
			Expr e = new Havoc(new LinkedList<Token>());
			ControlState source = (aIsInit)? s_new : s;
			ControlState dest = (aIsInit)? s : s_new;
			Transition t = new Transition(null, source, dest, e);
			addTransition(t);
		}
		
		aList.clear();
		aList.add(s_new);
	}
	public void uniqueInitialState(String aPref) {
		uniqueIFEState(aPref+"init", true, sInit);
	}
	public void uniqueErrorState(String aPref) {
		uniqueIFEState(aPref+"error", false, sErr);
	}
	public void uniqueFinalState(String aPref) {
		uniqueIFEState(aPref+"final", false, sFin);
	}
	// assumption: one final state with a relation-labeled transition
	public void setGlobalVarsToOutput(List<String> l_gi, List<String> l_go) {
		ControlState s_fin = (ControlState) sFin.get(0);
		Transition t = null;
		for (ITransition aux : tt) {
			if (aux.to().equals(s_fin)) {
				t = (Transition) aux;
				break;
			}
		}
		
		if (t == null)
			return;
		
		if (!l_gi.isEmpty()) {
			Expr e_aux = null;
			Iterator<String> ii = l_gi.iterator();
			Iterator<String> io = l_go.iterator();
			while (ii.hasNext()) {
				String si = ii.next()+"'";
				String so = io.next()+"'";
				
				Expr ei = new AccessBasic(NTSParser.dummyIDP_S(si));
				Expr eo = new AccessBasic(NTSParser.dummyIDP_S(so));
				Expr eeq = new ExEq(ei,eo);
				if (e_aux == null) {
					e_aux = eeq;
				} else {
					e_aux = new ExAnd(e_aux,eeq);
				}
			}
			
			Expr e = (Expr) t.label();
			Expr e_new = new ExAnd(e, e_aux);
			t.label(e_new);
		}
	}
	// assumption: one initial state with a relation-labeled transition
	public void plugPrecondition(Expr aPre) {
		
		if (aPre instanceof LitBool && ((LitBool)aPre).value())
			return;
		
		for (ITransition aux : tt) {
			if (sInit.contains(aux.from())) {
				Transition t = (Transition) aux;
				Expr e = (Expr) t.label();
				Expr e_new = new ExAnd(e, aPre);
				t.label(e_new);
			}
//			if (aux.from().equals(s_init)) {
//				t = (Transition) aux;
//				break;
//			}
		}
	}
	private void addVars(List<IVarTableEntry> l, String[] a) {
		for (String s : a) {
			l.add(vt.get(s));
		}
	}
	public void setInOutVars(String[] aIn, String[] aOut) {
		in.clear();
		out.clear();
		addVars(in,aIn);
		addVars(out,aOut);
		for (String s : aIn) {
			vt.get(s).setModifier(EModifier.IN);
		}
		for (String s : aOut) {
			vt.get(s).setModifier(EModifier.OUT);
		}
	}
//	public void removeCallTransitions() {
//		Iterator<ITransition> i = tt.iterator();
//		while (i.hasNext()) {
//			if (i.next().label() instanceof ICall) {
//				i.remove();
//			}
//		}
//	}
	
//	public void checkStates() {
//		for (ITransition it : tt) {
//			Transition t = (Transition) it;
//			if (states.get(t.from().name()) != t.from()) {
//				throw new RuntimeException();
//			}
//			if (states.get(t.to().name()) != t.to()) {
//				throw new RuntimeException();
//			}
//		}
//	}
	
	public void transformAssignmentsToGlobals(String aPrefV, String aPrefQ) {
		AuxForGlobal a4g = new AuxForGlobal(this.vt, aPrefV);
		for (ITransition it : new LinkedList<ITransition>(this.tt)) {
			if (it.label() instanceof Call) {
				Transition t = (Transition) it;
				Call c = (Call) it.label();
				List<VarTableEntry> l = c.transformAssignmentsToGlobals(a4g);
				if (!l.isEmpty()) {
					String aux_name = this.giveStateWithPrefix(aPrefQ);
					ControlState aux = this.getDeclareState(aux_name);
					ControlState to = t.to();
					t.to(aux);
					
					Expr e = null;
					List<String> l_havoc = new LinkedList<String>();
					Iterator<VarTableEntry> i = l.iterator();
					while (i.hasNext()) {
						VarTableEntry v_glob = i.next();
						VarTableEntry v_aux = i.next();
						ExEq eq = ASTWithoutToken.exEq(
								ASTWithoutToken.accessBasic(v_glob.name()),
								ASTWithoutToken.accessBasic(v_aux.counterpart().name())
								);
						if (e == null) {
							e = eq;
						} else {
							e = ASTWithoutToken.exAnd(e,eq);
						}
						l_havoc.add(v_glob.counterpart().name());
					}
					Havoc h = ASTWithoutToken.havoc_s(l_havoc);
					e = ASTWithoutToken.exAnd(e,h);
					Transition t_aux = new Transition(null, aux, to, e);
					this.addTransition(t_aux);
				}
			}
		}
	}
	
	private Set<IControlState> reach(boolean coreachable, Collection<IControlState> start) {
		Set<IControlState> visited = new HashSet<IControlState>();
		Set<IControlState> todo = new HashSet<IControlState>(start);
		while (!todo.isEmpty()) {
			IControlState s = todo.iterator().next();
			todo.remove(s);
			visited.add(s);
			for (ITransition t : this.tt) {
				IControlState from = (!coreachable)? t.from() : t.to();
				IControlState to = (!coreachable)? t.to() : t.from();
				if (s.equals(from) && !visited.contains(to)) {
					todo.add(to);
				}
						
			}
		}
		return visited;
	}
	public void removeUnreachable() {
		Set<IControlState> reach = reach(false,this.sInit);
		Set<IControlState> coreach = reach(true,this.sFin);
		coreach.addAll(reach(true,this.sErr));
		
		reach.retainAll(coreach);
		
		Iterator<ITransition> i = tt.iterator();
		while (i.hasNext()) {
			ITransition t = i.next();
			if (!reach.contains(t.from()) || !reach.contains(t.to())) {
				i.remove();
			}
		}
		
		// at least one dummy "false" transition
		if (tt.size() == 0) {
			IControlState to = null;
			if (!this.sFin.isEmpty()) {
				to = sFin.get(0);
			} else if (!this.sErr.isEmpty()) {
				to = sErr.get(0);
			}
			
			IControlState from = sInit.get(0);
			Expr e = ASTWithoutToken.litBool(false);
			Transition t = new Transition(null, (ControlState)from, (ControlState)to, e);
			this.addTransition(t);
		}
	}
	
}
