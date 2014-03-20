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
package client;

import java.io.*;
import java.util.*;

import nts.interf.*;
import nts.interf.base.*;
import nts.interf.expr.*;
import nts.parser.*;

@SuppressWarnings("incomplete-switch")
public class PrintVisitor implements IVisitor {
	
	private Writer sw;
    private IndentedWriter iw;
    
    public StringBuffer toStringBuffer() { return ((StringWriter)sw).getBuffer(); }
    public PrintVisitor() {
    	this(new StringWriter());
    }
    public PrintVisitor(Writer aW)     	{
    	sw = aW;
    	iw = new IndentedWriter(sw);
    }
	
	public static void main(String[] args) throws IOException {
		InputStream is;
	    if (args.length >= 1)
	      is = new FileInputStream(args[0]);
	    else 
	      is = System.in;
	    
	    ParserListener listen = new ParserListener();
	    
	    NTSParser.parseNTS(is, listen);
	    
	    NTS nts = listen.nts();
	    
	    PrintVisitor v = new PrintVisitor();
	    
	    nts.accept(v);
	    
	    System.out.println(v.toStringBuffer());
	    
	}
	
	private void annotations(IAnnotated e) {
		if (e.isAnnotated())
			e.annotations().accept(this);
	}
	
	@Override
	public void visit(INTS e) {
		// annotations
		annotations(e);
		
		// name
		iw.writeln("nts "+e.name()+";");
		
		// declarations
		e.varTable().accept(this);
		
		// precondition
		iw.write("init ");
		e.precondition().accept(this);
		iw.writeln(";");
		
		// instances
		iw.write("instances ");
		boolean b = false;
		for (Map.Entry<String, IExpr> entry : e.instances().entrySet()) {
			if (b) iw.write(", ");
			b = true;
			iw.write(entry.getKey()+"[");
			entry.getValue().accept(this);
			iw.write("]");
		}
		iw.writeln(";");
		
		// subsystems
		for (ISubsystem sub : e.subsystems())
			sub.accept(this);
	}
	
	private void marking(String kind, List<IControlState> states) {
		if (states.isEmpty())
			return;
		
		iw.write(kind+" ");
		boolean b = false;
		for (IControlState s : states) {
			if (b) iw.write(", ");
			b = true;
			iw.write(s.name());
		}
		iw.writeln(";");
	}
	
	private void annotatedStates(List<IControlState> states) {
		boolean b = false;
		for (IControlState s : states) {
			if (!s.isAnnotated())
				continue;
			if (!b) iw.write("states ");
			if (b) iw.write(", ");
			b = true;
			s.annotations().accept(this);
			iw.write(s.name());
		}
		if (b) iw.writeln(";");
	}
	
	@Override
	public void visit(ISubsystem e) {
		// annotations
		annotations(e); 
		
		// name
		iw.writeln(e.name()+" {");
		iw.indentInc();
		
		// input + output declaration
		declareInOut("in",e.varIn());
		declareInOut("out",e.varOut());
		
		
		// declarations
		e.varTable().accept(this);
		
		// declare annotated states
		annotatedStates(e.controlStates());
		// control states marking
		marking("initial", e.marksInit());
		marking("final", e.marksFinal());
		marking("error", e.marksError());
		
		// transitions
		for (ITransition t : e.transitions())
			t.accept(this);
		
		// end
		iw.indentDec();
		iw.writeln("}");
		
	}

	private void printAnnotation(String key, String type, String value) {
		iw.writeln("@"+key+":"+type+":"+value+";");
	}
	@Override
	public void visit(IAnnotations e) {
		for (String s : e.keysInt())
			printAnnotation(s,"int",""+e.getInt(s));
		for (String s : e.keysReal())
			printAnnotation(s,"real",""+e.getReal(s));
		for (String s : e.keysBool())
			printAnnotation(s,"bool",""+e.getBool(s));
		for (String s : e.keysString())
			printAnnotation(s,"string",""+e.getString(s));
		for (String s : e.keysFormula()) {
			iw.write("@"+s+":formula:");
			e.getFormula(s).accept(this);
			iw.writeln(";");
		}
	}

	@Override
	public void visit(IControlState e) {
		// we don't use this now
	}

	@Override
	public void visit(ITransition e) {
		// annotations
		annotations(e);
		
		// ID
		if (e.hasID())
			iw.write(e.id()+": ");
		
		// from -> to
		iw.write(e.from().name()+" -> "+e.to().name() + " { ");
		
		// label
		e.label().accept(this);
		
		// end
		iw.writeln(" }");
	}

	private void accessBasic(List<IAccessBasic> l) {
		Iterator<IAccessBasic> i = l.iterator();
		while (i.hasNext()) {
			iw.write(i.next().var().name());
			if (i.hasNext()) iw.write(",");
		}
	}
	
	@Override
	public void visit(ICall e) {
		int s = e.returnVars().size();
		if (s > 0) {
			if (s > 1) iw.write("(");
			accessBasic(e.returnVars());
			if (s > 1) iw.write(")");
			iw.write(" = ");
		}
		iw.write(e.callee().name()+"(");
		Iterator<IExpr> i = e.actualParameters().iterator();
		while (i.hasNext()) {
			i.next().accept(this);
			if (i.hasNext()) iw.write(",");
		}
		iw.write(")");
		
		/*
		if (e.hasHavoc()) {
			iw.write(" && ");
			e.havoc().accept(this);
		}
		*/
	}

	private void opUn(String op, IExprUn e) {
		iw.write(op+"(");
		e.operand().accept(this);
		iw.write(")");
	}
	private void opBin(String op, IExprBin e) {
		iw.write("(");
		e.operand1().accept(this);
		iw.write(op);
		e.operand2().accept(this);
		iw.write(")");
	}
	@Override
	public void visit(IExprNot e) {
		opUn("!",e);
	}

	@Override
	public void visit(IExprAnd e) {
		opBin(" && ",e);
	}

	@Override
	public void visit(IExprOr e) {
		opBin(" || ",e);
	}

	@Override
	public void visit(IExprImpl e) {
		opBin(" -> ",e);
	}

	@Override
	public void visit(IExprEquiv e) {
		opBin(" <-> ",e);
	}

	private void basicType(IType e) {
		String s = "";
		switch (e.basicType()) {
		case INT: s = "int"; break;
		case REAL: s = "real"; break;
		case BOOL: s = "bool"; break;
		}
		iw.write(s);
	}
	private void quantifierDecl(IExprQ e) {
		IType aux = null;
		Iterator<IVarTableEntry> i = e.varTable().innermostUnprimed().iterator();
		while (i.hasNext()) {
			IVarTableEntry ee = i.next();
			assert(ee.modifier() == EModifier.LOGICAL);
			if (aux != null) {
				assert(aux.basicType() == ee.type().basicType());
			} else {
				aux = ee.type();
				assert(aux.dimTotal() == 0);
			}
			
			iw.write(ee.name());
			if (i.hasNext()) iw.write(",");
		}
		iw.write(" : ");
		basicType(aux);
	}
	private void quantifier(IExprQ e) {
		quantifierDecl(e);
		iw.write(" . ");
		e.operand().accept(this);
	}
	@Override
	public void visit(IExprExists e) {
		iw.write("exists ");
		quantifier(e);
	}

	@Override
	public void visit(IExprForall e) {
		iw.write("forall ");
		quantifier(e);
	}

	@Override
	public void visit(IExprEq e) {
		opBin(" = ",e);
	}

	@Override
	public void visit(IExprNeq e) {
		opBin(" != ",e);
	}

	@Override
	public void visit(IExprLeq e) {
		opBin(" <= ",e);
	}

	@Override
	public void visit(IExprLt e) {
		opBin(" < ",e);
	}

	@Override
	public void visit(IExprGeq e) {
		opBin(" >= ",e);
	}

	@Override
	public void visit(IExprGt e) {
		opBin(" > ",e);
	}

	@Override
	public void visit(IExprMult e) {
		opBin("*",e);
	}

	@Override
	public void visit(IExprRemainder e) {
		opBin("%",e);
	}

	@Override
	public void visit(IExprDivide e) {
		opBin("/",e);
	}

	@Override
	public void visit(IExprPlus e) {
		opBin("+",e);
	}

	@Override
	public void visit(IExprMinus e) {
		opBin("-",e);
	}

	@Override
	public void visit(IExprUnaryMinus e) {
		opUn("-",e);
	}

	@Override
	public void visit(IExprArraySize e) {
		iw.write("|");
		e.access().accept(this);
		iw.write("|");
	}

	private void expressions(List<IExpr> l) {
		Iterator<IExpr> i = l.iterator();
		while(i.hasNext()) {
			i.next().accept(this);
			if (i.hasNext()) iw.write(",");
		}
	}
	private void expressionsSBracket(List<IExpr> l) {
		for (IExpr e : l) {
			iw.write("[");
			e.accept(this);
			iw.write("]");
		}
	}
	
	@Override
	public void visit(IExprList e) {
		iw.write("[");
		expressions(e.expressions());
		iw.write("]");
	}

	@Override
	public void visit(IAccessBasic e) {
		iw.write(e.var().name());
	}

	@Override
	public void visit(IAccessIndexed e) {
		iw.write(e.var().name());
		expressionsSBracket(e.indices());
	}

	@Override
	public void visit(IAccessMulti e) {
		iw.write(e.var().name());
		expressionsSBracket(e.singleInxs());
		iw.write("[");
		expressions(e.multiInxs());
		iw.write("]");
		
	}

	@Override
	public void visit(ILitBool e) {
		iw.write(e.value()? "true" : "false");
	}

	@Override
	public void visit(ILitInt e) {
		iw.write(""+e.value());
	}

	@Override
	public void visit(ILitReal e) {
		iw.write(""+e.value());
	}

	@Override
	public void visit(IHavoc e) {
		iw.write("havoc(");
		accessBasic(e.vars());
		iw.write(")");
	}

	private void declareInOut(String s, List<IVarTableEntry> l) {
		if (l.size() == 0)
			return;
		iw.write(s+" ");
		Iterator<IVarTableEntry> i = l.iterator();
		while (i.hasNext()) {
			i.next().accept(this);
			if (i.hasNext()) iw.write(", ");
		}
		iw.writeln(";");
	}
	
	// process modifiers PARAM, NO
	private void declarationNotInOut(IVarTableEntry e) {
		String m="";
		if (e.modifier() == EModifier.PARAM) {
			m = "par ";
		}
		
		iw.write(m);
		
		e.accept(this);
		
		iw.writeln(";");
	}

	@Override
	public void visit(IVarTable e) {
		for (IVarTableEntry ee : e.innermostUnprimed()) {
			switch(ee.modifier()) {
			case NO:
			case PARAM:
				declarationNotInOut(ee); break;
			}
		}
	}

	@Override
	public void visit(IVarTableEntry e) {
		annotations(e);
		
		iw.write(e.name());
		
		expressionsSBracket(e.size());
		for (int i=0; i<e.type().dimRef(); i++) {
			iw.write("[]");
		}
		
		iw.write(" : ");
		basicType(e.type());
	}

	@Override
	public void visit(IType e) {
		// we don't use this
	}

}
