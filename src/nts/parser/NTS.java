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

import nts.interf.*;
import nts.interf.base.IExpr;
import nts.interf.base.IVisitor;

import org.antlr.runtime.Token;
// no instance number specification and only one subsystem s --> s[1]
// no instance number specification and there is subsystem main --> main[1]
public class NTS extends AnnotatedBase implements INTS {
	
	public void accept(IVisitor v) { v.visit(this); }
	
	private Token name;
	public String name() { return name.getText(); }
		
	private static final String MAIN = "main";
	
	private VarTable vt; // global symbol table
	private Expr pre; // precondition on global variables
	private Map<String,Subsystem> sub = new HashMap<String,Subsystem>();
	
	private Map<Token, Expr> inst_tok = new HashMap<Token, Expr>(); // auxiliary mapping subsystem-name-token --> instance-number-expression
	private Map<String, Expr> inst;
	
	// interface
	public VarTable varTable() { return vt; }
	public Expr precondition() { return pre; }
	public List<ISubsystem> subsystems() {
		List<ISubsystem> ret = new ArrayList<ISubsystem>(sub.size());
		int i=0;
		for (Subsystem s : sub.values()) {
			ret.add(i++,s);
		}
		return ret; 
	}
	public Map<String,IExpr> instances() {
		Map<String,IExpr> ret = new HashMap<String,IExpr>();
		for (Map.Entry<String,Expr> e : inst.entrySet()) {
			ret.put(e.getKey(), e.getValue());
		}
		return ret; 
	}
	
	
	public NTS(VarTable aSt, Token aT) {
		vt = aSt;
		name = aT;
	}
	
	public NTS copy() {
		return new NTS(this);
	}
	private NTS(NTS other) {
		this.name = Common.copyToken(other.name);
		
		this.pre = other.pre.syn_copy();
		
		for (Map.Entry<Token,Expr> e : other.inst_tok.entrySet()) {
			Token copy_t = Common.copyToken(e.getKey());
			this.inst_tok.put(copy_t,e.getValue().syn_copy());
		}
		
		this.vt = other.vt.copy(null, this);
		
		// map used to re-link the "call graph"
		Map<Subsystem,Subsystem> s2s = new HashMap<Subsystem,Subsystem>();
		
		for (Subsystem s : other.sub.values()) {
			Subsystem copy_s = s.copy(s.name(),this.vt);
			s2s.put(s, copy_s);
			this.sub.put(copy_s.name(), copy_s);
		}
		
		// TODO: not needed, done in semanticCheck()
		for (Subsystem s : sub.values()) {
			s.updateCallees(s2s);
		}
		
		
		this.semanticChecks();
	}

	public void removeSubsystem(Subsystem aSub) {
		sub.remove(aSub.nameToken().getText());
	}
	public void addSubsystem(Subsystem aSub) {
		sub.put(aSub.nameToken().getText(), aSub);
	}
	void setPrecondition(Expr aPre) {
		pre = aPre;
	}
	public void addInstance(Token aT, Expr aE) {
		inst_tok.put(aT, aE);
	}
	public void addInstance(String aT, Expr aE) {
		addInstance(Common.tok_idn(aT),aE);
	}
	
	public void clearInstances() { 
		inst_tok.clear();
		inst.clear();
	}
	
	// creates the subsystem-name --> expression mapping
	private void checkInstances() {
		inst = new HashMap<String,Expr>();
		if (inst_tok.isEmpty()) {
			String entryName = null;
			if (sub.size() == 1)
				entryName = sub.keySet().iterator().next();
			else if (sub.containsKey(MAIN))
				entryName = MAIN;
			// no entry of the NTS is specified
			if (entryName == null) {
				System.err.println("Semantic error: No entry-point (neither the "+MAIN+" subsystem, nor a number of instances) of the NTS has been specified.");
				System.exit(1);
			// 'main' subsystem will is the entry
			} else {
				Expr aux = new LitInt(Common.parser.dummyNum(1));
				inst.put(entryName, aux);
				inst_tok.put(NTSParser.dummyIDN_S(entryName), aux);
				sub.get(entryName).setInstances(aux);
			}
		} else {
			for (Map.Entry<Token, Expr> e : inst_tok.entrySet()) {
				inst.put(e.getKey().getText(), e.getValue());
				Subsystem s;
				Token k = e.getKey();
				if ((s = sub.get(k.getText())) == null) {
					System.err.println("Semantic error at "+Common.at(k)+". Subsystem "+k.getText()+" is not defined.");
					System.exit(1);
				} else {
					s.setInstances(e.getValue());
				}
			}
		}
	}
	
	
	public void semanticChecks() {
		
		checkInstances();
		
		// semantic checks for declaration
		// including annotations of global variables
		vt.semanticChecks();
		
		// annotations of global NTS
		super.semanticChecks(vt);
		
		if (pre == null){
			pre = new LitBool(Common.parser.dummyTrue(),true);
		}
		
		{
			SemFlags s = SemFlags.createPrecondition();
			pre = pre.semanticChecks(vt, s);
			pre.checkBool();
		}
		
		// instances
		if (inst != null) {
			SemFlags s = SemFlags.createInstancesSpec();
			for (Expr e : inst.values()) {
				e.semanticChecks(vt, s);
				e.checkInt();
			}
		}
		
		// semantic checks for subsystems
		for (Subsystem s : sub.values()) {
			s.semanticChecks(vt, sub);
		}
	}
	
	public void renameSubsystem(Subsystem aS, String aName) {
		String nameOld = aS.name();
		
		if (inst != null && inst.containsKey(nameOld)) {
			Expr aux = inst.remove(nameOld);
			inst.put(aName,aux);
		}
		
		Token tok = null;
		for (Token t : inst_tok.keySet()) {
			if (t.getText().equals(nameOld)) {
				tok = t;
				break;
			}
		}
		if (tok != null) {
			Expr aux = inst_tok.remove(tok);
			tok.setText(aName);
			inst_tok.put(tok, aux);
		}
		
		sub.remove(nameOld);
		aS.rename(aName);
		sub.put(aName, aS);
		
		for (Subsystem s : this.sub.values()) {
			s.renameCallees();
		}
	}
	
	public void plugPrecondition(Subsystem aS) {
		plugPrecondition(null, aS);
	}
	public void plugPrecondition(Map<String,String> ren, Subsystem aS) {
		
		if (ren != null) {
			pre.renameVarTokens(ren);
		}
		aS.plugPrecondition(pre);
		pre = ASTWithoutToken.litBool(true);
		
	}
	
	public void expandHavoc() {
		for (ISubsystem s : this.subsystems()) {
			((Subsystem) s).expandHavoc();
		}
	}
	
	public void transformAssignmentsToGlobals(String aPrefV, String aPrefQ) {
		for (Subsystem s : this.sub.values()) {
			s.transformAssignmentsToGlobals(aPrefV, aPrefQ);
		}
	}
	
//	public void checkStates() {
//		for (Subsystem s : this.sub.values()) {
//			s.checkStates();
//		}
//	}
}
