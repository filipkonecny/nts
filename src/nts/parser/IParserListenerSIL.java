package nts.parser;

// parsing of formulas written in the array logic SIL
public interface IParserListenerSIL extends IParserListener {

	public void sil_check_sat();
	public void sil_check_valid();
	
	public void silParsingInit();
	public void silParsingFinalize();
	
	public ResultSIL retriveResultSIL();
}
