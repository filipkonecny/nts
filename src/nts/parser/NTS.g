grammar NTS;
options {
  superClass = MBaseParser;
  output = AST;
  ASTLabelType = CommonTree;
  k=3;
}

//////////////////////////////////////////////////
///////////////// tokens /////////////////////////
//////////////////////////////////////////////////
tokens {
  IDN;
  IDP;
  LITINT;
  LITREAL;
  CALL;

  NTS = 'nts';
  AT = '@';
  QUOTE = '"';

  // boolean constants
  TRUE = 'true';
  FALSE = 'false';

  // logical connectives
  NOT = 'not';
  AND = 'and';
  OR = 'or';
  IMPL = 'imply';
  EQUIV = 'equiv';
  
  // C-like logical connectives
  C_NOT = '!';
  C_AND = '&&';
  C_OR = '||';
  C_IMPL = '->';
  C_EQUIV = '<->';

  // quantifiers
  EXISTS = 'exists';
  FORALL = 'forall';

  // predicates
  EQ = '=';
  NEQ = '!=';
  LEQ = '<=';
  LT = '<';
  GEQ = '>=';
  GT = '>';
  
  // array-size operator
  VBAR = '|';

  // arithmetic operators
  PLUS = '+';
  MINUS = '-';
  MULT = '*';
  DIVIDE = '/';
  REMAINDER = '%';

  LPAR = '(';
  RPAR = ')';
  LPAR_S = '[';
  RPAR_S = ']';
  LPAR_C = '{';
  RPAR_C = '}';

  DOT = '.';
  COMMA = ',';
  COLON = ':';
  SEMICOLON = ';';

  TBOOL = 'bool';
  TINT = 'int';
  TREAL = 'real';
  TSTRING = 'string';
  TFORMULA = 'formula';

  PARAM = 'par';
  IN = 'in';
  OUT = 'out';

  STATES = 'states';
  INITIAL = 'initial';
  FINAL = 'final';
  ERROR = 'error';

  PRECONDITION = 'init';
  
  INSTANCES = 'instances';
  
  HAVOC = 'havoc';
  
  TID = 'tid';
  
  RELATION = 'relation';
  
  ARR_LENGTH;
  
  SIL_CHECK = 'check';
  SIL_SAT = 'sat';
  SIL_VALID = 'valid';
}



//////////////////////////////////////////////////
///////////////// headers ////////////////////////
//////////////////////////////////////////////////

@header {
package nts.parser;

import nts.interf.base.*;
import java.util.LinkedList;
}
@lexer::header {
package nts.parser;
}

//////////////////////////////////////////////////
///////////////// members ////////////////////////
//////////////////////////////////////////////////

@members {

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
  
}

@rulecatch {
  catch (RecognitionException ex) {
    reportError(ex);
    System.exit(1);
  }
}

//////////////////////////////////////////////////
///////////////// start //////////////////////////
//////////////////////////////////////////////////


start
  : nts EOF
  ;

start_expr
  : declar RELATION (expr SEMICOLON)+ EOF
  ;

start_sil
  : declar SIL_CHECK sil_query (expr SEMICOLON) EOF
  ;
sil_query
  : SIL_SAT { ((IParserListenerSIL)listener).sil_check_sat(); }
  | SIL_VALID { ((IParserListenerSIL)listener).sil_check_valid(); }
  ;


//////////////////////////////////////////////////
////////////////// NTS ///////////////////////////
//////////////////////////////////////////////////


nts
  : 
    annotations
    
    NTS IDN SEMICOLON { listener.ntsInit($IDN); }
    
    // not obligatory: global declaration, precondition, instances
    
    // avoid grammatical ambiguity (annotation may belong to either variable or to a subsystem): 
    // pass first annotation to declaration and retrieve the last annotation from declaration
    
    ma=modif_annot
    
    // parse declaration
    ( declar_m_a )?
    // one annotation is pre-parsed
    
    { listener.checkNoModifier(); }
    
    // parse preconditon
    ( { listener.checkNoAnnotation(); }
      precondition
      // keep one annotation is pre-parsed
      annotations
    )?
    
    // parse number of subsystems' instances
    ( { listener.checkNoAnnotation(); }
      instances
      // keep one annotation is pre-parsed
      annotations
    )?
    
    // at least one subsystem
    subsystem_annot ( subsystem )*
    
    { listener.ntsFinalize(); }
  ;
precondition
  : PRECONDITION expr SEMICOLON { listener.precondition(); } 
  ;
instances
  : INSTANCES inst (COMMA inst)* SEMICOLON
  ;
inst
  : ii=IDN LPAR_S ee=expr RPAR_S
    { listener.instance($ii); }
  ;


//////////////////////////////////////////////////
/////////////// annotations //////////////////////
//////////////////////////////////////////////////

// return null if no annotation
annotations
  : { listener.setAnnotations(new Annotations()); }
    a1=annotation { listener.setAnnotFirstTok($a1.start); }
    ( annotation )*
  | { listener.setAnnotations(null); } // reset annotation in listener when no annotation present
  ;
annotation
  : AT k=IDN COLON
    t=annot_type COLON 
    annot_value[$k, $t.rT] SEMICOLON
  ;
// TODO type-check all formulae, literals are processed immediately
annot_value [Token aKey, EAnnotType aT]
  : s=litstring { listener.addAnnotString($aKey, $aT, $s.rS); }
  | e=expr { listener.addAnnotIntRealBoolFormula($aKey, $aT); }
  ;
annot_type returns [EAnnotType rT]
  : t=(TINT | TREAL | TBOOL | TSTRING | TFORMULA) { $rT = token2annotType($t); }
  ;
litstring returns [String rS]
  : l=LITSTRING 
    { 
      $rS = $l.getText();
      $rS = $rS.substring(1,$rS.length()-2);
    }
  ;

//////////////////////////////////////////////////
//////////////// subsystem ///////////////////////
//////////////////////////////////////////////////

subsystem
  : annotations subsystem_annot
  ;
subsystem_annot
  : IDN LPAR_C 
    { listener.subsystemInit($IDN); }
    
    declar?
    
    ( marking )? ( transition )+ RPAR_C
    { listener.subsystemFinalize(); }
  ;
marking
  : ( STATES
      annotations i1=IDN { listener.stateDeclaration($i1); }
      ( COMMA annotations i2=IDN { listener.stateDeclaration($i2); }
      )*
      SEMICOLON
    )?
    
    (
      m=(INITIAL | FINAL | ERROR ) 
      { EMarkType mt = token2markType(m);
        listener.checkInitFinErrRedeclaration(mt,m);
      }
      
      i1=IDN { listener.markAdd(mt, $i1); } 
      (COMMA i2=IDN { listener.markAdd(mt, $i2); } 
      )*
      
      semi=SEMICOLON
    )+
  ;

//////////////////////////////////////////////////
////////////// declaration ///////////////////////
//////////////////////////////////////////////////

// in order to resolve grammatical ambiguity, declaration block parses "modifier annotation" in the end

// declaration
declar
  : modif_annot declar_m_a
  ;
// declaration (with first modifier and annotation pre-parsed)
declar_m_a
  : ( dline_annot modif_annot )+
  ;
// modifier annotation sequence (potentially empty)
modif_annot
  : modifier annotations
  ;
// modifier
modifier
  : t=(PARAM | IN | OUT) { listener.setModifier($t, token2modifier($t)); }
  | { listener.setModifierNo(); }
  ;
// sequence of declaration blocks ended with semicolon (with first modifier and annotation pre-parsed)
dline_annot
  : dblock_annot ( COMMA dblock )* SEMICOLON
  ;
// declaration block, e.g. x,y[] : int
dblock
  : annotations dblock_annot
  ;
// declaration block, e.g. x,y[] : int (with first modifier and annotation pre-parsed)
dblock_annot
  : dvar_annot (COMMA dvar )* COLON basic_type
    { listener.declarationSetBasicType($basic_type.rT); }
  ;
// variable declaration
dvar
  : annotations dvar_annot
  ;
// variable declaration (with pre-parsed annotation)
dvar_annot
  : { int s=0; // 0=(basic type), 1=(pure array reference), 2=(not pure array reference);  0-initial, 0->1, 0->2 OK 
      int x=0; // total dimension
      int y=0; // own dimension
    }
    name=IDN
    ( LPAR_S 
      { x++; }
      ( expr 
        { if (s==1) {
            System.err.println("Syntax error at "+Common.at($name)+". Reference to array of specific sizes is not a valid type.");
            System.exit(1);
          }
          if (s==0) s=2;
          y++;
        }
      )?
      { if (s==0) s=1; } 
      RPAR_S
    )*
    { listener.declarationAdd($name,y,x); }
  ;

basic_type returns [EBasicType rT]
  : t=(TBOOL | TINT | TREAL) { $rT = token2basicType($t); }
  ;


//////////////////////////////////////////////////
//////// quantifier's declaration ////////////////
//////////////////////////////////////////////////

qdecl
  : qd_block ( COMMA qd_block )* DOT
  ;

qd_block
  : id1=IDN { listener.declarationQ($id1); } 
    ( COMMA id2=IDN { listener.declarationQ($id2); }  )*
    COLON qd_type
  ;
// e.g. int[0,100]
qd_type
  : b=basic_type
    ( LPAR_S expr COMMA expr RPAR_S )?
    { listener.declarationQ($b.rT, $LPAR_S); }
  ;

//////////////////////////////////////////////////
////////////// transition ////////////////////////
//////////////////////////////////////////////////

transition
  : ( id0=IDN COLON )? id1=IDN C_IMPL id2=IDN a=annotations LPAR_C l=label RPAR_C
    { listener.transition($id0,$id1,$id2,$l.rL); }
  ;
label returns [ILabel rL]
  : { isCall() }? call_havoc { $rL = listener.labelCall(); }
  | expr { $rL = listener.labelExpr(); }
  | { $rL = listener.labelDummyTrue(dummyTrue()); }
  ;

//////////////////////////////////////////////////
////////////////// call //////////////////////////
//////////////////////////////////////////////////

call_havoc
  : { listener.callInit(); }
    call
    //(op_and havoc
    //  { listener.callHavoc(); }
    //)?
  ;
call
  : ret_idp
    EQ call2[ECallArg.ACT]
  | call2[ECallArg.ACTRET]
  | LPAR retlist RPAR EQ call2[ECallArg.ACT]
  ;
call2[ECallArg code]
  : IDN { listener.callSetCallee($IDN); }
    LPAR
    ( expr { listener.callAddArgRet($code); } 
      ( COMMA expr { listener.callAddArgRet($code); } 
      )* 
    )? RPAR
  ;
retlist
  : ret_idp ( COMMA ret_idp )*
  ;
ret_idp
  : IDP 
    { listener.access($IDP,0,0);
      listener.callAddArgRet(ECallArg.RET);
    }
  ;

//////////////////////////////////////////////////
/////////////// expression ///////////////////////
//////////////////////////////////////////////////

expr
  : equiv
  ;
equiv
  : impl ( op=op_equiv impl { listener.equiv($op.start); } )*
  ;
impl
  : or ( op=op_impl or { listener.impl($op.start); } )*
  ;
or
  : and ( op=op_or and { listener.or($op.start); } )*
  ;
and
  : not ( op=op_and not { listener.and($op.start); } )*
  ;
not
  : { int n = 0; }
    (op=op_not {n++;} )* predicate
    { if ((n\%2 == 1))
         listener.not($op.start);
    }
  ;

predicate
  : havoc
  | quant 
  | pred_rop
  ;
pred_rop
  : plusminus
    ( op=rop plusminus
      { Token tok = $op.start;
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
    )?
  ;

quant
  : qq=quantifier
    { Token tok = $qq.start;
      int tt = tok.getType();
      listener.quantifierInit(tok, (tt == EXISTS));
    }
    
    qdecl    
    predicate
    
    { listener.quantifierFinalize(); }
  ;
plusminus
  : mult_div_rem 
    ( op=pm mult_div_rem 
      { Token tok = $op.start;
        switch(tok.getType()) {
          case PLUS: listener.plus(tok); break;
          case MINUS: listener.minus(tok); break;
          default: throw new RuntimeException("internal error");
        }
      }
    )*
  ;
mult_div_rem
  : un_plusminus 
    ( op=mdr un_plusminus
      { Token tok = $op.start;
        switch(tok.getType()) {
          case MULT: listener.mult(tok); break;
          case DIVIDE: listener.divide(tok); break;
          case REMAINDER: listener.remainder(tok); break;
          default: throw new RuntimeException("internal error");
        }
      } 
    )*
  ;
un_plusminus
  : (m=MINUS)? atom
    { if (m != null) listener.unaryMinus($m); }
  ;
atom
  : access
  | literal
  | many_expr
  | arrsize
  | LPAR expr RPAR
  ;

// list of expressions enclosed in square brackets
many_expr
  : { int n = 0; }
    LPAR_S
      e1=expr { n++; }
      ( COMMA e2=expr { n++; } )*
    RPAR_S
    
    { listener.exprList($LPAR_S,n); }
  ;

arrsize
  : v1=VBAR { $v1.setType(ARR_LENGTH); } 
    access VBAR
    { listener.arraySize($v1); }
  ;

// creates basic access for e.g. x or x', or
// indexed access for e.g. a[1] or a'[2][N]), or 
// muptiple indexed access for e.g. a'[N][0,1] (ONLY primed array variables) 
access
  : id
    
    { int m = 0, s = 0; }
    
    (
      // prevent e.g. a'[1][2,3][1]
      { if (m != 0) {
          System.err.println("Syntax error near "+Common.at($e1.start)+": multi-access cannot be followed by another access.");
          System.exit(1);
        }
      }
      
      // add to multi
      LPAR_S e1=expr { m++; }
      ( COMMA expr { m++; } )*
      RPAR_S
      
      // if >1 new indices, keep them in multi, else move them to single
      { if (m == 1) {
          s += m; m = 0;
        }
      } 
    )*
    
    { listener.access($id.start,s,m); }
  ;

// e.g.: havoc(), havoc(x,y,a)
havoc
  : HAVOC LPAR
    { List<Token> l = new LinkedList<Token>(); }
    
    (id1=IDN  { l.add($id1); }
      (COMMA id2=IDN { l.add($id2); }
      )*
    )? 
    RPAR
    
    { listener.havoc($HAVOC, l); }
  ;

id
  : IDN
  | IDP
  | TID
  ;
literal
  : boollit
  | li=LITINT { listener.litInt($li); }
  | lr=LITREAL { listener.litReal($lr); }
  ;
boollit
  : TRUE { listener.litTrue($TRUE); }
  | FALSE { listener.litFalse($FALSE); }
  ;
pm
  : PLUS
  | MINUS
  ;
mdr
  : MULT
  | DIVIDE
  | REMAINDER
  ;
rop
  : EQ
  | NEQ
  | LEQ
  | LT
  | GEQ
  | GT
  ;
quantifier
  : EXISTS
  | FORALL
  ;
op_equiv
  : EQUIV | C_EQUIV
  ;
op_impl
  : IMPL | C_IMPL
  ;
op_or
  : OR | C_OR
  ;
op_and
  : AND | C_AND
  ;
op_not
  : NOT | C_NOT
  ;

//////////////////////////////////////////////////
////////////////// tokens ////////////////////////
//////////////////////////////////////////////////

WS
  : ( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; }
  ;
SINGLE_COMMENT
  : '//' (~('\r' | '\n'))* { skip(); }
  ;
ML_COMMENT
  : '/*' ( options {greedy=false;} : . )* '*/' { skip(); }
  ;
IDP
  : IDN '\''
  ;
IDN
  : ('a'..'z' |'A'..'Z' |'_' ) ('a'..'z' |'A'..'Z' |'_' |'0'..'9' )*
  ;
LITREAL
  : LITINT DOT LITINT
  ;
LITINT
  : ('0'..'9')+
  ;
LITSTRING
  : QUOTE ( options {greedy=false;} :  ~('\r' | '\n'))* QUOTE
  ;
  