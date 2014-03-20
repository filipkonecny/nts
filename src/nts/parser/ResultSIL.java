package nts.parser;

import nts.interf.base.IExpr;

public class ResultSIL {
	
	//true -- check satisfiability, false -- check validity
	private boolean checkSat;
	private VarTable vt;
	private IExpr ex;
	
	public boolean isCheckSat() { return checkSat; }
	public IExpr getExpr() { return ex; }
	public VarTable getVarTable() { return vt; }
	
	protected void setCheckSat(boolean val) { checkSat = val; }
	protected void setExprList(IExpr val) { ex = val; }
	protected void setVarTable(VarTable val) { vt = val; }
	
}
