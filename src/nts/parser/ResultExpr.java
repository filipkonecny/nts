package nts.parser;

import java.util.List;

import nts.interf.base.IExpr;

public class ResultExpr {

	private List<IExpr> ex;
	private VarTable vt;
	
	public List<IExpr> getExprList() { return ex; }
	public VarTable getVarTable() { return vt; }
	protected void setExprList(List<IExpr> val) { ex = val; }
	protected void setVarTable(VarTable val) { vt = val; }
	
}
