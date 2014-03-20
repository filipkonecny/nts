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
import nts.interf.base.IExpr;
import nts.interf.base.ILabel;
import nts.interf.base.IVisitor;
import nts.interf.expr.IAccessBasic;

public class Call implements ICall, ILabel {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	private Subsystem callee;
	private Token calleeTok;
	private List<IExpr> all = new LinkedList<IExpr>(); // actual parameters + return variables
	private List<IExpr> act = new LinkedList<IExpr>(); // actual parameters
	private List<IAccessBasic> ret = new LinkedList<IAccessBasic>(); // return variable

	//private Havoc havoc;
	//public void havoc(Havoc aHavoc) { havoc = aHavoc; }
	
	// interface
	public Subsystem callee() { return callee; }
	public List<IExpr> actualParameters() { return act; }
	public List<IAccessBasic> returnVars() { return ret; }
	//public boolean hasHavoc() { return havoc != null; }
	//public Havoc havoc() { return havoc; }
	
	Token calleeToken() { return calleeTok; }
	
	public Call() {}
	
	public Call copy(boolean deep) {
		Call copy = new Call();
		
		if (callee != null) { 
			copy.callee = callee;
		}
		if (calleeTok != null) { 
			copy.calleeTok = Common.copyToken(calleeTok);
		}
		//if (havoc != null) { 
		//	copy.havoc = havoc.syn_copy();
		//}
		
		for (IExpr ie : all) {
			copy.all.add( deep? ((Expr)ie).syn_copy() : ie );
		}
		for (IExpr ie : act) {
			copy.act.add( deep? ((Expr)ie).syn_copy() : ie );
		}
		for (IAccessBasic ie : ret) {
			copy.ret.add( deep? (IAccessBasic)((Expr)ie).syn_copy() : ie );
		}
		return copy;
	}
	
	public void setCallee(Token aT) { calleeTok = aT; }
	public void setCallee(Subsystem aS) { callee = aS; }
	public void addAct(IExpr aE) { act.add(aE); }
	public void addRet(IAccessBasic aE) { ret.add(aE); }
	public void addToAll(IExpr aE) { all.add(aE); }
	
	public void addAct(List<IExpr> aL) { act.addAll(aL); }
	
	private static void errRetVar(Expr e) {
		System.err.println("Semantic error at "+Common.at(e.first)+". Mismatch with callee's definition. Return (primed) variable expected.");
		System.exit(1);
	}
	// separate input and output arguments of calls, infer types
	void semantic(int nIn, int nOut, VarTable aVT) {
		
		int nTot = nIn+nOut;
		// after parsing, either 'act' and 'ret' is set, or 'all' is set
		
		// make sure that correct number of arguments and return variables is provided
		if (nTot != all.size() && nTot != act.size()+ret.size()) {
			System.err.println("Semantic error at "+Common.at(calleeTok)+". Number of in/out parameters does not match with definition of '"+callee()+"'.");
			System.exit(1);
		}
		
		// separate if not separated yet
		if (ret.size() + act.size() < nTot) {
			for (int i=0; i<nIn; i++) {
				act.add(all.get(i));
			}
			for (int i=nIn; i<nTot; i++) {
				Expr aux = (Expr)all.get(i);
				if (!(aux instanceof AccessBasic)) {
					errRetVar(aux);
				}
				ret.add((AccessBasic)aux);
			}
		}
		
		// actual parameters must be expressions over unprimed variables
		SemFlags fAct = SemFlags.createActParam();
		for (IExpr e : act) {
			Expr ee = (Expr)e;
			ee.semanticChecks(aVT,fAct);
		}
		SemFlags fRet = SemFlags.createRetParam();
		for (IAccessBasic a : ret) {
			Access aa = (Access)a;
			aa.blockWriteTo = false;
			aa.semanticChecks(aVT,fRet);
			if (!aa.entry.isPrimed()) {
				errRetVar(aa);
			}
		}
		//SemFlags fHav = SemFlags.createHavoc();
		//if (hasHavoc())
		//	havoc.semanticChecks(aVT,fHav);
	}
	
	public void renameVarTokens(Map<String,String> ren) {
		all.clear();
		for (IExpr e : act) {
			((Expr) e).renameVarTokens(ren);
		}
		for (IAccessBasic e : ret) {
			((AccessBasic) e).renameVarTokens(ren);
		}
		
		//if (havoc != null) {
		//	havoc.renameVarTokens(ren);
		//}
	}
	
	public void passGlobalsViaCall(List<String> globIn) {
		all.clear();
		int i=-1;
		for (String s : globIn) {
			i++;
			Expr e = new AccessBasic(NTSParser.dummyIDN_S(s));
			AccessBasic a = new AccessBasic(NTSParser.dummyIDP_S(s+"'"));
			act.add(i,e);
			ret.add(i,a);
		}
	}
	
	public void renameCalleeToken() {
		calleeTok.setText(callee.name());
	}
	
	// returns a list of even length of primed variables of the form a1',b1',a2',b2',...
	// where ai' is the return global variable and bi' is a new local variable that replaced it
	// note: works only for AccessBasic (no arrays)
	public List<VarTableEntry> transformAssignmentsToGlobals(AuxForGlobal a4g) {
		List<VarTableEntry> l = new LinkedList<VarTableEntry>();
		int i = 0;
		for (IAccessBasic r : ret) {
			if (r.var().isGlobal()) {
				AccessBasic a = (AccessBasic) r;
				//VarTableEntry e = aVt.declareNewWithPrefix(aPref).counterpart();
				VarTableEntry e = a4g.giveAuxPrimed(i++);
				l.add(a.var());
				l.add(e);
				a.replaceWithEntry(e);
			}
		}
		return l;
	}
}
