package nts.parser;

// parsing of individual expressions
public interface IParserListenerExpr extends IParserListener {

	public void exprParsingInit();
	public void exprParsingFinalize();
	
	public ResultExpr retriveResultExpr();
	
}
