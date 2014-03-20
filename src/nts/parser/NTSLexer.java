// $ANTLR 3.3 Nov 30, 2010 12:50:56 /home/filip/workspace/nts/src/nts/parser/NTS.g 2014-03-20 03:23:47

package nts.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class NTSLexer extends Lexer {
    public static final int EOF=-1;
    public static final int IDN=4;
    public static final int IDP=5;
    public static final int LITINT=6;
    public static final int LITREAL=7;
    public static final int CALL=8;
    public static final int NTS=9;
    public static final int AT=10;
    public static final int QUOTE=11;
    public static final int TRUE=12;
    public static final int FALSE=13;
    public static final int NOT=14;
    public static final int AND=15;
    public static final int OR=16;
    public static final int IMPL=17;
    public static final int EQUIV=18;
    public static final int C_NOT=19;
    public static final int C_AND=20;
    public static final int C_OR=21;
    public static final int C_IMPL=22;
    public static final int C_EQUIV=23;
    public static final int EXISTS=24;
    public static final int FORALL=25;
    public static final int EQ=26;
    public static final int NEQ=27;
    public static final int LEQ=28;
    public static final int LT=29;
    public static final int GEQ=30;
    public static final int GT=31;
    public static final int VBAR=32;
    public static final int PLUS=33;
    public static final int MINUS=34;
    public static final int MULT=35;
    public static final int DIVIDE=36;
    public static final int REMAINDER=37;
    public static final int LPAR=38;
    public static final int RPAR=39;
    public static final int LPAR_S=40;
    public static final int RPAR_S=41;
    public static final int LPAR_C=42;
    public static final int RPAR_C=43;
    public static final int DOT=44;
    public static final int COMMA=45;
    public static final int COLON=46;
    public static final int SEMICOLON=47;
    public static final int TBOOL=48;
    public static final int TINT=49;
    public static final int TREAL=50;
    public static final int TSTRING=51;
    public static final int TFORMULA=52;
    public static final int PARAM=53;
    public static final int IN=54;
    public static final int OUT=55;
    public static final int STATES=56;
    public static final int INITIAL=57;
    public static final int FINAL=58;
    public static final int ERROR=59;
    public static final int PRECONDITION=60;
    public static final int INSTANCES=61;
    public static final int HAVOC=62;
    public static final int TID=63;
    public static final int RELATION=64;
    public static final int ARR_LENGTH=65;
    public static final int SIL_CHECK=66;
    public static final int SIL_SAT=67;
    public static final int SIL_VALID=68;
    public static final int LITSTRING=69;
    public static final int WS=70;
    public static final int SINGLE_COMMENT=71;
    public static final int ML_COMMENT=72;

    // delegates
    // delegators

    public NTSLexer() {;} 
    public NTSLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public NTSLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/filip/workspace/nts/src/nts/parser/NTS.g"; }

    // $ANTLR start "NTS"
    public final void mNTS() throws RecognitionException {
        try {
            int _type = NTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:7:5: ( 'nts' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:7:7: 'nts'
            {
            match("nts"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NTS"

    // $ANTLR start "AT"
    public final void mAT() throws RecognitionException {
        try {
            int _type = AT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:8:4: ( '@' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:8:6: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT"

    // $ANTLR start "QUOTE"
    public final void mQUOTE() throws RecognitionException {
        try {
            int _type = QUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:9:7: ( '\"' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:9:9: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTE"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:10:6: ( 'true' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:10:8: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:11:7: ( 'false' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:11:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:12:5: ( 'not' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:12:7: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:13:5: ( 'and' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:13:7: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:14:4: ( 'or' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:14:6: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "IMPL"
    public final void mIMPL() throws RecognitionException {
        try {
            int _type = IMPL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:15:6: ( 'imply' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:15:8: 'imply'
            {
            match("imply"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IMPL"

    // $ANTLR start "EQUIV"
    public final void mEQUIV() throws RecognitionException {
        try {
            int _type = EQUIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:16:7: ( 'equiv' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:16:9: 'equiv'
            {
            match("equiv"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUIV"

    // $ANTLR start "C_NOT"
    public final void mC_NOT() throws RecognitionException {
        try {
            int _type = C_NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:17:7: ( '!' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:17:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "C_NOT"

    // $ANTLR start "C_AND"
    public final void mC_AND() throws RecognitionException {
        try {
            int _type = C_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:18:7: ( '&&' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:18:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "C_AND"

    // $ANTLR start "C_OR"
    public final void mC_OR() throws RecognitionException {
        try {
            int _type = C_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:19:6: ( '||' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:19:8: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "C_OR"

    // $ANTLR start "C_IMPL"
    public final void mC_IMPL() throws RecognitionException {
        try {
            int _type = C_IMPL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:20:8: ( '->' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:20:10: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "C_IMPL"

    // $ANTLR start "C_EQUIV"
    public final void mC_EQUIV() throws RecognitionException {
        try {
            int _type = C_EQUIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:21:9: ( '<->' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:21:11: '<->'
            {
            match("<->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "C_EQUIV"

    // $ANTLR start "EXISTS"
    public final void mEXISTS() throws RecognitionException {
        try {
            int _type = EXISTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:22:8: ( 'exists' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:22:10: 'exists'
            {
            match("exists"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXISTS"

    // $ANTLR start "FORALL"
    public final void mFORALL() throws RecognitionException {
        try {
            int _type = FORALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:23:8: ( 'forall' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:23:10: 'forall'
            {
            match("forall"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FORALL"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:24:4: ( '=' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:24:6: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "NEQ"
    public final void mNEQ() throws RecognitionException {
        try {
            int _type = NEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:25:5: ( '!=' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:25:7: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEQ"

    // $ANTLR start "LEQ"
    public final void mLEQ() throws RecognitionException {
        try {
            int _type = LEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:26:5: ( '<=' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:26:7: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEQ"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:27:4: ( '<' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:27:6: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "GEQ"
    public final void mGEQ() throws RecognitionException {
        try {
            int _type = GEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:28:5: ( '>=' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:28:7: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GEQ"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:29:4: ( '>' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:29:6: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "VBAR"
    public final void mVBAR() throws RecognitionException {
        try {
            int _type = VBAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:30:6: ( '|' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:30:8: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VBAR"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:31:6: ( '+' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:31:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:32:7: ( '-' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:32:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MULT"
    public final void mMULT() throws RecognitionException {
        try {
            int _type = MULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:33:6: ( '*' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:33:8: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULT"

    // $ANTLR start "DIVIDE"
    public final void mDIVIDE() throws RecognitionException {
        try {
            int _type = DIVIDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:34:8: ( '/' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:34:10: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIVIDE"

    // $ANTLR start "REMAINDER"
    public final void mREMAINDER() throws RecognitionException {
        try {
            int _type = REMAINDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:35:11: ( '%' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:35:13: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REMAINDER"

    // $ANTLR start "LPAR"
    public final void mLPAR() throws RecognitionException {
        try {
            int _type = LPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:36:6: ( '(' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:36:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAR"

    // $ANTLR start "RPAR"
    public final void mRPAR() throws RecognitionException {
        try {
            int _type = RPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:37:6: ( ')' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:37:8: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAR"

    // $ANTLR start "LPAR_S"
    public final void mLPAR_S() throws RecognitionException {
        try {
            int _type = LPAR_S;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:38:8: ( '[' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:38:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAR_S"

    // $ANTLR start "RPAR_S"
    public final void mRPAR_S() throws RecognitionException {
        try {
            int _type = RPAR_S;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:39:8: ( ']' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:39:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAR_S"

    // $ANTLR start "LPAR_C"
    public final void mLPAR_C() throws RecognitionException {
        try {
            int _type = LPAR_C;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:40:8: ( '{' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:40:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAR_C"

    // $ANTLR start "RPAR_C"
    public final void mRPAR_C() throws RecognitionException {
        try {
            int _type = RPAR_C;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:41:8: ( '}' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:41:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAR_C"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:42:5: ( '.' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:42:7: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:43:7: ( ',' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:43:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:44:7: ( ':' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:44:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:45:11: ( ';' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:45:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "TBOOL"
    public final void mTBOOL() throws RecognitionException {
        try {
            int _type = TBOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:46:7: ( 'bool' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:46:9: 'bool'
            {
            match("bool"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TBOOL"

    // $ANTLR start "TINT"
    public final void mTINT() throws RecognitionException {
        try {
            int _type = TINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:47:6: ( 'int' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:47:8: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TINT"

    // $ANTLR start "TREAL"
    public final void mTREAL() throws RecognitionException {
        try {
            int _type = TREAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:48:7: ( 'real' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:48:9: 'real'
            {
            match("real"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TREAL"

    // $ANTLR start "TSTRING"
    public final void mTSTRING() throws RecognitionException {
        try {
            int _type = TSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:49:9: ( 'string' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:49:11: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TSTRING"

    // $ANTLR start "TFORMULA"
    public final void mTFORMULA() throws RecognitionException {
        try {
            int _type = TFORMULA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:50:10: ( 'formula' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:50:12: 'formula'
            {
            match("formula"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TFORMULA"

    // $ANTLR start "PARAM"
    public final void mPARAM() throws RecognitionException {
        try {
            int _type = PARAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:51:7: ( 'par' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:51:9: 'par'
            {
            match("par"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PARAM"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:52:4: ( 'in' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:52:6: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "OUT"
    public final void mOUT() throws RecognitionException {
        try {
            int _type = OUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:53:5: ( 'out' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:53:7: 'out'
            {
            match("out"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OUT"

    // $ANTLR start "STATES"
    public final void mSTATES() throws RecognitionException {
        try {
            int _type = STATES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:54:8: ( 'states' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:54:10: 'states'
            {
            match("states"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STATES"

    // $ANTLR start "INITIAL"
    public final void mINITIAL() throws RecognitionException {
        try {
            int _type = INITIAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:55:9: ( 'initial' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:55:11: 'initial'
            {
            match("initial"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INITIAL"

    // $ANTLR start "FINAL"
    public final void mFINAL() throws RecognitionException {
        try {
            int _type = FINAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:56:7: ( 'final' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:56:9: 'final'
            {
            match("final"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FINAL"

    // $ANTLR start "ERROR"
    public final void mERROR() throws RecognitionException {
        try {
            int _type = ERROR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:57:7: ( 'error' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:57:9: 'error'
            {
            match("error"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ERROR"

    // $ANTLR start "PRECONDITION"
    public final void mPRECONDITION() throws RecognitionException {
        try {
            int _type = PRECONDITION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:58:14: ( 'init' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:58:16: 'init'
            {
            match("init"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRECONDITION"

    // $ANTLR start "INSTANCES"
    public final void mINSTANCES() throws RecognitionException {
        try {
            int _type = INSTANCES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:59:11: ( 'instances' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:59:13: 'instances'
            {
            match("instances"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INSTANCES"

    // $ANTLR start "HAVOC"
    public final void mHAVOC() throws RecognitionException {
        try {
            int _type = HAVOC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:60:7: ( 'havoc' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:60:9: 'havoc'
            {
            match("havoc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HAVOC"

    // $ANTLR start "TID"
    public final void mTID() throws RecognitionException {
        try {
            int _type = TID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:61:5: ( 'tid' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:61:7: 'tid'
            {
            match("tid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TID"

    // $ANTLR start "RELATION"
    public final void mRELATION() throws RecognitionException {
        try {
            int _type = RELATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:62:10: ( 'relation' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:62:12: 'relation'
            {
            match("relation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RELATION"

    // $ANTLR start "SIL_CHECK"
    public final void mSIL_CHECK() throws RecognitionException {
        try {
            int _type = SIL_CHECK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:63:11: ( 'check' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:63:13: 'check'
            {
            match("check"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SIL_CHECK"

    // $ANTLR start "SIL_SAT"
    public final void mSIL_SAT() throws RecognitionException {
        try {
            int _type = SIL_SAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:64:9: ( 'sat' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:64:11: 'sat'
            {
            match("sat"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SIL_SAT"

    // $ANTLR start "SIL_VALID"
    public final void mSIL_VALID() throws RecognitionException {
        try {
            int _type = SIL_VALID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:65:11: ( 'valid' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:65:13: 'valid'
            {
            match("valid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SIL_VALID"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:862:3: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:862:5: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:862:5: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\t' && LA1_0<='\n')||LA1_0=='\r'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "SINGLE_COMMENT"
    public final void mSINGLE_COMMENT() throws RecognitionException {
        try {
            int _type = SINGLE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:865:3: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:865:5: '//' (~ ( '\\r' | '\\n' ) )*
            {
            match("//"); 

            // /home/filip/workspace/nts/src/nts/parser/NTS.g:865:10: (~ ( '\\r' | '\\n' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:865:11: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SINGLE_COMMENT"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:868:3: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:868:5: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /home/filip/workspace/nts/src/nts/parser/NTS.g:868:10: ( options {greedy=false; } : . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='*') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='/') ) {
                        alt3=2;
                    }
                    else if ( ((LA3_1>='\u0000' && LA3_1<='.')||(LA3_1>='0' && LA3_1<='\uFFFF')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<=')')||(LA3_0>='+' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:868:38: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match("*/"); 

             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "IDP"
    public final void mIDP() throws RecognitionException {
        try {
            int _type = IDP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:871:3: ( IDN '\\'' )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:871:5: IDN '\\''
            {
            mIDN(); 
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDP"

    // $ANTLR start "IDN"
    public final void mIDN() throws RecognitionException {
        try {
            int _type = IDN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:874:3: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:874:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/filip/workspace/nts/src/nts/parser/NTS.g:874:32: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDN"

    // $ANTLR start "LITREAL"
    public final void mLITREAL() throws RecognitionException {
        try {
            int _type = LITREAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:877:3: ( LITINT DOT LITINT )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:877:5: LITINT DOT LITINT
            {
            mLITINT(); 
            mDOT(); 
            mLITINT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LITREAL"

    // $ANTLR start "LITINT"
    public final void mLITINT() throws RecognitionException {
        try {
            int _type = LITINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:880:3: ( ( '0' .. '9' )+ )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:880:5: ( '0' .. '9' )+
            {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:880:5: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:880:6: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LITINT"

    // $ANTLR start "LITSTRING"
    public final void mLITSTRING() throws RecognitionException {
        try {
            int _type = LITSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:883:3: ( QUOTE ( options {greedy=false; } : ~ ( '\\r' | '\\n' ) )* QUOTE )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:883:5: QUOTE ( options {greedy=false; } : ~ ( '\\r' | '\\n' ) )* QUOTE
            {
            mQUOTE(); 
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:883:11: ( options {greedy=false; } : ~ ( '\\r' | '\\n' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\"') ) {
                    alt6=2;
                }
                else if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:883:40: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            mQUOTE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LITSTRING"

    public void mTokens() throws RecognitionException {
        // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:8: ( NTS | AT | QUOTE | TRUE | FALSE | NOT | AND | OR | IMPL | EQUIV | C_NOT | C_AND | C_OR | C_IMPL | C_EQUIV | EXISTS | FORALL | EQ | NEQ | LEQ | LT | GEQ | GT | VBAR | PLUS | MINUS | MULT | DIVIDE | REMAINDER | LPAR | RPAR | LPAR_S | RPAR_S | LPAR_C | RPAR_C | DOT | COMMA | COLON | SEMICOLON | TBOOL | TINT | TREAL | TSTRING | TFORMULA | PARAM | IN | OUT | STATES | INITIAL | FINAL | ERROR | PRECONDITION | INSTANCES | HAVOC | TID | RELATION | SIL_CHECK | SIL_SAT | SIL_VALID | WS | SINGLE_COMMENT | ML_COMMENT | IDP | IDN | LITREAL | LITINT | LITSTRING )
        int alt7=67;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:10: NTS
                {
                mNTS(); 

                }
                break;
            case 2 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:14: AT
                {
                mAT(); 

                }
                break;
            case 3 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:17: QUOTE
                {
                mQUOTE(); 

                }
                break;
            case 4 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:23: TRUE
                {
                mTRUE(); 

                }
                break;
            case 5 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:28: FALSE
                {
                mFALSE(); 

                }
                break;
            case 6 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:34: NOT
                {
                mNOT(); 

                }
                break;
            case 7 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:38: AND
                {
                mAND(); 

                }
                break;
            case 8 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:42: OR
                {
                mOR(); 

                }
                break;
            case 9 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:45: IMPL
                {
                mIMPL(); 

                }
                break;
            case 10 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:50: EQUIV
                {
                mEQUIV(); 

                }
                break;
            case 11 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:56: C_NOT
                {
                mC_NOT(); 

                }
                break;
            case 12 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:62: C_AND
                {
                mC_AND(); 

                }
                break;
            case 13 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:68: C_OR
                {
                mC_OR(); 

                }
                break;
            case 14 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:73: C_IMPL
                {
                mC_IMPL(); 

                }
                break;
            case 15 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:80: C_EQUIV
                {
                mC_EQUIV(); 

                }
                break;
            case 16 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:88: EXISTS
                {
                mEXISTS(); 

                }
                break;
            case 17 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:95: FORALL
                {
                mFORALL(); 

                }
                break;
            case 18 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:102: EQ
                {
                mEQ(); 

                }
                break;
            case 19 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:105: NEQ
                {
                mNEQ(); 

                }
                break;
            case 20 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:109: LEQ
                {
                mLEQ(); 

                }
                break;
            case 21 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:113: LT
                {
                mLT(); 

                }
                break;
            case 22 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:116: GEQ
                {
                mGEQ(); 

                }
                break;
            case 23 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:120: GT
                {
                mGT(); 

                }
                break;
            case 24 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:123: VBAR
                {
                mVBAR(); 

                }
                break;
            case 25 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:128: PLUS
                {
                mPLUS(); 

                }
                break;
            case 26 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:133: MINUS
                {
                mMINUS(); 

                }
                break;
            case 27 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:139: MULT
                {
                mMULT(); 

                }
                break;
            case 28 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:144: DIVIDE
                {
                mDIVIDE(); 

                }
                break;
            case 29 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:151: REMAINDER
                {
                mREMAINDER(); 

                }
                break;
            case 30 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:161: LPAR
                {
                mLPAR(); 

                }
                break;
            case 31 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:166: RPAR
                {
                mRPAR(); 

                }
                break;
            case 32 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:171: LPAR_S
                {
                mLPAR_S(); 

                }
                break;
            case 33 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:178: RPAR_S
                {
                mRPAR_S(); 

                }
                break;
            case 34 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:185: LPAR_C
                {
                mLPAR_C(); 

                }
                break;
            case 35 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:192: RPAR_C
                {
                mRPAR_C(); 

                }
                break;
            case 36 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:199: DOT
                {
                mDOT(); 

                }
                break;
            case 37 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:203: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 38 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:209: COLON
                {
                mCOLON(); 

                }
                break;
            case 39 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:215: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 40 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:225: TBOOL
                {
                mTBOOL(); 

                }
                break;
            case 41 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:231: TINT
                {
                mTINT(); 

                }
                break;
            case 42 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:236: TREAL
                {
                mTREAL(); 

                }
                break;
            case 43 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:242: TSTRING
                {
                mTSTRING(); 

                }
                break;
            case 44 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:250: TFORMULA
                {
                mTFORMULA(); 

                }
                break;
            case 45 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:259: PARAM
                {
                mPARAM(); 

                }
                break;
            case 46 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:265: IN
                {
                mIN(); 

                }
                break;
            case 47 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:268: OUT
                {
                mOUT(); 

                }
                break;
            case 48 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:272: STATES
                {
                mSTATES(); 

                }
                break;
            case 49 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:279: INITIAL
                {
                mINITIAL(); 

                }
                break;
            case 50 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:287: FINAL
                {
                mFINAL(); 

                }
                break;
            case 51 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:293: ERROR
                {
                mERROR(); 

                }
                break;
            case 52 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:299: PRECONDITION
                {
                mPRECONDITION(); 

                }
                break;
            case 53 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:312: INSTANCES
                {
                mINSTANCES(); 

                }
                break;
            case 54 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:322: HAVOC
                {
                mHAVOC(); 

                }
                break;
            case 55 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:328: TID
                {
                mTID(); 

                }
                break;
            case 56 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:332: RELATION
                {
                mRELATION(); 

                }
                break;
            case 57 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:341: SIL_CHECK
                {
                mSIL_CHECK(); 

                }
                break;
            case 58 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:351: SIL_SAT
                {
                mSIL_SAT(); 

                }
                break;
            case 59 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:359: SIL_VALID
                {
                mSIL_VALID(); 

                }
                break;
            case 60 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:369: WS
                {
                mWS(); 

                }
                break;
            case 61 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:372: SINGLE_COMMENT
                {
                mSINGLE_COMMENT(); 

                }
                break;
            case 62 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:387: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 63 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:398: IDP
                {
                mIDP(); 

                }
                break;
            case 64 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:402: IDN
                {
                mIDN(); 

                }
                break;
            case 65 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:406: LITREAL
                {
                mLITREAL(); 

                }
                break;
            case 66 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:414: LITINT
                {
                mLITINT(); 

                }
                break;
            case 67 :
                // /home/filip/workspace/nts/src/nts/parser/NTS.g:1:421: LITSTRING
                {
                mLITSTRING(); 

                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\1\uffff\1\54\1\uffff\1\56\6\54\1\76\1\uffff\1\100\1\102\1\105\1"+
        "\uffff\1\107\2\uffff\1\112\13\uffff\7\54\1\uffff\1\54\1\123\3\54"+
        "\4\uffff\6\54\1\135\2\54\1\143\3\54\16\uffff\10\54\2\uffff\1\161"+
        "\1\162\1\54\1\164\3\54\1\171\1\uffff\1\172\1\54\1\174\2\54\1\uffff"+
        "\10\54\1\u0087\1\u0088\3\54\2\uffff\1\u008c\1\uffff\4\54\2\uffff"+
        "\1\54\1\uffff\1\u0093\4\54\1\u0098\1\u0099\3\54\2\uffff\3\54\1\uffff"+
        "\1\u00a0\2\54\1\u00a3\1\u00a4\1\54\1\uffff\1\54\1\u00a7\1\54\1\u00a9"+
        "\2\uffff\3\54\1\u00ad\1\u00ae\1\u00af\1\uffff\1\u00b0\1\54\2\uffff"+
        "\2\54\1\uffff\1\u00b4\1\uffff\1\54\1\u00b6\1\u00b7\4\uffff\1\u00b8"+
        "\1\u00b9\1\54\1\uffff\1\54\4\uffff\1\54\1\u00bd\1\u00be\2\uffff";
    static final String DFA7_eofS =
        "\u00bf\uffff";
    static final String DFA7_minS =
        "\1\11\1\47\1\uffff\1\0\6\47\1\75\1\uffff\1\174\1\76\1\55\1\uffff"+
        "\1\75\2\uffff\1\52\13\uffff\7\47\1\uffff\1\47\1\56\3\47\4\uffff"+
        "\15\47\16\uffff\10\47\2\uffff\10\47\1\uffff\5\47\1\uffff\15\47\2"+
        "\uffff\1\47\1\uffff\4\47\2\uffff\1\47\1\uffff\12\47\2\uffff\3\47"+
        "\1\uffff\6\47\1\uffff\4\47\2\uffff\6\47\1\uffff\2\47\2\uffff\2\47"+
        "\1\uffff\1\47\1\uffff\3\47\4\uffff\3\47\1\uffff\1\47\4\uffff\3\47"+
        "\2\uffff";
    static final String DFA7_maxS =
        "\1\175\1\172\1\uffff\1\uffff\6\172\1\75\1\uffff\1\174\1\76\1\75"+
        "\1\uffff\1\75\2\uffff\1\57\13\uffff\7\172\1\uffff\1\172\1\71\3\172"+
        "\4\uffff\15\172\16\uffff\10\172\2\uffff\10\172\1\uffff\5\172\1\uffff"+
        "\15\172\2\uffff\1\172\1\uffff\4\172\2\uffff\1\172\1\uffff\12\172"+
        "\2\uffff\3\172\1\uffff\6\172\1\uffff\4\172\2\uffff\6\172\1\uffff"+
        "\2\172\2\uffff\2\172\1\uffff\1\172\1\uffff\3\172\4\uffff\3\172\1"+
        "\uffff\1\172\4\uffff\3\172\2\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\2\10\uffff\1\14\3\uffff\1\22\1\uffff\1\31\1\33\1\uffff"+
        "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\7\uffff"+
        "\1\74\5\uffff\1\100\1\77\1\3\1\103\15\uffff\1\23\1\13\1\15\1\30"+
        "\1\16\1\32\1\17\1\24\1\25\1\26\1\27\1\75\1\76\1\34\10\uffff\1\102"+
        "\1\101\10\uffff\1\10\5\uffff\1\56\15\uffff\1\1\1\6\1\uffff\1\67"+
        "\4\uffff\1\7\1\57\1\uffff\1\51\12\uffff\1\72\1\55\3\uffff\1\4\6"+
        "\uffff\1\64\4\uffff\1\50\1\52\6\uffff\1\5\2\uffff\1\62\1\11\2\uffff"+
        "\1\12\1\uffff\1\63\3\uffff\1\66\1\71\1\73\1\21\3\uffff\1\20\1\uffff"+
        "\1\53\1\60\1\54\1\61\3\uffff\1\70\1\65";
    static final String DFA7_specialS =
        "\3\uffff\1\0\u00bb\uffff}>";
    static final String[] DFA7_transitionS = {
            "\2\46\2\uffff\1\46\22\uffff\1\46\1\12\1\3\2\uffff\1\24\1\13"+
            "\1\uffff\1\25\1\26\1\22\1\21\1\34\1\15\1\33\1\23\12\50\1\35"+
            "\1\36\1\16\1\17\1\20\1\uffff\1\2\32\47\1\27\1\uffff\1\30\1\uffff"+
            "\1\47\1\uffff\1\6\1\37\1\44\1\47\1\11\1\5\1\47\1\43\1\10\4\47"+
            "\1\1\1\7\1\42\1\47\1\40\1\41\1\4\1\47\1\45\4\47\1\31\1\14\1"+
            "\32",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\16"+
            "\53\1\52\4\53\1\51\6\53",
            "",
            "\12\57\1\uffff\2\57\1\uffff\ufff2\57",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\10"+
            "\53\1\61\10\53\1\60\10\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\1\62"+
            "\7\53\1\64\5\53\1\63\13\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\15"+
            "\53\1\65\14\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\21"+
            "\53\1\66\2\53\1\67\5\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\14"+
            "\53\1\70\1\71\14\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\20"+
            "\53\1\72\1\74\5\53\1\73\2\53",
            "\1\75",
            "",
            "\1\77",
            "\1\101",
            "\1\103\17\uffff\1\104",
            "",
            "\1\106",
            "",
            "",
            "\1\111\4\uffff\1\110",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\16"+
            "\53\1\113\13\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\4\53"+
            "\1\114\25\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\1\116"+
            "\22\53\1\115\6\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\1\117"+
            "\31\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\1\120"+
            "\31\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\7\53"+
            "\1\121\22\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\1\122"+
            "\31\53",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\124\1\uffff\12\50",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\22"+
            "\53\1\125\7\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\23"+
            "\53\1\126\6\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "",
            "",
            "",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\24"+
            "\53\1\127\5\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\3\53"+
            "\1\130\26\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\13"+
            "\53\1\131\16\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\21"+
            "\53\1\132\10\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\15"+
            "\53\1\133\14\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\3\53"+
            "\1\134\26\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\23"+
            "\53\1\136\6\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\17"+
            "\53\1\137\12\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\10"+
            "\53\1\141\11\53\1\142\1\140\6\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\24"+
            "\53\1\144\5\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\10"+
            "\53\1\145\21\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\21"+
            "\53\1\146\10\53",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\16"+
            "\53\1\147\13\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\1\150"+
            "\12\53\1\151\16\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\1\153"+
            "\20\53\1\152\10\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\23"+
            "\53\1\154\6\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\21"+
            "\53\1\155\10\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\25"+
            "\53\1\156\4\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\4\53"+
            "\1\157\25\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\13"+
            "\53\1\160\16\53",
            "",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\4\53"+
            "\1\163\25\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\22"+
            "\53\1\165\7\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\1\166"+
            "\13\53\1\167\15\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\1\170"+
            "\31\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\13"+
            "\53\1\173\16\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\23"+
            "\53\1\175\6\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\23"+
            "\53\1\176\6\53",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\10"+
            "\53\1\177\21\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\22"+
            "\53\1\u0080\7\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\16"+
            "\53\1\u0081\13\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\13"+
            "\53\1\u0082\16\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\13"+
            "\53\1\u0083\16\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\1\u0084"+
            "\31\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\10"+
            "\53\1\u0085\21\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\23"+
            "\53\1\u0086\6\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\16"+
            "\53\1\u0089\13\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\2\53"+
            "\1\u008a\27\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\10"+
            "\53\1\u008b\21\53",
            "",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\4\53"+
            "\1\u008d\25\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\13"+
            "\53\1\u008e\16\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\24"+
            "\53\1\u008f\5\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\13"+
            "\53\1\u0090\16\53",
            "",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\30"+
            "\53\1\u0091\1\53",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\10"+
            "\53\1\u0092\21\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\1\u0094"+
            "\31\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\25"+
            "\53\1\u0095\4\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\23"+
            "\53\1\u0096\6\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\21"+
            "\53\1\u0097\10\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\23"+
            "\53\1\u009a\6\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\15"+
            "\53\1\u009b\14\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\4\53"+
            "\1\u009c\25\53",
            "",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\2\53"+
            "\1\u009d\27\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\12"+
            "\53\1\u009e\17\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\3\53"+
            "\1\u009f\26\53",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\13"+
            "\53\1\u00a1\16\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\13"+
            "\53\1\u00a2\16\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\1\u00a5"+
            "\31\53",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\15"+
            "\53\1\u00a6\14\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\22"+
            "\53\1\u00a8\7\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\10"+
            "\53\1\u00aa\21\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\6\53"+
            "\1\u00ab\23\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\22"+
            "\53\1\u00ac\7\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\1\u00b1"+
            "\31\53",
            "",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\13"+
            "\53\1\u00b2\16\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\2\53"+
            "\1\u00b3\27\53",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\16"+
            "\53\1\u00b5\13\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "",
            "",
            "",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\4\53"+
            "\1\u00ba\25\53",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\15"+
            "\53\1\u00bb\14\53",
            "",
            "",
            "",
            "",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\22"+
            "\53\1\u00bc\7\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\55\10\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( NTS | AT | QUOTE | TRUE | FALSE | NOT | AND | OR | IMPL | EQUIV | C_NOT | C_AND | C_OR | C_IMPL | C_EQUIV | EXISTS | FORALL | EQ | NEQ | LEQ | LT | GEQ | GT | VBAR | PLUS | MINUS | MULT | DIVIDE | REMAINDER | LPAR | RPAR | LPAR_S | RPAR_S | LPAR_C | RPAR_C | DOT | COMMA | COLON | SEMICOLON | TBOOL | TINT | TREAL | TSTRING | TFORMULA | PARAM | IN | OUT | STATES | INITIAL | FINAL | ERROR | PRECONDITION | INSTANCES | HAVOC | TID | RELATION | SIL_CHECK | SIL_SAT | SIL_VALID | WS | SINGLE_COMMENT | ML_COMMENT | IDP | IDN | LITREAL | LITINT | LITSTRING );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_3 = input.LA(1);

                        s = -1;
                        if ( ((LA7_3>='\u0000' && LA7_3<='\t')||(LA7_3>='\u000B' && LA7_3<='\f')||(LA7_3>='\u000E' && LA7_3<='\uFFFF')) ) {s = 47;}

                        else s = 46;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}