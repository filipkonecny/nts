// $ANTLR 3.3 Nov 30, 2010 12:50:56 /home/filip/workspace/nts/src/nts/parser/NTS.g 2014-03-20 03:23:46

package nts.parser;

import nts.interf.base.*;
import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class NTSParser extends MBaseParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDN", "IDP", "LITINT", "LITREAL", "CALL", "NTS", "AT", "QUOTE", "TRUE", "FALSE", "NOT", "AND", "OR", "IMPL", "EQUIV", "C_NOT", "C_AND", "C_OR", "C_IMPL", "C_EQUIV", "EXISTS", "FORALL", "EQ", "NEQ", "LEQ", "LT", "GEQ", "GT", "VBAR", "PLUS", "MINUS", "MULT", "DIVIDE", "REMAINDER", "LPAR", "RPAR", "LPAR_S", "RPAR_S", "LPAR_C", "RPAR_C", "DOT", "COMMA", "COLON", "SEMICOLON", "TBOOL", "TINT", "TREAL", "TSTRING", "TFORMULA", "PARAM", "IN", "OUT", "STATES", "INITIAL", "FINAL", "ERROR", "PRECONDITION", "INSTANCES", "HAVOC", "TID", "RELATION", "ARR_LENGTH", "SIL_CHECK", "SIL_SAT", "SIL_VALID", "LITSTRING", "WS", "SINGLE_COMMENT", "ML_COMMENT"
    };
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


        public NTSParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public NTSParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return NTSParser.tokenNames; }
    public String getGrammarFileName() { return "/home/filip/workspace/nts/src/nts/parser/NTS.g"; }



      private IParserListener listener;
      
      public static String SIL_COMMON_ARRAY_SIZE = "N";

      public NTSParser(TokenStream input, IParserListener aListener) {
        this(input);
        listener = aListener;
      }
      
      public static void parseNTS(java.io.InputStream is, IParserListener aListener) {
        try { 
          ANTLRInputStream input = new ANTLRInputStream(is);
          NTSLexer lexer = new NTSLexer(input);
          CommonTokenStream tokens = new CommonTokenStream(lexer);
          NTSParser parser = new NTSParser(tokens, aListener);
          Common.parser = parser;
          try {
            NTSParser.start_return r = parser.start();
            //System.out.println(r.getTree().toStringTree());
          } catch (RecognitionException e) {
            System.err.print(e.getMessage());
            System.exit(1);
          }
        } catch (java.io.IOException e) {
          System.err.print(e.getMessage());
          System.exit(1);  
        }
        
      }
      
      public static void parseExpr(java.io.InputStream is, IParserListenerExpr aListener) {
        try { 
          ANTLRInputStream input = new ANTLRInputStream(is);
          NTSLexer lexer = new NTSLexer(input);
          CommonTokenStream tokens = new CommonTokenStream(lexer);
          NTSParser parser = new NTSParser(tokens, aListener);
          Common.parser = parser;
          try {
            // initialize the listener
            aListener.exprParsingInit();
            NTSParser.start_expr_return r = parser.start_expr();
            aListener.exprParsingFinalize();
          } catch (RecognitionException e) {
            System.err.print(e.getMessage());
            System.exit(1);
          }
        } catch (java.io.IOException e) {
          System.err.print(e.getMessage());
          System.exit(1);  
        }    
      }
      
      public static void parseSIL(java.io.InputStream is, IParserListenerSIL aListener) {
        try { 
          ANTLRInputStream input = new ANTLRInputStream(is);
          NTSLexer lexer = new NTSLexer(input);
          CommonTokenStream tokens = new CommonTokenStream(lexer);
          NTSParser parser = new NTSParser(tokens, aListener);
          Common.parser = parser;
          try {
            // initialize the listener
            aListener.silParsingInit();
            
            // pre-declare the common array-size parameter 
            aListener.setModifier(EModifier.PARAM);
            aListener.declarationAdd(NTSParser.dummyIDN_S(NTSParser.SIL_COMMON_ARRAY_SIZE), 0, 0);
            aListener.declarationSetBasicType(EBasicType.INT);
            
            NTSParser.start_sil_return r = parser.start_sil();
            aListener.silParsingFinalize();
          } catch (RecognitionException e) {
            System.err.print(e.getMessage());
            System.exit(1);
          }
        } catch (java.io.IOException e) {
          System.err.print(e.getMessage());
          System.exit(1);  
        }    
      }
      
      
      private static CommonToken dummy(int n, String aText) {
        CommonToken t = new CommonToken(n);
        t.setText(aText);
        return t;
      }
      public boolean isPrimedId(Token aToken) {
        return aToken.getType() == IDP;
      }
      public CommonToken dummyLparS() {
      	return dummy(LPAR_S,"[");
      }
      public CommonToken dummyTrue() {
        return dummy(TRUE,"true");
      }
      public CommonToken dummyAnd() {
        return dummy(AND,"and");
      }
      public CommonToken dummyImpl() {
        return dummy(IMPL,"impl");
      }
      public CommonToken dummyEquiv() {
        return dummy(EQUIV,"equiv");
      }
      public CommonToken dummyLeq() {
        return dummy(LEQ,"<=");
      }
      public CommonToken dummyTid() {
        return dummy(TID,"tid");
      }
      public CommonToken dummyIDN(String s) {
        return dummy(IDN, s);
      }
      public CommonToken dummyIDP(String s) {
        return dummy(IDP, s);
      }
      public static CommonToken dummyIDN_S(String s) {
        return dummy(IDN, s);
      }
      public static CommonToken dummyIDP_S(String s) {
        return dummy(IDP, s);
      }

      public static CommonToken dummyPrimed(CommonToken aToken) {
        CommonToken t = new CommonToken(aToken);
        t.setType(IDP);
        t.setText(t.getText()+'\'');
        return t;
      }
      public CommonToken dummyNum(int aVal) {
        CommonToken t = new CommonToken(LITINT);
        t.setText(""+aVal);
        return t;
      }
      public EModifier token2modifier(Token aToken) {
        switch (aToken.getType()) {
        case PARAM:
          return EModifier.PARAM;
        case IN:
          return EModifier.IN;
        case OUT:
          return EModifier.OUT;
        case TID:
          return EModifier.TID;
        default:
          throw new RuntimeException("internal error: unexpected token type '"+aToken+"'.");
        }
      }
      public EBasicType token2basicType(Token aToken) {
        switch (aToken.getType()) {
        case TBOOL:
          return EBasicType.BOOL;
        case TINT:
          return EBasicType.INT;
        case TREAL:
          return EBasicType.REAL;
        default:
          throw new RuntimeException("internal error: unexpected token type '"+aToken+"'.");
        }
      }
      public EAnnotType token2annotType(Token aToken) {
        switch (aToken.getType()) {
        case TINT:
          return EAnnotType.INT;
        case TREAL:
          return EAnnotType.REAL;
        case TBOOL:
          return EAnnotType.BOOL;
        case TSTRING:
          return EAnnotType.STRING;
        case TFORMULA:
          return EAnnotType.FORMULA;
        default:
          throw new RuntimeException("internal error: unexpected token type '"+aToken+"'.");
        }
      }
      
      public EMarkType token2markType(Token aToken) {
        switch (aToken.getType()) {
        case INITIAL:
          return EMarkType.INITIAL;
        case FINAL:
          return EMarkType.FINAL;
        case ERROR:
          return EMarkType.ERROR;
        default:
          throw new RuntimeException("internal error");
        }
      }
      

      /**
       * Used as a semantic predicate to distinguish between calls and formulae
       * (needs 4 tokens look-ahead)
       */
      boolean isCall() {
        int LA1 = input.LA(1);
        int LA2 = input.LA(2);
        int LA3 = input.LA(3);
        int LA4 = input.LA(4);
        return 
          (LA1 == IDN && LA2 == LPAR) ||                              // f( ...
          (LA1 == LPAR && LA2 == IDP && LA3 == COMMA) ||              // (x', ...
          (LA1 == LPAR && LA2 == IDP && LA3 == RPAR && LA4 == EQ) ||  // (x')= ...
          (LA1 == IDP && LA2 == EQ && LA3 == IDN && LA4 == LPAR);     // x'=f( ...
      }
      

    /*  
      protected void mismatch(IntStream input, int ttype, BitSet follow)
      throws RecognitionException {
        throw new MismatchedTokenException(ttype, input);
      }
      public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
      throws RecognitionException {
        throw e;
      }
    */
      public void reportError(RecognitionException ex) {
        super.reportError(ex);
        System.exit(1);
      }
      


    public static class start_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "start"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:366:1: start : nts EOF ;
    public final NTSParser.start_return start() throws RecognitionException {
        NTSParser.start_return retval = new NTSParser.start_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        NTSParser.nts_return nts1 = null;


        CommonTree EOF2_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:367:3: ( nts EOF )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:367:5: nts EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_nts_in_start717);
            nts1=nts();

            state._fsp--;

            adaptor.addChild(root_0, nts1.getTree());
            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_start719); 
            EOF2_tree = (CommonTree)adaptor.create(EOF2);
            adaptor.addChild(root_0, EOF2_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "start"

    public static class start_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "start_expr"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:370:1: start_expr : declar RELATION ( expr SEMICOLON )+ EOF ;
    public final NTSParser.start_expr_return start_expr() throws RecognitionException {
        NTSParser.start_expr_return retval = new NTSParser.start_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token RELATION4=null;
        Token SEMICOLON6=null;
        Token EOF7=null;
        NTSParser.declar_return declar3 = null;

        NTSParser.expr_return expr5 = null;


        CommonTree RELATION4_tree=null;
        CommonTree SEMICOLON6_tree=null;
        CommonTree EOF7_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:371:3: ( declar RELATION ( expr SEMICOLON )+ EOF )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:371:5: declar RELATION ( expr SEMICOLON )+ EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_declar_in_start_expr732);
            declar3=declar();

            state._fsp--;

            adaptor.addChild(root_0, declar3.getTree());
            RELATION4=(Token)match(input,RELATION,FOLLOW_RELATION_in_start_expr734); 
            RELATION4_tree = (CommonTree)adaptor.create(RELATION4);
            adaptor.addChild(root_0, RELATION4_tree);

            // /home/filip/workspace/nts/src/nts/parser/NTS.g:371:21: ( expr SEMICOLON )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:371:22: expr SEMICOLON
            	    {
            	    pushFollow(FOLLOW_expr_in_start_expr737);
            	    expr5=expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expr5.getTree());
            	    SEMICOLON6=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_start_expr739); 
            	    SEMICOLON6_tree = (CommonTree)adaptor.create(SEMICOLON6);
            	    adaptor.addChild(root_0, SEMICOLON6_tree);


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

            EOF7=(Token)match(input,EOF,FOLLOW_EOF_in_start_expr743); 
            EOF7_tree = (CommonTree)adaptor.create(EOF7);
            adaptor.addChild(root_0, EOF7_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "start_expr"

    public static class start_sil_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "start_sil"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:374:1: start_sil : declar SIL_CHECK sil_query ( expr SEMICOLON ) EOF ;
    public final NTSParser.start_sil_return start_sil() throws RecognitionException {
        NTSParser.start_sil_return retval = new NTSParser.start_sil_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SIL_CHECK9=null;
        Token SEMICOLON12=null;
        Token EOF13=null;
        NTSParser.declar_return declar8 = null;

        NTSParser.sil_query_return sil_query10 = null;

        NTSParser.expr_return expr11 = null;


        CommonTree SIL_CHECK9_tree=null;
        CommonTree SEMICOLON12_tree=null;
        CommonTree EOF13_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:375:3: ( declar SIL_CHECK sil_query ( expr SEMICOLON ) EOF )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:375:5: declar SIL_CHECK sil_query ( expr SEMICOLON ) EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_declar_in_start_sil756);
            declar8=declar();

            state._fsp--;

            adaptor.addChild(root_0, declar8.getTree());
            SIL_CHECK9=(Token)match(input,SIL_CHECK,FOLLOW_SIL_CHECK_in_start_sil758); 
            SIL_CHECK9_tree = (CommonTree)adaptor.create(SIL_CHECK9);
            adaptor.addChild(root_0, SIL_CHECK9_tree);

            pushFollow(FOLLOW_sil_query_in_start_sil760);
            sil_query10=sil_query();

            state._fsp--;

            adaptor.addChild(root_0, sil_query10.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:375:32: ( expr SEMICOLON )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:375:33: expr SEMICOLON
            {
            pushFollow(FOLLOW_expr_in_start_sil763);
            expr11=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr11.getTree());
            SEMICOLON12=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_start_sil765); 
            SEMICOLON12_tree = (CommonTree)adaptor.create(SEMICOLON12);
            adaptor.addChild(root_0, SEMICOLON12_tree);


            }

            EOF13=(Token)match(input,EOF,FOLLOW_EOF_in_start_sil768); 
            EOF13_tree = (CommonTree)adaptor.create(EOF13);
            adaptor.addChild(root_0, EOF13_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "start_sil"

    public static class sil_query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sil_query"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:377:1: sil_query : ( SIL_SAT | SIL_VALID );
    public final NTSParser.sil_query_return sil_query() throws RecognitionException {
        NTSParser.sil_query_return retval = new NTSParser.sil_query_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SIL_SAT14=null;
        Token SIL_VALID15=null;

        CommonTree SIL_SAT14_tree=null;
        CommonTree SIL_VALID15_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:378:3: ( SIL_SAT | SIL_VALID )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==SIL_SAT) ) {
                alt2=1;
            }
            else if ( (LA2_0==SIL_VALID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:378:5: SIL_SAT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SIL_SAT14=(Token)match(input,SIL_SAT,FOLLOW_SIL_SAT_in_sil_query780); 
                    SIL_SAT14_tree = (CommonTree)adaptor.create(SIL_SAT14);
                    adaptor.addChild(root_0, SIL_SAT14_tree);

                     ((IParserListenerSIL)listener).sil_check_sat(); 

                    }
                    break;
                case 2 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:379:5: SIL_VALID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SIL_VALID15=(Token)match(input,SIL_VALID,FOLLOW_SIL_VALID_in_sil_query788); 
                    SIL_VALID15_tree = (CommonTree)adaptor.create(SIL_VALID15);
                    adaptor.addChild(root_0, SIL_VALID15_tree);

                     ((IParserListenerSIL)listener).sil_check_valid(); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sil_query"

    public static class nts_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nts"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:388:1: nts : annotations NTS IDN SEMICOLON ma= modif_annot ( declar_m_a )? ( precondition annotations )? ( instances annotations )? subsystem_annot ( subsystem )* ;
    public final NTSParser.nts_return nts() throws RecognitionException {
        NTSParser.nts_return retval = new NTSParser.nts_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NTS17=null;
        Token IDN18=null;
        Token SEMICOLON19=null;
        NTSParser.modif_annot_return ma = null;

        NTSParser.annotations_return annotations16 = null;

        NTSParser.declar_m_a_return declar_m_a20 = null;

        NTSParser.precondition_return precondition21 = null;

        NTSParser.annotations_return annotations22 = null;

        NTSParser.instances_return instances23 = null;

        NTSParser.annotations_return annotations24 = null;

        NTSParser.subsystem_annot_return subsystem_annot25 = null;

        NTSParser.subsystem_return subsystem26 = null;


        CommonTree NTS17_tree=null;
        CommonTree IDN18_tree=null;
        CommonTree SEMICOLON19_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:389:3: ( annotations NTS IDN SEMICOLON ma= modif_annot ( declar_m_a )? ( precondition annotations )? ( instances annotations )? subsystem_annot ( subsystem )* )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:390:5: annotations NTS IDN SEMICOLON ma= modif_annot ( declar_m_a )? ( precondition annotations )? ( instances annotations )? subsystem_annot ( subsystem )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_annotations_in_nts814);
            annotations16=annotations();

            state._fsp--;

            adaptor.addChild(root_0, annotations16.getTree());
            NTS17=(Token)match(input,NTS,FOLLOW_NTS_in_nts825); 
            NTS17_tree = (CommonTree)adaptor.create(NTS17);
            adaptor.addChild(root_0, NTS17_tree);

            IDN18=(Token)match(input,IDN,FOLLOW_IDN_in_nts827); 
            IDN18_tree = (CommonTree)adaptor.create(IDN18);
            adaptor.addChild(root_0, IDN18_tree);

            SEMICOLON19=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_nts829); 
            SEMICOLON19_tree = (CommonTree)adaptor.create(SEMICOLON19);
            adaptor.addChild(root_0, SEMICOLON19_tree);

             listener.ntsInit(IDN18); 
            pushFollow(FOLLOW_modif_annot_in_nts869);
            ma=modif_annot();

            state._fsp--;

            adaptor.addChild(root_0, ma.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:402:5: ( declar_m_a )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDN) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==LPAR_S||(LA3_1>=COMMA && LA3_1<=COLON)) ) {
                    alt3=1;
                }
            }
            switch (alt3) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:402:7: declar_m_a
                    {
                    pushFollow(FOLLOW_declar_m_a_in_nts887);
                    declar_m_a20=declar_m_a();

                    state._fsp--;

                    adaptor.addChild(root_0, declar_m_a20.getTree());

                    }
                    break;

            }

             listener.checkNoModifier(); 
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:408:5: ( precondition annotations )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PRECONDITION) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:408:7: precondition annotations
                    {
                     listener.checkNoAnnotation(); 
                    pushFollow(FOLLOW_precondition_in_nts932);
                    precondition21=precondition();

                    state._fsp--;

                    adaptor.addChild(root_0, precondition21.getTree());
                    pushFollow(FOLLOW_annotations_in_nts947);
                    annotations22=annotations();

                    state._fsp--;

                    adaptor.addChild(root_0, annotations22.getTree());

                    }
                    break;

            }

            // /home/filip/workspace/nts/src/nts/parser/NTS.g:415:5: ( instances annotations )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==INSTANCES) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:415:7: instances annotations
                    {
                     listener.checkNoAnnotation(); 
                    pushFollow(FOLLOW_instances_in_nts980);
                    instances23=instances();

                    state._fsp--;

                    adaptor.addChild(root_0, instances23.getTree());
                    pushFollow(FOLLOW_annotations_in_nts995);
                    annotations24=annotations();

                    state._fsp--;

                    adaptor.addChild(root_0, annotations24.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_subsystem_annot_in_nts1018);
            subsystem_annot25=subsystem_annot();

            state._fsp--;

            adaptor.addChild(root_0, subsystem_annot25.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:422:21: ( subsystem )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==IDN||LA6_0==AT) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:422:23: subsystem
            	    {
            	    pushFollow(FOLLOW_subsystem_in_nts1022);
            	    subsystem26=subsystem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, subsystem26.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             listener.ntsFinalize(); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nts"

    public static class precondition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "precondition"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:426:1: precondition : PRECONDITION expr SEMICOLON ;
    public final NTSParser.precondition_return precondition() throws RecognitionException {
        NTSParser.precondition_return retval = new NTSParser.precondition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PRECONDITION27=null;
        Token SEMICOLON29=null;
        NTSParser.expr_return expr28 = null;


        CommonTree PRECONDITION27_tree=null;
        CommonTree SEMICOLON29_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:427:3: ( PRECONDITION expr SEMICOLON )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:427:5: PRECONDITION expr SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            PRECONDITION27=(Token)match(input,PRECONDITION,FOLLOW_PRECONDITION_in_precondition1048); 
            PRECONDITION27_tree = (CommonTree)adaptor.create(PRECONDITION27);
            adaptor.addChild(root_0, PRECONDITION27_tree);

            pushFollow(FOLLOW_expr_in_precondition1050);
            expr28=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr28.getTree());
            SEMICOLON29=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_precondition1052); 
            SEMICOLON29_tree = (CommonTree)adaptor.create(SEMICOLON29);
            adaptor.addChild(root_0, SEMICOLON29_tree);

             listener.precondition(); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "precondition"

    public static class instances_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instances"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:429:1: instances : INSTANCES inst ( COMMA inst )* SEMICOLON ;
    public final NTSParser.instances_return instances() throws RecognitionException {
        NTSParser.instances_return retval = new NTSParser.instances_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INSTANCES30=null;
        Token COMMA32=null;
        Token SEMICOLON34=null;
        NTSParser.inst_return inst31 = null;

        NTSParser.inst_return inst33 = null;


        CommonTree INSTANCES30_tree=null;
        CommonTree COMMA32_tree=null;
        CommonTree SEMICOLON34_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:430:3: ( INSTANCES inst ( COMMA inst )* SEMICOLON )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:430:5: INSTANCES inst ( COMMA inst )* SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            INSTANCES30=(Token)match(input,INSTANCES,FOLLOW_INSTANCES_in_instances1067); 
            INSTANCES30_tree = (CommonTree)adaptor.create(INSTANCES30);
            adaptor.addChild(root_0, INSTANCES30_tree);

            pushFollow(FOLLOW_inst_in_instances1069);
            inst31=inst();

            state._fsp--;

            adaptor.addChild(root_0, inst31.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:430:20: ( COMMA inst )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==COMMA) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:430:21: COMMA inst
            	    {
            	    COMMA32=(Token)match(input,COMMA,FOLLOW_COMMA_in_instances1072); 
            	    COMMA32_tree = (CommonTree)adaptor.create(COMMA32);
            	    adaptor.addChild(root_0, COMMA32_tree);

            	    pushFollow(FOLLOW_inst_in_instances1074);
            	    inst33=inst();

            	    state._fsp--;

            	    adaptor.addChild(root_0, inst33.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            SEMICOLON34=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_instances1078); 
            SEMICOLON34_tree = (CommonTree)adaptor.create(SEMICOLON34);
            adaptor.addChild(root_0, SEMICOLON34_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "instances"

    public static class inst_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inst"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:432:1: inst : ii= IDN LPAR_S ee= expr RPAR_S ;
    public final NTSParser.inst_return inst() throws RecognitionException {
        NTSParser.inst_return retval = new NTSParser.inst_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ii=null;
        Token LPAR_S35=null;
        Token RPAR_S36=null;
        NTSParser.expr_return ee = null;


        CommonTree ii_tree=null;
        CommonTree LPAR_S35_tree=null;
        CommonTree RPAR_S36_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:433:3: (ii= IDN LPAR_S ee= expr RPAR_S )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:433:5: ii= IDN LPAR_S ee= expr RPAR_S
            {
            root_0 = (CommonTree)adaptor.nil();

            ii=(Token)match(input,IDN,FOLLOW_IDN_in_inst1092); 
            ii_tree = (CommonTree)adaptor.create(ii);
            adaptor.addChild(root_0, ii_tree);

            LPAR_S35=(Token)match(input,LPAR_S,FOLLOW_LPAR_S_in_inst1094); 
            LPAR_S35_tree = (CommonTree)adaptor.create(LPAR_S35);
            adaptor.addChild(root_0, LPAR_S35_tree);

            pushFollow(FOLLOW_expr_in_inst1098);
            ee=expr();

            state._fsp--;

            adaptor.addChild(root_0, ee.getTree());
            RPAR_S36=(Token)match(input,RPAR_S,FOLLOW_RPAR_S_in_inst1100); 
            RPAR_S36_tree = (CommonTree)adaptor.create(RPAR_S36);
            adaptor.addChild(root_0, RPAR_S36_tree);

             listener.instance(ii); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inst"

    public static class annotations_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotations"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:443:1: annotations : (a1= annotation ( annotation )* | );
    public final NTSParser.annotations_return annotations() throws RecognitionException {
        NTSParser.annotations_return retval = new NTSParser.annotations_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.annotation_return a1 = null;

        NTSParser.annotation_return annotation37 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:444:3: (a1= annotation ( annotation )* | )
            int alt9=2;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:444:5: a1= annotation ( annotation )*
                    {
                    root_0 = (CommonTree)adaptor.nil();

                     listener.setAnnotations(new Annotations()); 
                    pushFollow(FOLLOW_annotation_in_annotations1133);
                    a1=annotation();

                    state._fsp--;

                    adaptor.addChild(root_0, a1.getTree());
                     listener.setAnnotFirstTok((a1!=null?((Token)a1.start):null)); 
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:446:5: ( annotation )*
                    loop8:
                    do {
                        int alt8=2;
                        alt8 = dfa8.predict(input);
                        switch (alt8) {
                    	case 1 :
                    	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:446:7: annotation
                    	    {
                    	    pushFollow(FOLLOW_annotation_in_annotations1143);
                    	    annotation37=annotation();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, annotation37.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:447:5: 
                    {
                    root_0 = (CommonTree)adaptor.nil();

                     listener.setAnnotations(null); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "annotations"

    public static class annotation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotation"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:449:1: annotation : AT k= IDN COLON t= annot_type COLON annot_value[$k, $t.rT] SEMICOLON ;
    public final NTSParser.annotation_return annotation() throws RecognitionException {
        NTSParser.annotation_return retval = new NTSParser.annotation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token k=null;
        Token AT38=null;
        Token COLON39=null;
        Token COLON40=null;
        Token SEMICOLON42=null;
        NTSParser.annot_type_return t = null;

        NTSParser.annot_value_return annot_value41 = null;


        CommonTree k_tree=null;
        CommonTree AT38_tree=null;
        CommonTree COLON39_tree=null;
        CommonTree COLON40_tree=null;
        CommonTree SEMICOLON42_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:450:3: ( AT k= IDN COLON t= annot_type COLON annot_value[$k, $t.rT] SEMICOLON )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:450:5: AT k= IDN COLON t= annot_type COLON annot_value[$k, $t.rT] SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            AT38=(Token)match(input,AT,FOLLOW_AT_in_annotation1165); 
            AT38_tree = (CommonTree)adaptor.create(AT38);
            adaptor.addChild(root_0, AT38_tree);

            k=(Token)match(input,IDN,FOLLOW_IDN_in_annotation1169); 
            k_tree = (CommonTree)adaptor.create(k);
            adaptor.addChild(root_0, k_tree);

            COLON39=(Token)match(input,COLON,FOLLOW_COLON_in_annotation1171); 
            COLON39_tree = (CommonTree)adaptor.create(COLON39);
            adaptor.addChild(root_0, COLON39_tree);

            pushFollow(FOLLOW_annot_type_in_annotation1179);
            t=annot_type();

            state._fsp--;

            adaptor.addChild(root_0, t.getTree());
            COLON40=(Token)match(input,COLON,FOLLOW_COLON_in_annotation1181); 
            COLON40_tree = (CommonTree)adaptor.create(COLON40);
            adaptor.addChild(root_0, COLON40_tree);

            pushFollow(FOLLOW_annot_value_in_annotation1188);
            annot_value41=annot_value(k, (t!=null?t.rT:null));

            state._fsp--;

            adaptor.addChild(root_0, annot_value41.getTree());
            SEMICOLON42=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_annotation1191); 
            SEMICOLON42_tree = (CommonTree)adaptor.create(SEMICOLON42);
            adaptor.addChild(root_0, SEMICOLON42_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "annotation"

    public static class annot_value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annot_value"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:455:1: annot_value[Token aKey, EAnnotType aT] : (s= litstring | e= expr );
    public final NTSParser.annot_value_return annot_value(Token aKey, EAnnotType aT) throws RecognitionException {
        NTSParser.annot_value_return retval = new NTSParser.annot_value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.litstring_return s = null;

        NTSParser.expr_return e = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:456:3: (s= litstring | e= expr )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:456:5: s= litstring
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_litstring_in_annot_value1208);
                    s=litstring();

                    state._fsp--;

                    adaptor.addChild(root_0, s.getTree());
                     listener.addAnnotString(aKey, aT, (s!=null?s.rS:null)); 

                    }
                    break;
                case 2 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:457:5: e= expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expr_in_annot_value1218);
                    e=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, e.getTree());
                     listener.addAnnotIntRealBoolFormula(aKey, aT); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "annot_value"

    public static class annot_type_return extends ParserRuleReturnScope {
        public EAnnotType rT;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annot_type"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:459:1: annot_type returns [EAnnotType rT] : t= ( TINT | TREAL | TBOOL | TSTRING | TFORMULA ) ;
    public final NTSParser.annot_type_return annot_type() throws RecognitionException {
        NTSParser.annot_type_return retval = new NTSParser.annot_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token t=null;

        CommonTree t_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:460:3: (t= ( TINT | TREAL | TBOOL | TSTRING | TFORMULA ) )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:460:5: t= ( TINT | TREAL | TBOOL | TSTRING | TFORMULA )
            {
            root_0 = (CommonTree)adaptor.nil();

            t=(Token)input.LT(1);
            if ( (input.LA(1)>=TBOOL && input.LA(1)<=TFORMULA) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(t));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             retval.rT = token2annotType(t); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "annot_type"

    public static class litstring_return extends ParserRuleReturnScope {
        public String rS;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "litstring"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:462:1: litstring returns [String rS] : l= LITSTRING ;
    public final NTSParser.litstring_return litstring() throws RecognitionException {
        NTSParser.litstring_return retval = new NTSParser.litstring_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token l=null;

        CommonTree l_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:463:3: (l= LITSTRING )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:463:5: l= LITSTRING
            {
            root_0 = (CommonTree)adaptor.nil();

            l=(Token)match(input,LITSTRING,FOLLOW_LITSTRING_in_litstring1276); 
            l_tree = (CommonTree)adaptor.create(l);
            adaptor.addChild(root_0, l_tree);

             
                  retval.rS = l.getText();
                  retval.rS = retval.rS.substring(1,retval.rS.length()-2);
                

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "litstring"

    public static class subsystem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subsystem"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:474:1: subsystem : annotations subsystem_annot ;
    public final NTSParser.subsystem_return subsystem() throws RecognitionException {
        NTSParser.subsystem_return retval = new NTSParser.subsystem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.annotations_return annotations43 = null;

        NTSParser.subsystem_annot_return subsystem_annot44 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:475:3: ( annotations subsystem_annot )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:475:5: annotations subsystem_annot
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_annotations_in_subsystem1300);
            annotations43=annotations();

            state._fsp--;

            adaptor.addChild(root_0, annotations43.getTree());
            pushFollow(FOLLOW_subsystem_annot_in_subsystem1302);
            subsystem_annot44=subsystem_annot();

            state._fsp--;

            adaptor.addChild(root_0, subsystem_annot44.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "subsystem"

    public static class subsystem_annot_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subsystem_annot"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:477:1: subsystem_annot : IDN LPAR_C ( declar )? ( marking )? ( transition )+ RPAR_C ;
    public final NTSParser.subsystem_annot_return subsystem_annot() throws RecognitionException {
        NTSParser.subsystem_annot_return retval = new NTSParser.subsystem_annot_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDN45=null;
        Token LPAR_C46=null;
        Token RPAR_C50=null;
        NTSParser.declar_return declar47 = null;

        NTSParser.marking_return marking48 = null;

        NTSParser.transition_return transition49 = null;


        CommonTree IDN45_tree=null;
        CommonTree LPAR_C46_tree=null;
        CommonTree RPAR_C50_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:478:3: ( IDN LPAR_C ( declar )? ( marking )? ( transition )+ RPAR_C )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:478:5: IDN LPAR_C ( declar )? ( marking )? ( transition )+ RPAR_C
            {
            root_0 = (CommonTree)adaptor.nil();

            IDN45=(Token)match(input,IDN,FOLLOW_IDN_in_subsystem_annot1314); 
            IDN45_tree = (CommonTree)adaptor.create(IDN45);
            adaptor.addChild(root_0, IDN45_tree);

            LPAR_C46=(Token)match(input,LPAR_C,FOLLOW_LPAR_C_in_subsystem_annot1316); 
            LPAR_C46_tree = (CommonTree)adaptor.create(LPAR_C46);
            adaptor.addChild(root_0, LPAR_C46_tree);

             listener.subsystemInit(IDN45); 
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:481:5: ( declar )?
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:481:5: declar
                    {
                    pushFollow(FOLLOW_declar_in_subsystem_annot1334);
                    declar47=declar();

                    state._fsp--;

                    adaptor.addChild(root_0, declar47.getTree());

                    }
                    break;

            }

            // /home/filip/workspace/nts/src/nts/parser/NTS.g:483:5: ( marking )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=STATES && LA12_0<=ERROR)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:483:7: marking
                    {
                    pushFollow(FOLLOW_marking_in_subsystem_annot1348);
                    marking48=marking();

                    state._fsp--;

                    adaptor.addChild(root_0, marking48.getTree());

                    }
                    break;

            }

            // /home/filip/workspace/nts/src/nts/parser/NTS.g:483:18: ( transition )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==IDN) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:483:20: transition
            	    {
            	    pushFollow(FOLLOW_transition_in_subsystem_annot1355);
            	    transition49=transition();

            	    state._fsp--;

            	    adaptor.addChild(root_0, transition49.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            RPAR_C50=(Token)match(input,RPAR_C,FOLLOW_RPAR_C_in_subsystem_annot1360); 
            RPAR_C50_tree = (CommonTree)adaptor.create(RPAR_C50);
            adaptor.addChild(root_0, RPAR_C50_tree);

             listener.subsystemFinalize(); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "subsystem_annot"

    public static class marking_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "marking"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:486:1: marking : ( STATES annotations i1= IDN ( COMMA annotations i2= IDN )* SEMICOLON )? (m= ( INITIAL | FINAL | ERROR ) i1= IDN ( COMMA i2= IDN )* semi= SEMICOLON )+ ;
    public final NTSParser.marking_return marking() throws RecognitionException {
        NTSParser.marking_return retval = new NTSParser.marking_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token i1=null;
        Token i2=null;
        Token m=null;
        Token semi=null;
        Token STATES51=null;
        Token COMMA53=null;
        Token SEMICOLON55=null;
        Token COMMA56=null;
        NTSParser.annotations_return annotations52 = null;

        NTSParser.annotations_return annotations54 = null;


        CommonTree i1_tree=null;
        CommonTree i2_tree=null;
        CommonTree m_tree=null;
        CommonTree semi_tree=null;
        CommonTree STATES51_tree=null;
        CommonTree COMMA53_tree=null;
        CommonTree SEMICOLON55_tree=null;
        CommonTree COMMA56_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:487:3: ( ( STATES annotations i1= IDN ( COMMA annotations i2= IDN )* SEMICOLON )? (m= ( INITIAL | FINAL | ERROR ) i1= IDN ( COMMA i2= IDN )* semi= SEMICOLON )+ )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:487:5: ( STATES annotations i1= IDN ( COMMA annotations i2= IDN )* SEMICOLON )? (m= ( INITIAL | FINAL | ERROR ) i1= IDN ( COMMA i2= IDN )* semi= SEMICOLON )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/filip/workspace/nts/src/nts/parser/NTS.g:487:5: ( STATES annotations i1= IDN ( COMMA annotations i2= IDN )* SEMICOLON )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==STATES) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:487:7: STATES annotations i1= IDN ( COMMA annotations i2= IDN )* SEMICOLON
                    {
                    STATES51=(Token)match(input,STATES,FOLLOW_STATES_in_marking1380); 
                    STATES51_tree = (CommonTree)adaptor.create(STATES51);
                    adaptor.addChild(root_0, STATES51_tree);

                    pushFollow(FOLLOW_annotations_in_marking1388);
                    annotations52=annotations();

                    state._fsp--;

                    adaptor.addChild(root_0, annotations52.getTree());
                    i1=(Token)match(input,IDN,FOLLOW_IDN_in_marking1392); 
                    i1_tree = (CommonTree)adaptor.create(i1);
                    adaptor.addChild(root_0, i1_tree);

                     listener.stateDeclaration(i1); 
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:489:7: ( COMMA annotations i2= IDN )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==COMMA) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:489:9: COMMA annotations i2= IDN
                    	    {
                    	    COMMA53=(Token)match(input,COMMA,FOLLOW_COMMA_in_marking1404); 
                    	    COMMA53_tree = (CommonTree)adaptor.create(COMMA53);
                    	    adaptor.addChild(root_0, COMMA53_tree);

                    	    pushFollow(FOLLOW_annotations_in_marking1406);
                    	    annotations54=annotations();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, annotations54.getTree());
                    	    i2=(Token)match(input,IDN,FOLLOW_IDN_in_marking1410); 
                    	    i2_tree = (CommonTree)adaptor.create(i2);
                    	    adaptor.addChild(root_0, i2_tree);

                    	     listener.stateDeclaration(i2); 

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    SEMICOLON55=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_marking1429); 
                    SEMICOLON55_tree = (CommonTree)adaptor.create(SEMICOLON55);
                    adaptor.addChild(root_0, SEMICOLON55_tree);


                    }
                    break;

            }

            // /home/filip/workspace/nts/src/nts/parser/NTS.g:494:5: (m= ( INITIAL | FINAL | ERROR ) i1= IDN ( COMMA i2= IDN )* semi= SEMICOLON )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=INITIAL && LA17_0<=ERROR)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:495:7: m= ( INITIAL | FINAL | ERROR ) i1= IDN ( COMMA i2= IDN )* semi= SEMICOLON
            	    {
            	    m=(Token)input.LT(1);
            	    if ( (input.LA(1)>=INITIAL && input.LA(1)<=ERROR) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (CommonTree)adaptor.create(m));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	     EMarkType mt = token2markType(m);
            	            listener.checkInitFinErrRedeclaration(mt,m);
            	          
            	    i1=(Token)match(input,IDN,FOLLOW_IDN_in_marking1494); 
            	    i1_tree = (CommonTree)adaptor.create(i1);
            	    adaptor.addChild(root_0, i1_tree);

            	     listener.markAdd(mt, i1); 
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:501:7: ( COMMA i2= IDN )*
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==COMMA) ) {
            	            alt16=1;
            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:501:8: COMMA i2= IDN
            	    	    {
            	    	    COMMA56=(Token)match(input,COMMA,FOLLOW_COMMA_in_marking1506); 
            	    	    COMMA56_tree = (CommonTree)adaptor.create(COMMA56);
            	    	    adaptor.addChild(root_0, COMMA56_tree);

            	    	    i2=(Token)match(input,IDN,FOLLOW_IDN_in_marking1510); 
            	    	    i2_tree = (CommonTree)adaptor.create(i2);
            	    	    adaptor.addChild(root_0, i2_tree);

            	    	     listener.markAdd(mt, i2); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop16;
            	        }
            	    } while (true);

            	    semi=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_marking1539); 
            	    semi_tree = (CommonTree)adaptor.create(semi);
            	    adaptor.addChild(root_0, semi_tree);


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "marking"

    public static class declar_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declar"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:515:1: declar : modif_annot declar_m_a ;
    public final NTSParser.declar_return declar() throws RecognitionException {
        NTSParser.declar_return retval = new NTSParser.declar_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.modif_annot_return modif_annot57 = null;

        NTSParser.declar_m_a_return declar_m_a58 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:516:3: ( modif_annot declar_m_a )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:516:5: modif_annot declar_m_a
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_modif_annot_in_declar1566);
            modif_annot57=modif_annot();

            state._fsp--;

            adaptor.addChild(root_0, modif_annot57.getTree());
            pushFollow(FOLLOW_declar_m_a_in_declar1568);
            declar_m_a58=declar_m_a();

            state._fsp--;

            adaptor.addChild(root_0, declar_m_a58.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declar"

    public static class declar_m_a_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declar_m_a"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:519:1: declar_m_a : ( dline_annot modif_annot )+ ;
    public final NTSParser.declar_m_a_return declar_m_a() throws RecognitionException {
        NTSParser.declar_m_a_return retval = new NTSParser.declar_m_a_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.dline_annot_return dline_annot59 = null;

        NTSParser.modif_annot_return modif_annot60 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:520:3: ( ( dline_annot modif_annot )+ )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:520:5: ( dline_annot modif_annot )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/filip/workspace/nts/src/nts/parser/NTS.g:520:5: ( dline_annot modif_annot )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                alt18 = dfa18.predict(input);
                switch (alt18) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:520:7: dline_annot modif_annot
            	    {
            	    pushFollow(FOLLOW_dline_annot_in_declar_m_a1583);
            	    dline_annot59=dline_annot();

            	    state._fsp--;

            	    adaptor.addChild(root_0, dline_annot59.getTree());
            	    pushFollow(FOLLOW_modif_annot_in_declar_m_a1585);
            	    modif_annot60=modif_annot();

            	    state._fsp--;

            	    adaptor.addChild(root_0, modif_annot60.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declar_m_a"

    public static class modif_annot_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modif_annot"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:523:1: modif_annot : modifier annotations ;
    public final NTSParser.modif_annot_return modif_annot() throws RecognitionException {
        NTSParser.modif_annot_return retval = new NTSParser.modif_annot_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.modifier_return modifier61 = null;

        NTSParser.annotations_return annotations62 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:524:3: ( modifier annotations )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:524:5: modifier annotations
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_modifier_in_modif_annot1601);
            modifier61=modifier();

            state._fsp--;

            adaptor.addChild(root_0, modifier61.getTree());
            pushFollow(FOLLOW_annotations_in_modif_annot1603);
            annotations62=annotations();

            state._fsp--;

            adaptor.addChild(root_0, annotations62.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "modif_annot"

    public static class modifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modifier"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:527:1: modifier : (t= ( PARAM | IN | OUT ) | );
    public final NTSParser.modifier_return modifier() throws RecognitionException {
        NTSParser.modifier_return retval = new NTSParser.modifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token t=null;

        CommonTree t_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:528:3: (t= ( PARAM | IN | OUT ) | )
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:528:5: t= ( PARAM | IN | OUT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    t=(Token)input.LT(1);
                    if ( (input.LA(1)>=PARAM && input.LA(1)<=OUT) ) {
                        input.consume();
                        adaptor.addChild(root_0, (CommonTree)adaptor.create(t));
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     listener.setModifier(t, token2modifier(t)); 

                    }
                    break;
                case 2 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:529:5: 
                    {
                    root_0 = (CommonTree)adaptor.nil();

                     listener.setModifierNo(); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "modifier"

    public static class dline_annot_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dline_annot"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:532:1: dline_annot : dblock_annot ( COMMA dblock )* SEMICOLON ;
    public final NTSParser.dline_annot_return dline_annot() throws RecognitionException {
        NTSParser.dline_annot_return retval = new NTSParser.dline_annot_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA64=null;
        Token SEMICOLON66=null;
        NTSParser.dblock_annot_return dblock_annot63 = null;

        NTSParser.dblock_return dblock65 = null;


        CommonTree COMMA64_tree=null;
        CommonTree SEMICOLON66_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:533:3: ( dblock_annot ( COMMA dblock )* SEMICOLON )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:533:5: dblock_annot ( COMMA dblock )* SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_dblock_annot_in_dline_annot1649);
            dblock_annot63=dblock_annot();

            state._fsp--;

            adaptor.addChild(root_0, dblock_annot63.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:533:18: ( COMMA dblock )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==COMMA) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:533:20: COMMA dblock
            	    {
            	    COMMA64=(Token)match(input,COMMA,FOLLOW_COMMA_in_dline_annot1653); 
            	    COMMA64_tree = (CommonTree)adaptor.create(COMMA64);
            	    adaptor.addChild(root_0, COMMA64_tree);

            	    pushFollow(FOLLOW_dblock_in_dline_annot1655);
            	    dblock65=dblock();

            	    state._fsp--;

            	    adaptor.addChild(root_0, dblock65.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            SEMICOLON66=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_dline_annot1660); 
            SEMICOLON66_tree = (CommonTree)adaptor.create(SEMICOLON66);
            adaptor.addChild(root_0, SEMICOLON66_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dline_annot"

    public static class dblock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dblock"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:536:1: dblock : annotations dblock_annot ;
    public final NTSParser.dblock_return dblock() throws RecognitionException {
        NTSParser.dblock_return retval = new NTSParser.dblock_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.annotations_return annotations67 = null;

        NTSParser.dblock_annot_return dblock_annot68 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:537:3: ( annotations dblock_annot )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:537:5: annotations dblock_annot
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_annotations_in_dblock1673);
            annotations67=annotations();

            state._fsp--;

            adaptor.addChild(root_0, annotations67.getTree());
            pushFollow(FOLLOW_dblock_annot_in_dblock1675);
            dblock_annot68=dblock_annot();

            state._fsp--;

            adaptor.addChild(root_0, dblock_annot68.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dblock"

    public static class dblock_annot_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dblock_annot"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:540:1: dblock_annot : dvar_annot ( COMMA dvar )* COLON basic_type ;
    public final NTSParser.dblock_annot_return dblock_annot() throws RecognitionException {
        NTSParser.dblock_annot_return retval = new NTSParser.dblock_annot_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA70=null;
        Token COLON72=null;
        NTSParser.dvar_annot_return dvar_annot69 = null;

        NTSParser.dvar_return dvar71 = null;

        NTSParser.basic_type_return basic_type73 = null;


        CommonTree COMMA70_tree=null;
        CommonTree COLON72_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:541:3: ( dvar_annot ( COMMA dvar )* COLON basic_type )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:541:5: dvar_annot ( COMMA dvar )* COLON basic_type
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_dvar_annot_in_dblock_annot1688);
            dvar_annot69=dvar_annot();

            state._fsp--;

            adaptor.addChild(root_0, dvar_annot69.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:541:16: ( COMMA dvar )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==COMMA) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:541:17: COMMA dvar
            	    {
            	    COMMA70=(Token)match(input,COMMA,FOLLOW_COMMA_in_dblock_annot1691); 
            	    COMMA70_tree = (CommonTree)adaptor.create(COMMA70);
            	    adaptor.addChild(root_0, COMMA70_tree);

            	    pushFollow(FOLLOW_dvar_in_dblock_annot1693);
            	    dvar71=dvar();

            	    state._fsp--;

            	    adaptor.addChild(root_0, dvar71.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            COLON72=(Token)match(input,COLON,FOLLOW_COLON_in_dblock_annot1698); 
            COLON72_tree = (CommonTree)adaptor.create(COLON72);
            adaptor.addChild(root_0, COLON72_tree);

            pushFollow(FOLLOW_basic_type_in_dblock_annot1700);
            basic_type73=basic_type();

            state._fsp--;

            adaptor.addChild(root_0, basic_type73.getTree());
             listener.declarationSetBasicType((basic_type73!=null?basic_type73.rT:null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dblock_annot"

    public static class dvar_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dvar"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:545:1: dvar : annotations dvar_annot ;
    public final NTSParser.dvar_return dvar() throws RecognitionException {
        NTSParser.dvar_return retval = new NTSParser.dvar_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.annotations_return annotations74 = null;

        NTSParser.dvar_annot_return dvar_annot75 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:546:3: ( annotations dvar_annot )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:546:5: annotations dvar_annot
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_annotations_in_dvar1719);
            annotations74=annotations();

            state._fsp--;

            adaptor.addChild(root_0, annotations74.getTree());
            pushFollow(FOLLOW_dvar_annot_in_dvar1721);
            dvar_annot75=dvar_annot();

            state._fsp--;

            adaptor.addChild(root_0, dvar_annot75.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dvar"

    public static class dvar_annot_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dvar_annot"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:549:1: dvar_annot : name= IDN ( LPAR_S ( expr )? RPAR_S )* ;
    public final NTSParser.dvar_annot_return dvar_annot() throws RecognitionException {
        NTSParser.dvar_annot_return retval = new NTSParser.dvar_annot_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token name=null;
        Token LPAR_S76=null;
        Token RPAR_S78=null;
        NTSParser.expr_return expr77 = null;


        CommonTree name_tree=null;
        CommonTree LPAR_S76_tree=null;
        CommonTree RPAR_S78_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:550:3: (name= IDN ( LPAR_S ( expr )? RPAR_S )* )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:550:5: name= IDN ( LPAR_S ( expr )? RPAR_S )*
            {
            root_0 = (CommonTree)adaptor.nil();

             int s=0; // 0=(basic type), 1=(pure array reference), 2=(not pure array reference);  0-initial, 0->1, 0->2 OK 
                  int x=0; // total dimension
                  int y=0; // own dimension
                
            name=(Token)match(input,IDN,FOLLOW_IDN_in_dvar_annot1742); 
            name_tree = (CommonTree)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);

            // /home/filip/workspace/nts/src/nts/parser/NTS.g:555:5: ( LPAR_S ( expr )? RPAR_S )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==LPAR_S) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:555:7: LPAR_S ( expr )? RPAR_S
            	    {
            	    LPAR_S76=(Token)match(input,LPAR_S,FOLLOW_LPAR_S_in_dvar_annot1750); 
            	    LPAR_S76_tree = (CommonTree)adaptor.create(LPAR_S76);
            	    adaptor.addChild(root_0, LPAR_S76_tree);

            	     x++; 
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:557:7: ( expr )?
            	    int alt22=2;
            	    alt22 = dfa22.predict(input);
            	    switch (alt22) {
            	        case 1 :
            	            // /home/filip/workspace/nts/src/nts/parser/NTS.g:557:9: expr
            	            {
            	            pushFollow(FOLLOW_expr_in_dvar_annot1769);
            	            expr77=expr();

            	            state._fsp--;

            	            adaptor.addChild(root_0, expr77.getTree());
            	             if (s==1) {
            	                        System.err.println("Syntax error at "+Common.at(name)+". Reference to array of specific sizes is not a valid type.");
            	                        System.exit(1);
            	                      }
            	                      if (s==0) s=2;
            	                      y++;
            	                    

            	            }
            	            break;

            	    }

            	     if (s==0) s=1; 
            	    RPAR_S78=(Token)match(input,RPAR_S,FOLLOW_RPAR_S_in_dvar_annot1806); 
            	    RPAR_S78_tree = (CommonTree)adaptor.create(RPAR_S78);
            	    adaptor.addChild(root_0, RPAR_S78_tree);


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             listener.declarationAdd(name,y,x); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dvar_annot"

    public static class basic_type_return extends ParserRuleReturnScope {
        public EBasicType rT;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "basic_type"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:572:1: basic_type returns [EBasicType rT] : t= ( TBOOL | TINT | TREAL ) ;
    public final NTSParser.basic_type_return basic_type() throws RecognitionException {
        NTSParser.basic_type_return retval = new NTSParser.basic_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token t=null;

        CommonTree t_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:573:3: (t= ( TBOOL | TINT | TREAL ) )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:573:5: t= ( TBOOL | TINT | TREAL )
            {
            root_0 = (CommonTree)adaptor.nil();

            t=(Token)input.LT(1);
            if ( (input.LA(1)>=TBOOL && input.LA(1)<=TREAL) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(t));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             retval.rT = token2basicType(t); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "basic_type"

    public static class qdecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qdecl"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:581:1: qdecl : qd_block ( COMMA qd_block )* DOT ;
    public final NTSParser.qdecl_return qdecl() throws RecognitionException {
        NTSParser.qdecl_return retval = new NTSParser.qdecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA80=null;
        Token DOT82=null;
        NTSParser.qd_block_return qd_block79 = null;

        NTSParser.qd_block_return qd_block81 = null;


        CommonTree COMMA80_tree=null;
        CommonTree DOT82_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:582:3: ( qd_block ( COMMA qd_block )* DOT )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:582:5: qd_block ( COMMA qd_block )* DOT
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_qd_block_in_qdecl1868);
            qd_block79=qd_block();

            state._fsp--;

            adaptor.addChild(root_0, qd_block79.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:582:14: ( COMMA qd_block )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==COMMA) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:582:16: COMMA qd_block
            	    {
            	    COMMA80=(Token)match(input,COMMA,FOLLOW_COMMA_in_qdecl1872); 
            	    COMMA80_tree = (CommonTree)adaptor.create(COMMA80);
            	    adaptor.addChild(root_0, COMMA80_tree);

            	    pushFollow(FOLLOW_qd_block_in_qdecl1874);
            	    qd_block81=qd_block();

            	    state._fsp--;

            	    adaptor.addChild(root_0, qd_block81.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            DOT82=(Token)match(input,DOT,FOLLOW_DOT_in_qdecl1879); 
            DOT82_tree = (CommonTree)adaptor.create(DOT82);
            adaptor.addChild(root_0, DOT82_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "qdecl"

    public static class qd_block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qd_block"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:585:1: qd_block : id1= IDN ( COMMA id2= IDN )* COLON qd_type ;
    public final NTSParser.qd_block_return qd_block() throws RecognitionException {
        NTSParser.qd_block_return retval = new NTSParser.qd_block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token id1=null;
        Token id2=null;
        Token COMMA83=null;
        Token COLON84=null;
        NTSParser.qd_type_return qd_type85 = null;


        CommonTree id1_tree=null;
        CommonTree id2_tree=null;
        CommonTree COMMA83_tree=null;
        CommonTree COLON84_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:586:3: (id1= IDN ( COMMA id2= IDN )* COLON qd_type )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:586:5: id1= IDN ( COMMA id2= IDN )* COLON qd_type
            {
            root_0 = (CommonTree)adaptor.nil();

            id1=(Token)match(input,IDN,FOLLOW_IDN_in_qd_block1894); 
            id1_tree = (CommonTree)adaptor.create(id1);
            adaptor.addChild(root_0, id1_tree);

             listener.declarationQ(id1); 
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:587:5: ( COMMA id2= IDN )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==COMMA) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:587:7: COMMA id2= IDN
            	    {
            	    COMMA83=(Token)match(input,COMMA,FOLLOW_COMMA_in_qd_block1905); 
            	    COMMA83_tree = (CommonTree)adaptor.create(COMMA83);
            	    adaptor.addChild(root_0, COMMA83_tree);

            	    id2=(Token)match(input,IDN,FOLLOW_IDN_in_qd_block1909); 
            	    id2_tree = (CommonTree)adaptor.create(id2);
            	    adaptor.addChild(root_0, id2_tree);

            	     listener.declarationQ(id2); 

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            COLON84=(Token)match(input,COLON,FOLLOW_COLON_in_qd_block1921); 
            COLON84_tree = (CommonTree)adaptor.create(COLON84);
            adaptor.addChild(root_0, COLON84_tree);

            pushFollow(FOLLOW_qd_type_in_qd_block1923);
            qd_type85=qd_type();

            state._fsp--;

            adaptor.addChild(root_0, qd_type85.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "qd_block"

    public static class qd_type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qd_type"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:591:1: qd_type : b= basic_type ( LPAR_S expr COMMA expr RPAR_S )? ;
    public final NTSParser.qd_type_return qd_type() throws RecognitionException {
        NTSParser.qd_type_return retval = new NTSParser.qd_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAR_S86=null;
        Token COMMA88=null;
        Token RPAR_S90=null;
        NTSParser.basic_type_return b = null;

        NTSParser.expr_return expr87 = null;

        NTSParser.expr_return expr89 = null;


        CommonTree LPAR_S86_tree=null;
        CommonTree COMMA88_tree=null;
        CommonTree RPAR_S90_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:592:3: (b= basic_type ( LPAR_S expr COMMA expr RPAR_S )? )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:592:5: b= basic_type ( LPAR_S expr COMMA expr RPAR_S )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_basic_type_in_qd_type1938);
            b=basic_type();

            state._fsp--;

            adaptor.addChild(root_0, b.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:593:5: ( LPAR_S expr COMMA expr RPAR_S )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==LPAR_S) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:593:7: LPAR_S expr COMMA expr RPAR_S
                    {
                    LPAR_S86=(Token)match(input,LPAR_S,FOLLOW_LPAR_S_in_qd_type1946); 
                    LPAR_S86_tree = (CommonTree)adaptor.create(LPAR_S86);
                    adaptor.addChild(root_0, LPAR_S86_tree);

                    pushFollow(FOLLOW_expr_in_qd_type1948);
                    expr87=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr87.getTree());
                    COMMA88=(Token)match(input,COMMA,FOLLOW_COMMA_in_qd_type1950); 
                    COMMA88_tree = (CommonTree)adaptor.create(COMMA88);
                    adaptor.addChild(root_0, COMMA88_tree);

                    pushFollow(FOLLOW_expr_in_qd_type1952);
                    expr89=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr89.getTree());
                    RPAR_S90=(Token)match(input,RPAR_S,FOLLOW_RPAR_S_in_qd_type1954); 
                    RPAR_S90_tree = (CommonTree)adaptor.create(RPAR_S90);
                    adaptor.addChild(root_0, RPAR_S90_tree);


                    }
                    break;

            }

             listener.declarationQ((b!=null?b.rT:null), LPAR_S86); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "qd_type"

    public static class transition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "transition"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:601:1: transition : (id0= IDN COLON )? id1= IDN C_IMPL id2= IDN a= annotations LPAR_C l= label RPAR_C ;
    public final NTSParser.transition_return transition() throws RecognitionException {
        NTSParser.transition_return retval = new NTSParser.transition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token id0=null;
        Token id1=null;
        Token id2=null;
        Token COLON91=null;
        Token C_IMPL92=null;
        Token LPAR_C93=null;
        Token RPAR_C94=null;
        NTSParser.annotations_return a = null;

        NTSParser.label_return l = null;


        CommonTree id0_tree=null;
        CommonTree id1_tree=null;
        CommonTree id2_tree=null;
        CommonTree COLON91_tree=null;
        CommonTree C_IMPL92_tree=null;
        CommonTree LPAR_C93_tree=null;
        CommonTree RPAR_C94_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:602:3: ( (id0= IDN COLON )? id1= IDN C_IMPL id2= IDN a= annotations LPAR_C l= label RPAR_C )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:602:5: (id0= IDN COLON )? id1= IDN C_IMPL id2= IDN a= annotations LPAR_C l= label RPAR_C
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/filip/workspace/nts/src/nts/parser/NTS.g:602:5: (id0= IDN COLON )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==IDN) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==COLON) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:602:7: id0= IDN COLON
                    {
                    id0=(Token)match(input,IDN,FOLLOW_IDN_in_transition1984); 
                    id0_tree = (CommonTree)adaptor.create(id0);
                    adaptor.addChild(root_0, id0_tree);

                    COLON91=(Token)match(input,COLON,FOLLOW_COLON_in_transition1986); 
                    COLON91_tree = (CommonTree)adaptor.create(COLON91);
                    adaptor.addChild(root_0, COLON91_tree);


                    }
                    break;

            }

            id1=(Token)match(input,IDN,FOLLOW_IDN_in_transition1993); 
            id1_tree = (CommonTree)adaptor.create(id1);
            adaptor.addChild(root_0, id1_tree);

            C_IMPL92=(Token)match(input,C_IMPL,FOLLOW_C_IMPL_in_transition1995); 
            C_IMPL92_tree = (CommonTree)adaptor.create(C_IMPL92);
            adaptor.addChild(root_0, C_IMPL92_tree);

            id2=(Token)match(input,IDN,FOLLOW_IDN_in_transition1999); 
            id2_tree = (CommonTree)adaptor.create(id2);
            adaptor.addChild(root_0, id2_tree);

            pushFollow(FOLLOW_annotations_in_transition2003);
            a=annotations();

            state._fsp--;

            adaptor.addChild(root_0, a.getTree());
            LPAR_C93=(Token)match(input,LPAR_C,FOLLOW_LPAR_C_in_transition2005); 
            LPAR_C93_tree = (CommonTree)adaptor.create(LPAR_C93);
            adaptor.addChild(root_0, LPAR_C93_tree);

            pushFollow(FOLLOW_label_in_transition2009);
            l=label();

            state._fsp--;

            adaptor.addChild(root_0, l.getTree());
            RPAR_C94=(Token)match(input,RPAR_C,FOLLOW_RPAR_C_in_transition2011); 
            RPAR_C94_tree = (CommonTree)adaptor.create(RPAR_C94);
            adaptor.addChild(root_0, RPAR_C94_tree);

             listener.transition(id0,id1,id2,(l!=null?l.rL:null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "transition"

    public static class label_return extends ParserRuleReturnScope {
        public ILabel rL;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "label"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:605:1: label returns [ILabel rL] : ({...}? call_havoc | expr | );
    public final NTSParser.label_return label() throws RecognitionException {
        NTSParser.label_return retval = new NTSParser.label_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.call_havoc_return call_havoc95 = null;

        NTSParser.expr_return expr96 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:606:3: ({...}? call_havoc | expr | )
            int alt28=3;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:606:5: {...}? call_havoc
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    if ( !(( isCall() )) ) {
                        throw new FailedPredicateException(input, "label", " isCall() ");
                    }
                    pushFollow(FOLLOW_call_havoc_in_label2035);
                    call_havoc95=call_havoc();

                    state._fsp--;

                    adaptor.addChild(root_0, call_havoc95.getTree());
                     retval.rL = listener.labelCall(); 

                    }
                    break;
                case 2 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:607:5: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expr_in_label2043);
                    expr96=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr96.getTree());
                     retval.rL = listener.labelExpr(); 

                    }
                    break;
                case 3 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:608:5: 
                    {
                    root_0 = (CommonTree)adaptor.nil();

                     retval.rL = listener.labelDummyTrue(dummyTrue()); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "label"

    public static class call_havoc_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "call_havoc"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:615:1: call_havoc : call ;
    public final NTSParser.call_havoc_return call_havoc() throws RecognitionException {
        NTSParser.call_havoc_return retval = new NTSParser.call_havoc_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.call_return call97 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:616:3: ( call )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:616:5: call
            {
            root_0 = (CommonTree)adaptor.nil();

             listener.callInit(); 
            pushFollow(FOLLOW_call_in_call_havoc2074);
            call97=call();

            state._fsp--;

            adaptor.addChild(root_0, call97.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "call_havoc"

    public static class call_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "call"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:622:1: call : ( ret_idp EQ call2[ECallArg.ACT] | call2[ECallArg.ACTRET] | LPAR retlist RPAR EQ call2[ECallArg.ACT] );
    public final NTSParser.call_return call() throws RecognitionException {
        NTSParser.call_return retval = new NTSParser.call_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQ99=null;
        Token LPAR102=null;
        Token RPAR104=null;
        Token EQ105=null;
        NTSParser.ret_idp_return ret_idp98 = null;

        NTSParser.call2_return call2100 = null;

        NTSParser.call2_return call2101 = null;

        NTSParser.retlist_return retlist103 = null;

        NTSParser.call2_return call2106 = null;


        CommonTree EQ99_tree=null;
        CommonTree LPAR102_tree=null;
        CommonTree RPAR104_tree=null;
        CommonTree EQ105_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:623:3: ( ret_idp EQ call2[ECallArg.ACT] | call2[ECallArg.ACTRET] | LPAR retlist RPAR EQ call2[ECallArg.ACT] )
            int alt29=3;
            switch ( input.LA(1) ) {
            case IDP:
                {
                alt29=1;
                }
                break;
            case IDN:
                {
                alt29=2;
                }
                break;
            case LPAR:
                {
                alt29=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:623:5: ret_idp EQ call2[ECallArg.ACT]
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ret_idp_in_call2101);
                    ret_idp98=ret_idp();

                    state._fsp--;

                    adaptor.addChild(root_0, ret_idp98.getTree());
                    EQ99=(Token)match(input,EQ,FOLLOW_EQ_in_call2107); 
                    EQ99_tree = (CommonTree)adaptor.create(EQ99);
                    adaptor.addChild(root_0, EQ99_tree);

                    pushFollow(FOLLOW_call2_in_call2109);
                    call2100=call2(ECallArg.ACT);

                    state._fsp--;

                    adaptor.addChild(root_0, call2100.getTree());

                    }
                    break;
                case 2 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:625:5: call2[ECallArg.ACTRET]
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_call2_in_call2116);
                    call2101=call2(ECallArg.ACTRET);

                    state._fsp--;

                    adaptor.addChild(root_0, call2101.getTree());

                    }
                    break;
                case 3 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:626:5: LPAR retlist RPAR EQ call2[ECallArg.ACT]
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LPAR102=(Token)match(input,LPAR,FOLLOW_LPAR_in_call2123); 
                    LPAR102_tree = (CommonTree)adaptor.create(LPAR102);
                    adaptor.addChild(root_0, LPAR102_tree);

                    pushFollow(FOLLOW_retlist_in_call2125);
                    retlist103=retlist();

                    state._fsp--;

                    adaptor.addChild(root_0, retlist103.getTree());
                    RPAR104=(Token)match(input,RPAR,FOLLOW_RPAR_in_call2127); 
                    RPAR104_tree = (CommonTree)adaptor.create(RPAR104);
                    adaptor.addChild(root_0, RPAR104_tree);

                    EQ105=(Token)match(input,EQ,FOLLOW_EQ_in_call2129); 
                    EQ105_tree = (CommonTree)adaptor.create(EQ105);
                    adaptor.addChild(root_0, EQ105_tree);

                    pushFollow(FOLLOW_call2_in_call2131);
                    call2106=call2(ECallArg.ACT);

                    state._fsp--;

                    adaptor.addChild(root_0, call2106.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "call"

    public static class call2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "call2"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:628:1: call2[ECallArg code] : IDN LPAR ( expr ( COMMA expr )* )? RPAR ;
    public final NTSParser.call2_return call2(ECallArg code) throws RecognitionException {
        NTSParser.call2_return retval = new NTSParser.call2_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDN107=null;
        Token LPAR108=null;
        Token COMMA110=null;
        Token RPAR112=null;
        NTSParser.expr_return expr109 = null;

        NTSParser.expr_return expr111 = null;


        CommonTree IDN107_tree=null;
        CommonTree LPAR108_tree=null;
        CommonTree COMMA110_tree=null;
        CommonTree RPAR112_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:629:3: ( IDN LPAR ( expr ( COMMA expr )* )? RPAR )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:629:5: IDN LPAR ( expr ( COMMA expr )* )? RPAR
            {
            root_0 = (CommonTree)adaptor.nil();

            IDN107=(Token)match(input,IDN,FOLLOW_IDN_in_call22145); 
            IDN107_tree = (CommonTree)adaptor.create(IDN107);
            adaptor.addChild(root_0, IDN107_tree);

             listener.callSetCallee(IDN107); 
            LPAR108=(Token)match(input,LPAR,FOLLOW_LPAR_in_call22153); 
            LPAR108_tree = (CommonTree)adaptor.create(LPAR108);
            adaptor.addChild(root_0, LPAR108_tree);

            // /home/filip/workspace/nts/src/nts/parser/NTS.g:631:5: ( expr ( COMMA expr )* )?
            int alt31=2;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:631:7: expr ( COMMA expr )*
                    {
                    pushFollow(FOLLOW_expr_in_call22161);
                    expr109=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr109.getTree());
                     listener.callAddArgRet(code); 
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:632:7: ( COMMA expr )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==COMMA) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:632:9: COMMA expr
                    	    {
                    	    COMMA110=(Token)match(input,COMMA,FOLLOW_COMMA_in_call22174); 
                    	    COMMA110_tree = (CommonTree)adaptor.create(COMMA110);
                    	    adaptor.addChild(root_0, COMMA110_tree);

                    	    pushFollow(FOLLOW_expr_in_call22176);
                    	    expr111=expr();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, expr111.getTree());
                    	     listener.callAddArgRet(code); 

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }
                    break;

            }

            RPAR112=(Token)match(input,RPAR,FOLLOW_RPAR_in_call22198); 
            RPAR112_tree = (CommonTree)adaptor.create(RPAR112);
            adaptor.addChild(root_0, RPAR112_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "call2"

    public static class retlist_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "retlist"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:636:1: retlist : ret_idp ( COMMA ret_idp )* ;
    public final NTSParser.retlist_return retlist() throws RecognitionException {
        NTSParser.retlist_return retval = new NTSParser.retlist_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA114=null;
        NTSParser.ret_idp_return ret_idp113 = null;

        NTSParser.ret_idp_return ret_idp115 = null;


        CommonTree COMMA114_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:637:3: ( ret_idp ( COMMA ret_idp )* )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:637:5: ret_idp ( COMMA ret_idp )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_ret_idp_in_retlist2210);
            ret_idp113=ret_idp();

            state._fsp--;

            adaptor.addChild(root_0, ret_idp113.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:637:13: ( COMMA ret_idp )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==COMMA) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:637:15: COMMA ret_idp
            	    {
            	    COMMA114=(Token)match(input,COMMA,FOLLOW_COMMA_in_retlist2214); 
            	    COMMA114_tree = (CommonTree)adaptor.create(COMMA114);
            	    adaptor.addChild(root_0, COMMA114_tree);

            	    pushFollow(FOLLOW_ret_idp_in_retlist2216);
            	    ret_idp115=ret_idp();

            	    state._fsp--;

            	    adaptor.addChild(root_0, ret_idp115.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "retlist"

    public static class ret_idp_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ret_idp"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:639:1: ret_idp : IDP ;
    public final NTSParser.ret_idp_return ret_idp() throws RecognitionException {
        NTSParser.ret_idp_return retval = new NTSParser.ret_idp_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDP116=null;

        CommonTree IDP116_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:640:3: ( IDP )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:640:5: IDP
            {
            root_0 = (CommonTree)adaptor.nil();

            IDP116=(Token)match(input,IDP,FOLLOW_IDP_in_ret_idp2231); 
            IDP116_tree = (CommonTree)adaptor.create(IDP116);
            adaptor.addChild(root_0, IDP116_tree);

             listener.access(IDP116,0,0);
                  listener.callAddArgRet(ECallArg.RET);
                

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ret_idp"

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:650:1: expr : equiv ;
    public final NTSParser.expr_return expr() throws RecognitionException {
        NTSParser.expr_return retval = new NTSParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.equiv_return equiv117 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:651:3: ( equiv )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:651:5: equiv
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_equiv_in_expr2255);
            equiv117=equiv();

            state._fsp--;

            adaptor.addChild(root_0, equiv117.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class equiv_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equiv"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:653:1: equiv : impl (op= op_equiv impl )* ;
    public final NTSParser.equiv_return equiv() throws RecognitionException {
        NTSParser.equiv_return retval = new NTSParser.equiv_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.op_equiv_return op = null;

        NTSParser.impl_return impl118 = null;

        NTSParser.impl_return impl119 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:654:3: ( impl (op= op_equiv impl )* )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:654:5: impl (op= op_equiv impl )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_impl_in_equiv2267);
            impl118=impl();

            state._fsp--;

            adaptor.addChild(root_0, impl118.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:654:10: (op= op_equiv impl )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==EQUIV||LA33_0==C_EQUIV) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:654:12: op= op_equiv impl
            	    {
            	    pushFollow(FOLLOW_op_equiv_in_equiv2273);
            	    op=op_equiv();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op.getTree());
            	    pushFollow(FOLLOW_impl_in_equiv2275);
            	    impl119=impl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, impl119.getTree());
            	     listener.equiv((op!=null?((Token)op.start):null)); 

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "equiv"

    public static class impl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "impl"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:656:1: impl : or (op= op_impl or )* ;
    public final NTSParser.impl_return impl() throws RecognitionException {
        NTSParser.impl_return retval = new NTSParser.impl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.op_impl_return op = null;

        NTSParser.or_return or120 = null;

        NTSParser.or_return or121 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:657:3: ( or (op= op_impl or )* )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:657:5: or (op= op_impl or )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_or_in_impl2292);
            or120=or();

            state._fsp--;

            adaptor.addChild(root_0, or120.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:657:8: (op= op_impl or )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==IMPL||LA34_0==C_IMPL) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:657:10: op= op_impl or
            	    {
            	    pushFollow(FOLLOW_op_impl_in_impl2298);
            	    op=op_impl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op.getTree());
            	    pushFollow(FOLLOW_or_in_impl2300);
            	    or121=or();

            	    state._fsp--;

            	    adaptor.addChild(root_0, or121.getTree());
            	     listener.impl((op!=null?((Token)op.start):null)); 

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "impl"

    public static class or_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "or"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:659:1: or : and (op= op_or and )* ;
    public final NTSParser.or_return or() throws RecognitionException {
        NTSParser.or_return retval = new NTSParser.or_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.op_or_return op = null;

        NTSParser.and_return and122 = null;

        NTSParser.and_return and123 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:660:3: ( and (op= op_or and )* )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:660:5: and (op= op_or and )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_and_in_or2317);
            and122=and();

            state._fsp--;

            adaptor.addChild(root_0, and122.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:660:9: (op= op_or and )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==OR||LA35_0==C_OR) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:660:11: op= op_or and
            	    {
            	    pushFollow(FOLLOW_op_or_in_or2323);
            	    op=op_or();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op.getTree());
            	    pushFollow(FOLLOW_and_in_or2325);
            	    and123=and();

            	    state._fsp--;

            	    adaptor.addChild(root_0, and123.getTree());
            	     listener.or((op!=null?((Token)op.start):null)); 

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "or"

    public static class and_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "and"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:662:1: and : not (op= op_and not )* ;
    public final NTSParser.and_return and() throws RecognitionException {
        NTSParser.and_return retval = new NTSParser.and_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.op_and_return op = null;

        NTSParser.not_return not124 = null;

        NTSParser.not_return not125 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:663:3: ( not (op= op_and not )* )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:663:5: not (op= op_and not )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_not_in_and2342);
            not124=not();

            state._fsp--;

            adaptor.addChild(root_0, not124.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:663:9: (op= op_and not )*
            loop36:
            do {
                int alt36=2;
                alt36 = dfa36.predict(input);
                switch (alt36) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:663:11: op= op_and not
            	    {
            	    pushFollow(FOLLOW_op_and_in_and2348);
            	    op=op_and();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op.getTree());
            	    pushFollow(FOLLOW_not_in_and2350);
            	    not125=not();

            	    state._fsp--;

            	    adaptor.addChild(root_0, not125.getTree());
            	     listener.and((op!=null?((Token)op.start):null)); 

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "and"

    public static class not_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "not"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:665:1: not : (op= op_not )* predicate ;
    public final NTSParser.not_return not() throws RecognitionException {
        NTSParser.not_return retval = new NTSParser.not_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.op_not_return op = null;

        NTSParser.predicate_return predicate126 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:666:3: ( (op= op_not )* predicate )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:666:5: (op= op_not )* predicate
            {
            root_0 = (CommonTree)adaptor.nil();

             int n = 0; 
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:667:5: (op= op_not )*
            loop37:
            do {
                int alt37=2;
                alt37 = dfa37.predict(input);
                switch (alt37) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:667:6: op= op_not
            	    {
            	    pushFollow(FOLLOW_op_not_in_not2376);
            	    op=op_not();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op.getTree());
            	    n++;

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            pushFollow(FOLLOW_predicate_in_not2383);
            predicate126=predicate();

            state._fsp--;

            adaptor.addChild(root_0, predicate126.getTree());
             if ((n%2 == 1))
                     listener.not((op!=null?((Token)op.start):null));
                

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "not"

    public static class predicate_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicate"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:673:1: predicate : ( havoc | quant | pred_rop );
    public final NTSParser.predicate_return predicate() throws RecognitionException {
        NTSParser.predicate_return retval = new NTSParser.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.havoc_return havoc127 = null;

        NTSParser.quant_return quant128 = null;

        NTSParser.pred_rop_return pred_rop129 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:674:3: ( havoc | quant | pred_rop )
            int alt38=3;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:674:5: havoc
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_havoc_in_predicate2402);
                    havoc127=havoc();

                    state._fsp--;

                    adaptor.addChild(root_0, havoc127.getTree());

                    }
                    break;
                case 2 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:675:5: quant
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_quant_in_predicate2408);
                    quant128=quant();

                    state._fsp--;

                    adaptor.addChild(root_0, quant128.getTree());

                    }
                    break;
                case 3 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:676:5: pred_rop
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pred_rop_in_predicate2415);
                    pred_rop129=pred_rop();

                    state._fsp--;

                    adaptor.addChild(root_0, pred_rop129.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "predicate"

    public static class pred_rop_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pred_rop"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:678:1: pred_rop : plusminus (op= rop plusminus )? ;
    public final NTSParser.pred_rop_return pred_rop() throws RecognitionException {
        NTSParser.pred_rop_return retval = new NTSParser.pred_rop_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.rop_return op = null;

        NTSParser.plusminus_return plusminus130 = null;

        NTSParser.plusminus_return plusminus131 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:679:3: ( plusminus (op= rop plusminus )? )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:679:5: plusminus (op= rop plusminus )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_plusminus_in_pred_rop2427);
            plusminus130=plusminus();

            state._fsp--;

            adaptor.addChild(root_0, plusminus130.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:680:5: (op= rop plusminus )?
            int alt39=2;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:680:7: op= rop plusminus
                    {
                    pushFollow(FOLLOW_rop_in_pred_rop2437);
                    op=rop();

                    state._fsp--;

                    adaptor.addChild(root_0, op.getTree());
                    pushFollow(FOLLOW_plusminus_in_pred_rop2439);
                    plusminus131=plusminus();

                    state._fsp--;

                    adaptor.addChild(root_0, plusminus131.getTree());
                     Token tok = (op!=null?((Token)op.start):null);
                            switch(tok.getType()) {
                              case EQ: listener.eq(tok); break;
                              case NEQ: listener.neq(tok); break;
                              case LEQ: listener.leq(tok); break;
                              case LT: listener.lt(tok); break;
                              case GEQ: listener.geq(tok); break;
                              case GT: listener.gt(tok); break;
                              default: throw new RuntimeException("internal error");
                            }
                          

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pred_rop"

    public static class quant_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "quant"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:695:1: quant : qq= quantifier qdecl predicate ;
    public final NTSParser.quant_return quant() throws RecognitionException {
        NTSParser.quant_return retval = new NTSParser.quant_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.quantifier_return qq = null;

        NTSParser.qdecl_return qdecl132 = null;

        NTSParser.predicate_return predicate133 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:696:3: (qq= quantifier qdecl predicate )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:696:5: qq= quantifier qdecl predicate
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_quantifier_in_quant2470);
            qq=quantifier();

            state._fsp--;

            adaptor.addChild(root_0, qq.getTree());
             Token tok = (qq!=null?((Token)qq.start):null);
                  int tt = tok.getType();
                  listener.quantifierInit(tok, (tt == EXISTS));
                
            pushFollow(FOLLOW_qdecl_in_quant2487);
            qdecl132=qdecl();

            state._fsp--;

            adaptor.addChild(root_0, qdecl132.getTree());
            pushFollow(FOLLOW_predicate_in_quant2497);
            predicate133=predicate();

            state._fsp--;

            adaptor.addChild(root_0, predicate133.getTree());
             listener.quantifierFinalize(); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "quant"

    public static class plusminus_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "plusminus"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:707:1: plusminus : mult_div_rem (op= pm mult_div_rem )* ;
    public final NTSParser.plusminus_return plusminus() throws RecognitionException {
        NTSParser.plusminus_return retval = new NTSParser.plusminus_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.pm_return op = null;

        NTSParser.mult_div_rem_return mult_div_rem134 = null;

        NTSParser.mult_div_rem_return mult_div_rem135 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:708:3: ( mult_div_rem (op= pm mult_div_rem )* )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:708:5: mult_div_rem (op= pm mult_div_rem )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_mult_div_rem_in_plusminus2520);
            mult_div_rem134=mult_div_rem();

            state._fsp--;

            adaptor.addChild(root_0, mult_div_rem134.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:709:5: (op= pm mult_div_rem )*
            loop40:
            do {
                int alt40=2;
                alt40 = dfa40.predict(input);
                switch (alt40) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:709:7: op= pm mult_div_rem
            	    {
            	    pushFollow(FOLLOW_pm_in_plusminus2531);
            	    op=pm();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op.getTree());
            	    pushFollow(FOLLOW_mult_div_rem_in_plusminus2533);
            	    mult_div_rem135=mult_div_rem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, mult_div_rem135.getTree());
            	     Token tok = (op!=null?((Token)op.start):null);
            	            switch(tok.getType()) {
            	              case PLUS: listener.plus(tok); break;
            	              case MINUS: listener.minus(tok); break;
            	              default: throw new RuntimeException("internal error");
            	            }
            	          

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "plusminus"

    public static class mult_div_rem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mult_div_rem"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:719:1: mult_div_rem : un_plusminus (op= mdr un_plusminus )* ;
    public final NTSParser.mult_div_rem_return mult_div_rem() throws RecognitionException {
        NTSParser.mult_div_rem_return retval = new NTSParser.mult_div_rem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        NTSParser.mdr_return op = null;

        NTSParser.un_plusminus_return un_plusminus136 = null;

        NTSParser.un_plusminus_return un_plusminus137 = null;



        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:720:3: ( un_plusminus (op= mdr un_plusminus )* )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:720:5: un_plusminus (op= mdr un_plusminus )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_un_plusminus_in_mult_div_rem2561);
            un_plusminus136=un_plusminus();

            state._fsp--;

            adaptor.addChild(root_0, un_plusminus136.getTree());
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:721:5: (op= mdr un_plusminus )*
            loop41:
            do {
                int alt41=2;
                alt41 = dfa41.predict(input);
                switch (alt41) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:721:7: op= mdr un_plusminus
            	    {
            	    pushFollow(FOLLOW_mdr_in_mult_div_rem2572);
            	    op=mdr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op.getTree());
            	    pushFollow(FOLLOW_un_plusminus_in_mult_div_rem2574);
            	    un_plusminus137=un_plusminus();

            	    state._fsp--;

            	    adaptor.addChild(root_0, un_plusminus137.getTree());
            	     Token tok = (op!=null?((Token)op.start):null);
            	            switch(tok.getType()) {
            	              case MULT: listener.mult(tok); break;
            	              case DIVIDE: listener.divide(tok); break;
            	              case REMAINDER: listener.remainder(tok); break;
            	              default: throw new RuntimeException("internal error");
            	            }
            	          

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mult_div_rem"

    public static class un_plusminus_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "un_plusminus"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:732:1: un_plusminus : (m= MINUS )? atom ;
    public final NTSParser.un_plusminus_return un_plusminus() throws RecognitionException {
        NTSParser.un_plusminus_return retval = new NTSParser.un_plusminus_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token m=null;
        NTSParser.atom_return atom138 = null;


        CommonTree m_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:733:3: ( (m= MINUS )? atom )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:733:5: (m= MINUS )? atom
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/filip/workspace/nts/src/nts/parser/NTS.g:733:5: (m= MINUS )?
            int alt42=2;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:733:6: m= MINUS
                    {
                    m=(Token)match(input,MINUS,FOLLOW_MINUS_in_un_plusminus2605); 
                    m_tree = (CommonTree)adaptor.create(m);
                    adaptor.addChild(root_0, m_tree);


                    }
                    break;

            }

            pushFollow(FOLLOW_atom_in_un_plusminus2609);
            atom138=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom138.getTree());
             if (m != null) listener.unaryMinus(m); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "un_plusminus"

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:736:1: atom : ( access | literal | many_expr | arrsize | LPAR expr RPAR );
    public final NTSParser.atom_return atom() throws RecognitionException {
        NTSParser.atom_return retval = new NTSParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAR143=null;
        Token RPAR145=null;
        NTSParser.access_return access139 = null;

        NTSParser.literal_return literal140 = null;

        NTSParser.many_expr_return many_expr141 = null;

        NTSParser.arrsize_return arrsize142 = null;

        NTSParser.expr_return expr144 = null;


        CommonTree LPAR143_tree=null;
        CommonTree RPAR145_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:737:3: ( access | literal | many_expr | arrsize | LPAR expr RPAR )
            int alt43=5;
            switch ( input.LA(1) ) {
            case IDN:
            case IDP:
            case TID:
                {
                alt43=1;
                }
                break;
            case LITINT:
            case LITREAL:
            case TRUE:
            case FALSE:
                {
                alt43=2;
                }
                break;
            case LPAR_S:
                {
                alt43=3;
                }
                break;
            case VBAR:
                {
                alt43=4;
                }
                break;
            case LPAR:
                {
                alt43=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:737:5: access
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_access_in_atom2627);
                    access139=access();

                    state._fsp--;

                    adaptor.addChild(root_0, access139.getTree());

                    }
                    break;
                case 2 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:738:5: literal
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_atom2633);
                    literal140=literal();

                    state._fsp--;

                    adaptor.addChild(root_0, literal140.getTree());

                    }
                    break;
                case 3 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:739:5: many_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_many_expr_in_atom2639);
                    many_expr141=many_expr();

                    state._fsp--;

                    adaptor.addChild(root_0, many_expr141.getTree());

                    }
                    break;
                case 4 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:740:5: arrsize
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrsize_in_atom2645);
                    arrsize142=arrsize();

                    state._fsp--;

                    adaptor.addChild(root_0, arrsize142.getTree());

                    }
                    break;
                case 5 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:741:5: LPAR expr RPAR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LPAR143=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom2651); 
                    LPAR143_tree = (CommonTree)adaptor.create(LPAR143);
                    adaptor.addChild(root_0, LPAR143_tree);

                    pushFollow(FOLLOW_expr_in_atom2653);
                    expr144=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr144.getTree());
                    RPAR145=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom2655); 
                    RPAR145_tree = (CommonTree)adaptor.create(RPAR145);
                    adaptor.addChild(root_0, RPAR145_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class many_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "many_expr"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:745:1: many_expr : LPAR_S e1= expr ( COMMA e2= expr )* RPAR_S ;
    public final NTSParser.many_expr_return many_expr() throws RecognitionException {
        NTSParser.many_expr_return retval = new NTSParser.many_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAR_S146=null;
        Token COMMA147=null;
        Token RPAR_S148=null;
        NTSParser.expr_return e1 = null;

        NTSParser.expr_return e2 = null;


        CommonTree LPAR_S146_tree=null;
        CommonTree COMMA147_tree=null;
        CommonTree RPAR_S148_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:746:3: ( LPAR_S e1= expr ( COMMA e2= expr )* RPAR_S )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:746:5: LPAR_S e1= expr ( COMMA e2= expr )* RPAR_S
            {
            root_0 = (CommonTree)adaptor.nil();

             int n = 0; 
            LPAR_S146=(Token)match(input,LPAR_S,FOLLOW_LPAR_S_in_many_expr2675); 
            LPAR_S146_tree = (CommonTree)adaptor.create(LPAR_S146);
            adaptor.addChild(root_0, LPAR_S146_tree);

            pushFollow(FOLLOW_expr_in_many_expr2685);
            e1=expr();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
             n++; 
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:749:7: ( COMMA e2= expr )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==COMMA) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:749:9: COMMA e2= expr
            	    {
            	    COMMA147=(Token)match(input,COMMA,FOLLOW_COMMA_in_many_expr2697); 
            	    COMMA147_tree = (CommonTree)adaptor.create(COMMA147);
            	    adaptor.addChild(root_0, COMMA147_tree);

            	    pushFollow(FOLLOW_expr_in_many_expr2701);
            	    e2=expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	     n++; 

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            RPAR_S148=(Token)match(input,RPAR_S,FOLLOW_RPAR_S_in_many_expr2712); 
            RPAR_S148_tree = (CommonTree)adaptor.create(RPAR_S148);
            adaptor.addChild(root_0, RPAR_S148_tree);

             listener.exprList(LPAR_S146,n); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "many_expr"

    public static class arrsize_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrsize"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:755:1: arrsize : v1= VBAR access VBAR ;
    public final NTSParser.arrsize_return arrsize() throws RecognitionException {
        NTSParser.arrsize_return retval = new NTSParser.arrsize_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token v1=null;
        Token VBAR150=null;
        NTSParser.access_return access149 = null;


        CommonTree v1_tree=null;
        CommonTree VBAR150_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:756:3: (v1= VBAR access VBAR )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:756:5: v1= VBAR access VBAR
            {
            root_0 = (CommonTree)adaptor.nil();

            v1=(Token)match(input,VBAR,FOLLOW_VBAR_in_arrsize2738); 
            v1_tree = (CommonTree)adaptor.create(v1);
            adaptor.addChild(root_0, v1_tree);

             v1.setType(ARR_LENGTH); 
            pushFollow(FOLLOW_access_in_arrsize2747);
            access149=access();

            state._fsp--;

            adaptor.addChild(root_0, access149.getTree());
            VBAR150=(Token)match(input,VBAR,FOLLOW_VBAR_in_arrsize2749); 
            VBAR150_tree = (CommonTree)adaptor.create(VBAR150);
            adaptor.addChild(root_0, VBAR150_tree);

             listener.arraySize(v1); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrsize"

    public static class access_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "access"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:764:1: access : id ( LPAR_S e1= expr ( COMMA expr )* RPAR_S )* ;
    public final NTSParser.access_return access() throws RecognitionException {
        NTSParser.access_return retval = new NTSParser.access_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAR_S152=null;
        Token COMMA153=null;
        Token RPAR_S155=null;
        NTSParser.expr_return e1 = null;

        NTSParser.id_return id151 = null;

        NTSParser.expr_return expr154 = null;


        CommonTree LPAR_S152_tree=null;
        CommonTree COMMA153_tree=null;
        CommonTree RPAR_S155_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:765:3: ( id ( LPAR_S e1= expr ( COMMA expr )* RPAR_S )* )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:765:5: id ( LPAR_S e1= expr ( COMMA expr )* RPAR_S )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_id_in_access2771);
            id151=id();

            state._fsp--;

            adaptor.addChild(root_0, id151.getTree());
             int m = 0, s = 0; 
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:769:5: ( LPAR_S e1= expr ( COMMA expr )* RPAR_S )*
            loop46:
            do {
                int alt46=2;
                alt46 = dfa46.predict(input);
                switch (alt46) {
            	case 1 :
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:771:7: LPAR_S e1= expr ( COMMA expr )* RPAR_S
            	    {
            	     if (m != 0) {
            	              System.err.println("Syntax error near "+Common.at((e1!=null?((Token)e1.start):null))+": multi-access cannot be followed by another access.");
            	              System.exit(1);
            	            }
            	          
            	    LPAR_S152=(Token)match(input,LPAR_S,FOLLOW_LPAR_S_in_access2830); 
            	    LPAR_S152_tree = (CommonTree)adaptor.create(LPAR_S152);
            	    adaptor.addChild(root_0, LPAR_S152_tree);

            	    pushFollow(FOLLOW_expr_in_access2834);
            	    e1=expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e1.getTree());
            	     m++; 
            	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:779:7: ( COMMA expr )*
            	    loop45:
            	    do {
            	        int alt45=2;
            	        int LA45_0 = input.LA(1);

            	        if ( (LA45_0==COMMA) ) {
            	            alt45=1;
            	        }


            	        switch (alt45) {
            	    	case 1 :
            	    	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:779:9: COMMA expr
            	    	    {
            	    	    COMMA153=(Token)match(input,COMMA,FOLLOW_COMMA_in_access2846); 
            	    	    COMMA153_tree = (CommonTree)adaptor.create(COMMA153);
            	    	    adaptor.addChild(root_0, COMMA153_tree);

            	    	    pushFollow(FOLLOW_expr_in_access2848);
            	    	    expr154=expr();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_0, expr154.getTree());
            	    	     m++; 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop45;
            	        }
            	    } while (true);

            	    RPAR_S155=(Token)match(input,RPAR_S,FOLLOW_RPAR_S_in_access2861); 
            	    RPAR_S155_tree = (CommonTree)adaptor.create(RPAR_S155);
            	    adaptor.addChild(root_0, RPAR_S155_tree);

            	     if (m == 1) {
            	              s += m; m = 0;
            	            }
            	          

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             listener.access((id151!=null?((Token)id151.start):null),s,m); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "access"

    public static class havoc_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "havoc"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:793:1: havoc : HAVOC LPAR (id1= IDN ( COMMA id2= IDN )* )? RPAR ;
    public final NTSParser.havoc_return havoc() throws RecognitionException {
        NTSParser.havoc_return retval = new NTSParser.havoc_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token id1=null;
        Token id2=null;
        Token HAVOC156=null;
        Token LPAR157=null;
        Token COMMA158=null;
        Token RPAR159=null;

        CommonTree id1_tree=null;
        CommonTree id2_tree=null;
        CommonTree HAVOC156_tree=null;
        CommonTree LPAR157_tree=null;
        CommonTree COMMA158_tree=null;
        CommonTree RPAR159_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:794:3: ( HAVOC LPAR (id1= IDN ( COMMA id2= IDN )* )? RPAR )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:794:5: HAVOC LPAR (id1= IDN ( COMMA id2= IDN )* )? RPAR
            {
            root_0 = (CommonTree)adaptor.nil();

            HAVOC156=(Token)match(input,HAVOC,FOLLOW_HAVOC_in_havoc2916); 
            HAVOC156_tree = (CommonTree)adaptor.create(HAVOC156);
            adaptor.addChild(root_0, HAVOC156_tree);

            LPAR157=(Token)match(input,LPAR,FOLLOW_LPAR_in_havoc2918); 
            LPAR157_tree = (CommonTree)adaptor.create(LPAR157);
            adaptor.addChild(root_0, LPAR157_tree);

             List<Token> l = new LinkedList<Token>(); 
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:797:5: (id1= IDN ( COMMA id2= IDN )* )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==IDN) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:797:6: id1= IDN ( COMMA id2= IDN )*
                    {
                    id1=(Token)match(input,IDN,FOLLOW_IDN_in_havoc2938); 
                    id1_tree = (CommonTree)adaptor.create(id1);
                    adaptor.addChild(root_0, id1_tree);

                     l.add(id1); 
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:798:7: ( COMMA id2= IDN )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==COMMA) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // /home/filip/workspace/nts/src/nts/parser/NTS.g:798:8: COMMA id2= IDN
                    	    {
                    	    COMMA158=(Token)match(input,COMMA,FOLLOW_COMMA_in_havoc2950); 
                    	    COMMA158_tree = (CommonTree)adaptor.create(COMMA158);
                    	    adaptor.addChild(root_0, COMMA158_tree);

                    	    id2=(Token)match(input,IDN,FOLLOW_IDN_in_havoc2954); 
                    	    id2_tree = (CommonTree)adaptor.create(id2);
                    	    adaptor.addChild(root_0, id2_tree);

                    	     l.add(id2); 

                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);


                    }
                    break;

            }

            RPAR159=(Token)match(input,RPAR,FOLLOW_RPAR_in_havoc2979); 
            RPAR159_tree = (CommonTree)adaptor.create(RPAR159);
            adaptor.addChild(root_0, RPAR159_tree);

             listener.havoc(HAVOC156, l); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "havoc"

    public static class id_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "id"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:806:1: id : ( IDN | IDP | TID );
    public final NTSParser.id_return id() throws RecognitionException {
        NTSParser.id_return retval = new NTSParser.id_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set160=null;

        CommonTree set160_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:807:3: ( IDN | IDP | TID )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set160=(Token)input.LT(1);
            if ( (input.LA(1)>=IDN && input.LA(1)<=IDP)||input.LA(1)==TID ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set160));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "id"

    public static class literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:811:1: literal : ( boollit | li= LITINT | lr= LITREAL );
    public final NTSParser.literal_return literal() throws RecognitionException {
        NTSParser.literal_return retval = new NTSParser.literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token li=null;
        Token lr=null;
        NTSParser.boollit_return boollit161 = null;


        CommonTree li_tree=null;
        CommonTree lr_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:812:3: ( boollit | li= LITINT | lr= LITREAL )
            int alt49=3;
            switch ( input.LA(1) ) {
            case TRUE:
            case FALSE:
                {
                alt49=1;
                }
                break;
            case LITINT:
                {
                alt49=2;
                }
                break;
            case LITREAL:
                {
                alt49=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:812:5: boollit
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_boollit_in_literal3027);
                    boollit161=boollit();

                    state._fsp--;

                    adaptor.addChild(root_0, boollit161.getTree());

                    }
                    break;
                case 2 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:813:5: li= LITINT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    li=(Token)match(input,LITINT,FOLLOW_LITINT_in_literal3035); 
                    li_tree = (CommonTree)adaptor.create(li);
                    adaptor.addChild(root_0, li_tree);

                     listener.litInt(li); 

                    }
                    break;
                case 3 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:814:5: lr= LITREAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    lr=(Token)match(input,LITREAL,FOLLOW_LITREAL_in_literal3045); 
                    lr_tree = (CommonTree)adaptor.create(lr);
                    adaptor.addChild(root_0, lr_tree);

                     listener.litReal(lr); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "literal"

    public static class boollit_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "boollit"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:816:1: boollit : ( TRUE | FALSE );
    public final NTSParser.boollit_return boollit() throws RecognitionException {
        NTSParser.boollit_return retval = new NTSParser.boollit_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TRUE162=null;
        Token FALSE163=null;

        CommonTree TRUE162_tree=null;
        CommonTree FALSE163_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:817:3: ( TRUE | FALSE )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==TRUE) ) {
                alt50=1;
            }
            else if ( (LA50_0==FALSE) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:817:5: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    TRUE162=(Token)match(input,TRUE,FOLLOW_TRUE_in_boollit3059); 
                    TRUE162_tree = (CommonTree)adaptor.create(TRUE162);
                    adaptor.addChild(root_0, TRUE162_tree);

                     listener.litTrue(TRUE162); 

                    }
                    break;
                case 2 :
                    // /home/filip/workspace/nts/src/nts/parser/NTS.g:818:5: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    FALSE163=(Token)match(input,FALSE,FOLLOW_FALSE_in_boollit3067); 
                    FALSE163_tree = (CommonTree)adaptor.create(FALSE163);
                    adaptor.addChild(root_0, FALSE163_tree);

                     listener.litFalse(FALSE163); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "boollit"

    public static class pm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pm"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:820:1: pm : ( PLUS | MINUS );
    public final NTSParser.pm_return pm() throws RecognitionException {
        NTSParser.pm_return retval = new NTSParser.pm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set164=null;

        CommonTree set164_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:821:3: ( PLUS | MINUS )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set164=(Token)input.LT(1);
            if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set164));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pm"

    public static class mdr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mdr"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:824:1: mdr : ( MULT | DIVIDE | REMAINDER );
    public final NTSParser.mdr_return mdr() throws RecognitionException {
        NTSParser.mdr_return retval = new NTSParser.mdr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set165=null;

        CommonTree set165_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:825:3: ( MULT | DIVIDE | REMAINDER )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set165=(Token)input.LT(1);
            if ( (input.LA(1)>=MULT && input.LA(1)<=REMAINDER) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set165));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mdr"

    public static class rop_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rop"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:829:1: rop : ( EQ | NEQ | LEQ | LT | GEQ | GT );
    public final NTSParser.rop_return rop() throws RecognitionException {
        NTSParser.rop_return retval = new NTSParser.rop_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set166=null;

        CommonTree set166_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:830:3: ( EQ | NEQ | LEQ | LT | GEQ | GT )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set166=(Token)input.LT(1);
            if ( (input.LA(1)>=EQ && input.LA(1)<=GT) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set166));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rop"

    public static class quantifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "quantifier"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:837:1: quantifier : ( EXISTS | FORALL );
    public final NTSParser.quantifier_return quantifier() throws RecognitionException {
        NTSParser.quantifier_return retval = new NTSParser.quantifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set167=null;

        CommonTree set167_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:838:3: ( EXISTS | FORALL )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set167=(Token)input.LT(1);
            if ( (input.LA(1)>=EXISTS && input.LA(1)<=FORALL) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set167));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "quantifier"

    public static class op_equiv_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "op_equiv"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:841:1: op_equiv : ( EQUIV | C_EQUIV );
    public final NTSParser.op_equiv_return op_equiv() throws RecognitionException {
        NTSParser.op_equiv_return retval = new NTSParser.op_equiv_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set168=null;

        CommonTree set168_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:842:3: ( EQUIV | C_EQUIV )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set168=(Token)input.LT(1);
            if ( input.LA(1)==EQUIV||input.LA(1)==C_EQUIV ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set168));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "op_equiv"

    public static class op_impl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "op_impl"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:844:1: op_impl : ( IMPL | C_IMPL );
    public final NTSParser.op_impl_return op_impl() throws RecognitionException {
        NTSParser.op_impl_return retval = new NTSParser.op_impl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set169=null;

        CommonTree set169_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:845:3: ( IMPL | C_IMPL )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set169=(Token)input.LT(1);
            if ( input.LA(1)==IMPL||input.LA(1)==C_IMPL ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set169));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "op_impl"

    public static class op_or_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "op_or"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:847:1: op_or : ( OR | C_OR );
    public final NTSParser.op_or_return op_or() throws RecognitionException {
        NTSParser.op_or_return retval = new NTSParser.op_or_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set170=null;

        CommonTree set170_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:848:3: ( OR | C_OR )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set170=(Token)input.LT(1);
            if ( input.LA(1)==OR||input.LA(1)==C_OR ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set170));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "op_or"

    public static class op_and_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "op_and"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:850:1: op_and : ( AND | C_AND );
    public final NTSParser.op_and_return op_and() throws RecognitionException {
        NTSParser.op_and_return retval = new NTSParser.op_and_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set171=null;

        CommonTree set171_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:851:3: ( AND | C_AND )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set171=(Token)input.LT(1);
            if ( input.LA(1)==AND||input.LA(1)==C_AND ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set171));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "op_and"

    public static class op_not_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "op_not"
    // /home/filip/workspace/nts/src/nts/parser/NTS.g:853:1: op_not : ( NOT | C_NOT );
    public final NTSParser.op_not_return op_not() throws RecognitionException {
        NTSParser.op_not_return retval = new NTSParser.op_not_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set172=null;

        CommonTree set172_tree=null;

        try {
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:854:3: ( NOT | C_NOT )
            // /home/filip/workspace/nts/src/nts/parser/NTS.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set172=(Token)input.LT(1);
            if ( input.LA(1)==NOT||input.LA(1)==C_NOT ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set172));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException ex) {
            reportError(ex);
            System.exit(1);
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end "op_not"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA46 dfa46 = new DFA46(this);
    static final String DFA1_eotS =
        "\16\uffff";
    static final String DFA1_eofS =
        "\1\1\15\uffff";
    static final String DFA1_minS =
        "\1\4\15\uffff";
    static final String DFA1_maxS =
        "\1\77\15\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\2\1\1\13\uffff";
    static final String DFA1_specialS =
        "\16\uffff}>";
    static final String[] DFA1_transitionS = {
            "\4\2\4\uffff\3\2\4\uffff\1\2\4\uffff\2\2\6\uffff\1\2\1\uffff"+
            "\1\2\3\uffff\1\2\1\uffff\1\2\25\uffff\2\2",
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
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "()+ loopback of 371:21: ( expr SEMICOLON )+";
        }
    }
    static final String DFA9_eotS =
        "\13\uffff";
    static final String DFA9_eofS =
        "\13\uffff";
    static final String DFA9_minS =
        "\1\4\12\uffff";
    static final String DFA9_maxS =
        "\1\102\12\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\10\uffff";
    static final String DFA9_specialS =
        "\13\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\4\uffff\1\2\1\1\37\uffff\1\2\15\uffff\6\2\2\uffff\1\2\1"+
            "\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "443:1: annotations : (a1= annotation ( annotation )* | );";
        }
    }
    static final String DFA8_eotS =
        "\13\uffff";
    static final String DFA8_eofS =
        "\13\uffff";
    static final String DFA8_minS =
        "\1\4\12\uffff";
    static final String DFA8_maxS =
        "\1\102\12\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\2\10\uffff\1\1";
    static final String DFA8_specialS =
        "\13\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\4\uffff\1\1\1\12\37\uffff\1\1\15\uffff\6\1\2\uffff\1\1"+
            "\1\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "()* loopback of 446:5: ( annotation )*";
        }
    }
    static final String DFA10_eotS =
        "\16\uffff";
    static final String DFA10_eofS =
        "\16\uffff";
    static final String DFA10_minS =
        "\1\4\15\uffff";
    static final String DFA10_maxS =
        "\1\105\15\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\13\uffff";
    static final String DFA10_specialS =
        "\16\uffff}>";
    static final String[] DFA10_transitionS = {
            "\4\2\4\uffff\3\2\4\uffff\1\2\4\uffff\2\2\6\uffff\1\2\1\uffff"+
            "\1\2\3\uffff\1\2\1\uffff\1\2\25\uffff\2\2\5\uffff\1\1",
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
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "455:1: annot_value[Token aKey, EAnnotType aT] : (s= litstring | e= expr );";
        }
    }
    static final String DFA11_eotS =
        "\14\uffff";
    static final String DFA11_eofS =
        "\14\uffff";
    static final String DFA11_minS =
        "\1\4\2\uffff\1\26\2\uffff\1\4\5\uffff";
    static final String DFA11_maxS =
        "\1\73\2\uffff\1\56\2\uffff\1\62\5\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\7\uffff";
    static final String DFA11_specialS =
        "\14\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\3\5\uffff\1\1\52\uffff\3\1\4\4",
            "",
            "",
            "\1\4\21\uffff\1\1\4\uffff\1\1\1\6",
            "",
            "",
            "\1\4\53\uffff\3\1",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "481:5: ( declar )?";
        }
    }
    static final String DFA18_eotS =
        "\17\uffff";
    static final String DFA18_eofS =
        "\17\uffff";
    static final String DFA18_minS =
        "\1\4\2\uffff\1\26\5\uffff\1\4\5\uffff";
    static final String DFA18_maxS =
        "\1\102\2\uffff\1\56\5\uffff\1\62\5\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\2\11\uffff\1\1\3\uffff";
    static final String DFA18_specialS =
        "\17\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\3\63\uffff\6\1\2\uffff\1\1\1\uffff\1\1",
            "",
            "",
            "\1\1\21\uffff\1\13\1\uffff\1\1\2\uffff\1\13\1\11",
            "",
            "",
            "",
            "",
            "",
            "\1\1\53\uffff\3\13",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "()+ loopback of 520:5: ( dline_annot modif_annot )+";
        }
    }
    static final String DFA19_eotS =
        "\12\uffff";
    static final String DFA19_eofS =
        "\12\uffff";
    static final String DFA19_minS =
        "\1\4\11\uffff";
    static final String DFA19_maxS =
        "\1\102\11\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\1\2\7\uffff";
    static final String DFA19_specialS =
        "\12\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\2\5\uffff\1\2\52\uffff\3\1\6\2\2\uffff\1\2\1\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "527:1: modifier : (t= ( PARAM | IN | OUT ) | );";
        }
    }
    static final String DFA22_eotS =
        "\16\uffff";
    static final String DFA22_eofS =
        "\16\uffff";
    static final String DFA22_minS =
        "\1\4\15\uffff";
    static final String DFA22_maxS =
        "\1\77\15\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA22_specialS =
        "\16\uffff}>";
    static final String[] DFA22_transitionS = {
            "\4\1\4\uffff\3\1\4\uffff\1\1\4\uffff\2\1\6\uffff\1\1\1\uffff"+
            "\1\1\3\uffff\1\1\1\uffff\1\1\1\15\24\uffff\2\1",
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
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "557:7: ( expr )?";
        }
    }
    static final String DFA28_eotS =
        "\105\uffff";
    static final String DFA28_eofS =
        "\105\uffff";
    static final String DFA28_minS =
        "\1\4\2\17\1\4\14\uffff\1\4\23\uffff\1\17\14\uffff\1\0\12\uffff\1"+
        "\0\10\uffff";
    static final String DFA28_maxS =
        "\1\77\2\53\1\77\14\uffff\1\77\23\uffff\1\55\14\uffff\1\0\12\uffff"+
        "\1\0\10\uffff";
    static final String DFA28_acceptS =
        "\4\uffff\1\2\12\uffff\1\3\12\uffff\1\1\52\uffff";
    static final String DFA28_specialS =
        "\61\uffff\1\0\12\uffff\1\1\10\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\2\1\1\2\4\4\uffff\3\4\4\uffff\1\4\4\uffff\2\4\6\uffff\1\4"+
            "\1\uffff\1\4\3\uffff\1\3\1\uffff\1\4\2\uffff\1\17\22\uffff\2"+
            "\4",
            "\4\4\1\uffff\4\4\2\uffff\1\20\5\4\1\uffff\5\4\2\uffff\1\4\2"+
            "\uffff\1\4",
            "\4\4\1\uffff\4\4\2\uffff\6\4\1\uffff\5\4\1\32\1\uffff\1\4\2"+
            "\uffff\1\4",
            "\1\4\1\44\2\4\4\uffff\3\4\4\uffff\1\4\4\uffff\2\4\6\uffff\1"+
            "\4\1\uffff\1\4\3\uffff\1\4\1\uffff\1\4\25\uffff\2\4",
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
            "\1\61\3\4\4\uffff\2\4\22\uffff\1\4\1\uffff\1\4\3\uffff\1\4"+
            "\1\uffff\1\4\26\uffff\1\4",
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
            "",
            "",
            "",
            "",
            "",
            "\4\4\1\uffff\4\4\2\uffff\6\4\1\uffff\5\4\1\uffff\1\74\1\4\4"+
            "\uffff\1\32",
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
            "\1\uffff",
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
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "605:1: label returns [ILabel rL] : ({...}? call_havoc | expr | );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_49 = input.LA(1);

                         
                        int index28_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isCall() )) ) {s = 26;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index28_49);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA28_60 = input.LA(1);

                         
                        int index28_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( isCall() )) ) {s = 26;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index28_60);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA31_eotS =
        "\16\uffff";
    static final String DFA31_eofS =
        "\16\uffff";
    static final String DFA31_minS =
        "\1\4\15\uffff";
    static final String DFA31_maxS =
        "\1\77\15\uffff";
    static final String DFA31_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA31_specialS =
        "\16\uffff}>";
    static final String[] DFA31_transitionS = {
            "\4\1\4\uffff\3\1\4\uffff\1\1\4\uffff\2\1\6\uffff\1\1\1\uffff"+
            "\1\1\3\uffff\1\1\1\15\1\1\25\uffff\2\1",
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
            ""
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "631:5: ( expr ( COMMA expr )* )?";
        }
    }
    static final String DFA36_eotS =
        "\12\uffff";
    static final String DFA36_eofS =
        "\12\uffff";
    static final String DFA36_minS =
        "\1\17\11\uffff";
    static final String DFA36_maxS =
        "\1\57\11\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA36_specialS =
        "\12\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\11\3\1\1\uffff\1\11\3\1\17\uffff\1\1\1\uffff\1\1\1\uffff"+
            "\1\1\1\uffff\1\1\1\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "()* loopback of 663:9: (op= op_and not )*";
        }
    }
    static final String DFA37_eotS =
        "\15\uffff";
    static final String DFA37_eofS =
        "\15\uffff";
    static final String DFA37_minS =
        "\1\4\14\uffff";
    static final String DFA37_maxS =
        "\1\77\14\uffff";
    static final String DFA37_acceptS =
        "\1\uffff\1\2\12\uffff\1\1";
    static final String DFA37_specialS =
        "\15\uffff}>";
    static final String[] DFA37_transitionS = {
            "\4\1\4\uffff\2\1\1\14\4\uffff\1\14\4\uffff\2\1\6\uffff\1\1\1"+
            "\uffff\1\1\3\uffff\1\1\1\uffff\1\1\25\uffff\2\1",
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
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "()* loopback of 667:5: (op= op_not )*";
        }
    }
    static final String DFA38_eotS =
        "\14\uffff";
    static final String DFA38_eofS =
        "\14\uffff";
    static final String DFA38_minS =
        "\1\4\13\uffff";
    static final String DFA38_maxS =
        "\1\77\13\uffff";
    static final String DFA38_acceptS =
        "\1\uffff\1\1\1\2\1\3\10\uffff";
    static final String DFA38_specialS =
        "\14\uffff}>";
    static final String[] DFA38_transitionS = {
            "\4\3\4\uffff\2\3\12\uffff\2\2\6\uffff\1\3\1\uffff\1\3\3\uffff"+
            "\1\3\1\uffff\1\3\25\uffff\1\1\1\3",
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
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "673:1: predicate : ( havoc | quant | pred_rop );";
        }
    }
    static final String DFA39_eotS =
        "\13\uffff";
    static final String DFA39_eofS =
        "\13\uffff";
    static final String DFA39_minS =
        "\1\17\12\uffff";
    static final String DFA39_maxS =
        "\1\57\12\uffff";
    static final String DFA39_acceptS =
        "\1\uffff\1\1\1\2\10\uffff";
    static final String DFA39_specialS =
        "\13\uffff}>";
    static final String[] DFA39_transitionS = {
            "\4\2\1\uffff\4\2\2\uffff\6\1\7\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\1\2\1\uffff\1\2\1\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "680:5: (op= rop plusminus )?";
        }
    }
    static final String DFA40_eotS =
        "\14\uffff";
    static final String DFA40_eofS =
        "\14\uffff";
    static final String DFA40_minS =
        "\1\17\13\uffff";
    static final String DFA40_maxS =
        "\1\57\13\uffff";
    static final String DFA40_acceptS =
        "\1\uffff\1\2\11\uffff\1\1";
    static final String DFA40_specialS =
        "\14\uffff}>";
    static final String[] DFA40_transitionS = {
            "\4\1\1\uffff\4\1\2\uffff\6\1\1\uffff\2\13\4\uffff\1\1\1\uffff"+
            "\1\1\1\uffff\1\1\1\uffff\1\1\1\uffff\1\1",
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
            ""
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "()* loopback of 709:5: (op= pm mult_div_rem )*";
        }
    }
    static final String DFA41_eotS =
        "\15\uffff";
    static final String DFA41_eofS =
        "\15\uffff";
    static final String DFA41_minS =
        "\1\17\14\uffff";
    static final String DFA41_maxS =
        "\1\57\14\uffff";
    static final String DFA41_acceptS =
        "\1\uffff\1\2\12\uffff\1\1";
    static final String DFA41_specialS =
        "\15\uffff}>";
    static final String[] DFA41_transitionS = {
            "\4\1\1\uffff\4\1\2\uffff\6\1\1\uffff\2\1\3\14\1\uffff\1\1\1"+
            "\uffff\1\1\1\uffff\1\1\1\uffff\1\1\1\uffff\1\1",
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
            ""
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "()* loopback of 721:5: (op= mdr un_plusminus )*";
        }
    }
    static final String DFA42_eotS =
        "\12\uffff";
    static final String DFA42_eofS =
        "\12\uffff";
    static final String DFA42_minS =
        "\1\4\11\uffff";
    static final String DFA42_maxS =
        "\1\77\11\uffff";
    static final String DFA42_acceptS =
        "\1\uffff\1\1\1\2\7\uffff";
    static final String DFA42_specialS =
        "\12\uffff}>";
    static final String[] DFA42_transitionS = {
            "\4\2\4\uffff\2\2\22\uffff\1\2\1\uffff\1\1\3\uffff\1\2\1\uffff"+
            "\1\2\26\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "733:5: (m= MINUS )?";
        }
    }
    static final String DFA46_eotS =
        "\17\uffff";
    static final String DFA46_eofS =
        "\17\uffff";
    static final String DFA46_minS =
        "\1\17\16\uffff";
    static final String DFA46_maxS =
        "\1\57\16\uffff";
    static final String DFA46_acceptS =
        "\1\uffff\1\2\14\uffff\1\1";
    static final String DFA46_specialS =
        "\17\uffff}>";
    static final String[] DFA46_transitionS = {
            "\4\1\1\uffff\4\1\2\uffff\14\1\1\uffff\1\1\1\16\1\1\1\uffff\1"+
            "\1\1\uffff\1\1\1\uffff\1\1",
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
            ""
    };

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "()* loopback of 769:5: ( LPAR_S e1= expr ( COMMA expr )* RPAR_S )*";
        }
    }
 

    public static final BitSet FOLLOW_nts_in_start717 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declar_in_start_expr732 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RELATION_in_start_expr734 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_expr_in_start_expr737 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_start_expr739 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_EOF_in_start_expr743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declar_in_start_sil756 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_SIL_CHECK_in_start_sil758 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_sil_query_in_start_sil760 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_expr_in_start_sil763 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_start_sil765 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start_sil768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIL_SAT_in_sil_query780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIL_VALID_in_sil_query788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotations_in_nts814 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NTS_in_nts825 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDN_in_nts827 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_nts829 = new BitSet(new long[]{0x00E0000000000400L});
    public static final BitSet FOLLOW_modif_annot_in_nts869 = new BitSet(new long[]{0x3000000000000010L});
    public static final BitSet FOLLOW_declar_m_a_in_nts887 = new BitSet(new long[]{0x3000000000000010L});
    public static final BitSet FOLLOW_precondition_in_nts932 = new BitSet(new long[]{0x3000000000000410L});
    public static final BitSet FOLLOW_annotations_in_nts947 = new BitSet(new long[]{0x3000000000000010L});
    public static final BitSet FOLLOW_instances_in_nts980 = new BitSet(new long[]{0x3000000000000410L});
    public static final BitSet FOLLOW_annotations_in_nts995 = new BitSet(new long[]{0x3000000000000010L});
    public static final BitSet FOLLOW_subsystem_annot_in_nts1018 = new BitSet(new long[]{0x3000000000000412L});
    public static final BitSet FOLLOW_subsystem_in_nts1022 = new BitSet(new long[]{0x3000000000000412L});
    public static final BitSet FOLLOW_PRECONDITION_in_precondition1048 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_expr_in_precondition1050 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_precondition1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSTANCES_in_instances1067 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_inst_in_instances1069 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_COMMA_in_instances1072 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_inst_in_instances1074 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_instances1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDN_in_inst1092 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LPAR_S_in_inst1094 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_expr_in_inst1098 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RPAR_S_in_inst1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_annotations1133 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_annotation_in_annotations1143 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_AT_in_annotation1165 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDN_in_annotation1169 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_COLON_in_annotation1171 = new BitSet(new long[]{0x001F000000000000L});
    public static final BitSet FOLLOW_annot_type_in_annotation1179 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_COLON_in_annotation1181 = new BitSet(new long[]{0xC0000145030870F0L,0x0000000000000020L});
    public static final BitSet FOLLOW_annot_value_in_annotation1188 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_annotation1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_litstring_in_annot_value1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_annot_value1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_annot_type1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITSTRING_in_litstring1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotations_in_subsystem1300 = new BitSet(new long[]{0x3000000000000010L});
    public static final BitSet FOLLOW_subsystem_annot_in_subsystem1302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDN_in_subsystem_annot1314 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_LPAR_C_in_subsystem_annot1316 = new BitSet(new long[]{0x0FE0000000000410L});
    public static final BitSet FOLLOW_declar_in_subsystem_annot1334 = new BitSet(new long[]{0x0FE0000000000410L});
    public static final BitSet FOLLOW_marking_in_subsystem_annot1348 = new BitSet(new long[]{0x0FE0000000000410L});
    public static final BitSet FOLLOW_transition_in_subsystem_annot1355 = new BitSet(new long[]{0x0FE0080000000410L});
    public static final BitSet FOLLOW_RPAR_C_in_subsystem_annot1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATES_in_marking1380 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_annotations_in_marking1388 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDN_in_marking1392 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_COMMA_in_marking1404 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_annotations_in_marking1406 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDN_in_marking1410 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_marking1429 = new BitSet(new long[]{0x0E00000000000000L});
    public static final BitSet FOLLOW_set_in_marking1457 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDN_in_marking1494 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_COMMA_in_marking1506 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDN_in_marking1510 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_marking1539 = new BitSet(new long[]{0x0E00000000000002L});
    public static final BitSet FOLLOW_modif_annot_in_declar1566 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_declar_m_a_in_declar1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dline_annot_in_declar_m_a1583 = new BitSet(new long[]{0x00E0000000000400L});
    public static final BitSet FOLLOW_modif_annot_in_declar_m_a1585 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_modifier_in_modif_annot1601 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_annotations_in_modif_annot1603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_modifier1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dblock_annot_in_dline_annot1649 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_COMMA_in_dline_annot1653 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_dblock_in_dline_annot1655 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_dline_annot1660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotations_in_dblock1673 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_dblock_annot_in_dblock1675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dvar_annot_in_dblock_annot1688 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_COMMA_in_dblock_annot1691 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_dvar_in_dblock_annot1693 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_COLON_in_dblock_annot1698 = new BitSet(new long[]{0x0007000000000000L});
    public static final BitSet FOLLOW_basic_type_in_dblock_annot1700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotations_in_dvar1719 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_dvar_annot_in_dvar1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDN_in_dvar_annot1742 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_LPAR_S_in_dvar_annot1750 = new BitSet(new long[]{0xC0000345030870F0L});
    public static final BitSet FOLLOW_expr_in_dvar_annot1769 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RPAR_S_in_dvar_annot1806 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_set_in_basic_type1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qd_block_in_qdecl1868 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_COMMA_in_qdecl1872 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_qd_block_in_qdecl1874 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_DOT_in_qdecl1879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDN_in_qd_block1894 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_COMMA_in_qd_block1905 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDN_in_qd_block1909 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_COLON_in_qd_block1921 = new BitSet(new long[]{0x0007000000000000L});
    public static final BitSet FOLLOW_qd_type_in_qd_block1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_basic_type_in_qd_type1938 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_LPAR_S_in_qd_type1946 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_expr_in_qd_type1948 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COMMA_in_qd_type1950 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_expr_in_qd_type1952 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RPAR_S_in_qd_type1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDN_in_transition1984 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_COLON_in_transition1986 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDN_in_transition1993 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_C_IMPL_in_transition1995 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDN_in_transition1999 = new BitSet(new long[]{0x0000040000000400L});
    public static final BitSet FOLLOW_annotations_in_transition2003 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_LPAR_C_in_transition2005 = new BitSet(new long[]{0xC0000945030870F0L});
    public static final BitSet FOLLOW_label_in_transition2009 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAR_C_in_transition2011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_havoc_in_label2035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_label2043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_in_call_havoc2074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ret_idp_in_call2101 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_EQ_in_call2107 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_call2_in_call2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call2_in_call2116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_call2123 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_retlist_in_call2125 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RPAR_in_call2127 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_EQ_in_call2129 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_call2_in_call2131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDN_in_call22145 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_LPAR_in_call22153 = new BitSet(new long[]{0xC00001C5030870F0L});
    public static final BitSet FOLLOW_expr_in_call22161 = new BitSet(new long[]{0x0000208000000000L});
    public static final BitSet FOLLOW_COMMA_in_call22174 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_expr_in_call22176 = new BitSet(new long[]{0x0000208000000000L});
    public static final BitSet FOLLOW_RPAR_in_call22198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ret_idp_in_retlist2210 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_COMMA_in_retlist2214 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ret_idp_in_retlist2216 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_IDP_in_ret_idp2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equiv_in_expr2255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_impl_in_equiv2267 = new BitSet(new long[]{0x0000000000840002L});
    public static final BitSet FOLLOW_op_equiv_in_equiv2273 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_impl_in_equiv2275 = new BitSet(new long[]{0x0000000000840002L});
    public static final BitSet FOLLOW_or_in_impl2292 = new BitSet(new long[]{0x0000000000420002L});
    public static final BitSet FOLLOW_op_impl_in_impl2298 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_or_in_impl2300 = new BitSet(new long[]{0x0000000000420002L});
    public static final BitSet FOLLOW_and_in_or2317 = new BitSet(new long[]{0x0000000000210002L});
    public static final BitSet FOLLOW_op_or_in_or2323 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_and_in_or2325 = new BitSet(new long[]{0x0000000000210002L});
    public static final BitSet FOLLOW_not_in_and2342 = new BitSet(new long[]{0x0000000000108002L});
    public static final BitSet FOLLOW_op_and_in_and2348 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_not_in_and2350 = new BitSet(new long[]{0x0000000000108002L});
    public static final BitSet FOLLOW_op_not_in_not2376 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_predicate_in_not2383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_havoc_in_predicate2402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_quant_in_predicate2408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pred_rop_in_predicate2415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plusminus_in_pred_rop2427 = new BitSet(new long[]{0x00000000FC000002L});
    public static final BitSet FOLLOW_rop_in_pred_rop2437 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_plusminus_in_pred_rop2439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_quantifier_in_quant2470 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_qdecl_in_quant2487 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_predicate_in_quant2497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mult_div_rem_in_plusminus2520 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_pm_in_plusminus2531 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_mult_div_rem_in_plusminus2533 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_un_plusminus_in_mult_div_rem2561 = new BitSet(new long[]{0x0000003800000002L});
    public static final BitSet FOLLOW_mdr_in_mult_div_rem2572 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_un_plusminus_in_mult_div_rem2574 = new BitSet(new long[]{0x0000003800000002L});
    public static final BitSet FOLLOW_MINUS_in_un_plusminus2605 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_atom_in_un_plusminus2609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_access_in_atom2627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_atom2633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_many_expr_in_atom2639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrsize_in_atom2645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_atom2651 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_expr_in_atom2653 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RPAR_in_atom2655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_S_in_many_expr2675 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_expr_in_many_expr2685 = new BitSet(new long[]{0x0000220000000000L});
    public static final BitSet FOLLOW_COMMA_in_many_expr2697 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_expr_in_many_expr2701 = new BitSet(new long[]{0x0000220000000000L});
    public static final BitSet FOLLOW_RPAR_S_in_many_expr2712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VBAR_in_arrsize2738 = new BitSet(new long[]{0x8000000000000030L});
    public static final BitSet FOLLOW_access_in_arrsize2747 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_VBAR_in_arrsize2749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_access2771 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_LPAR_S_in_access2830 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_expr_in_access2834 = new BitSet(new long[]{0x0000220000000000L});
    public static final BitSet FOLLOW_COMMA_in_access2846 = new BitSet(new long[]{0xC0000145030870F0L});
    public static final BitSet FOLLOW_expr_in_access2848 = new BitSet(new long[]{0x0000220000000000L});
    public static final BitSet FOLLOW_RPAR_S_in_access2861 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_HAVOC_in_havoc2916 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_LPAR_in_havoc2918 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_IDN_in_havoc2938 = new BitSet(new long[]{0x0000208000000000L});
    public static final BitSet FOLLOW_COMMA_in_havoc2950 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDN_in_havoc2954 = new BitSet(new long[]{0x0000208000000000L});
    public static final BitSet FOLLOW_RPAR_in_havoc2979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_id0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boollit_in_literal3027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITINT_in_literal3035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITREAL_in_literal3045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_boollit3059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_boollit3067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_pm0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_mdr0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_rop0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_quantifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_op_equiv0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_op_impl0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_op_or0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_op_and0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_op_not0 = new BitSet(new long[]{0x0000000000000002L});

}