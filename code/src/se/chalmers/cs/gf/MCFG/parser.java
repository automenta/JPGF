
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Thu Nov 23 22:36:23 CET 2006
//----------------------------------------------------

package se.chalmers.cs.gf.MCFG;


/** CUP v0.11a beta 20060608 generated parser.
  * @version Thu Nov 23 22:36:23 CET 2006
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\034\000\002\002\004\000\002\002\003\000\002\003" +
    "\012\000\002\004\002\000\002\004\004\000\002\005\004" +
    "\000\002\006\002\000\002\006\005\000\002\007\014\000" +
    "\002\010\002\000\002\010\005\000\002\011\005\000\002" +
    "\012\002\000\002\012\003\000\002\012\005\000\002\013" +
    "\003\000\002\013\003\000\002\014\005\000\002\015\002" +
    "\000\002\015\003\000\002\015\005\000\002\016\003\000" +
    "\002\016\007\000\002\017\002\000\002\017\004\000\002" +
    "\020\003\000\002\021\002\000\002\021\004" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\064\000\006\002\ufffe\021\ufffe\001\002\000\004\002" +
    "\066\001\002\000\006\002\000\021\006\001\002\000\004" +
    "\025\010\001\002\000\006\002\ufffd\021\ufffd\001\002\000" +
    "\004\004\011\001\002\000\010\020\ufffb\022\ufffb\025\ufffb" +
    "\001\002\000\010\020\ufff8\022\013\025\ufff8\001\002\000" +
    "\004\026\036\001\002\000\004\004\064\001\002\000\006" +
    "\020\020\025\016\001\002\000\004\012\025\001\002\000" +
    "\004\004\023\001\002\000\004\021\021\001\002\000\004" +
    "\004\022\001\002\000\006\002\uffff\021\uffff\001\002\000" +
    "\006\020\ufff7\025\ufff7\001\002\000\004\005\035\001\002" +
    "\000\010\013\ufff5\015\030\024\027\001\002\000\004\013" +
    "\034\001\002\000\006\013\ufff2\014\ufff2\001\002\000\006" +
    "\013\ufff1\014\ufff1\001\002\000\006\013\ufff4\014\032\001" +
    "\002\000\010\013\ufff5\015\030\024\027\001\002\000\004" +
    "\013\ufff3\001\002\000\004\005\ufff6\001\002\000\004\026" +
    "\036\001\002\000\014\004\uffe8\006\uffe8\007\uffe8\017\uffe8" +
    "\026\uffe8\001\002\000\004\006\040\001\002\000\006\007" +
    "\uffe7\026\uffe7\001\002\000\006\007\042\026\036\001\002" +
    "\000\004\010\044\001\002\000\006\007\uffe6\026\uffe6\001" +
    "\002\000\006\011\uffef\025\047\001\002\000\004\011\063" +
    "\001\002\000\006\004\061\011\uffee\001\002\000\004\016" +
    "\050\001\002\000\012\004\uffea\011\uffea\023\uffea\026\uffea" +
    "\001\002\000\012\004\ufff0\011\ufff0\023\052\026\036\001" +
    "\002\000\012\004\uffec\011\uffec\023\uffec\026\uffec\001\002" +
    "\000\004\017\055\001\002\000\012\004\uffe9\011\uffe9\023" +
    "\uffe9\026\uffe9\001\002\000\004\024\056\001\002\000\004" +
    "\005\057\001\002\000\004\025\060\001\002\000\012\004" +
    "\uffeb\011\uffeb\023\uffeb\026\uffeb\001\002\000\006\011\uffef" +
    "\025\047\001\002\000\004\011\uffed\001\002\000\004\004" +
    "\ufff9\001\002\000\010\020\ufffa\022\ufffa\025\ufffa\001\002" +
    "\000\004\004\ufffc\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\064\000\006\002\003\004\004\001\001\000\002\001" +
    "\001\000\004\003\006\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\006\011\001\001\000" +
    "\006\005\013\010\014\001\001\000\004\020\064\001\001" +
    "\000\002\001\001\000\004\007\016\001\001\000\004\011" +
    "\023\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\012\025\013\030\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\012\032\013\030\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\020\036\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\021\040\001\001\000\004\020\042" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\014" +
    "\045\015\044\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\017\050\001\001\000\006\016" +
    "\053\020\052\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\006\014\045\015\061" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



  public se.chalmers.cs.gf.MCFG.Absyn.MCFGM pMCFGM() throws Exception
  {
	java_cup.runtime.Symbol res = parse();
	return (se.chalmers.cs.gf.MCFG.Absyn.MCFGM) res.value;
  }

public <B,A extends java.util.LinkedList<? super B>> A cons_(B x, A xs) { xs.addFirst(x); return xs; }

public void syntax_error(java_cup.runtime.Symbol cur_token)
{
	report_error("Syntax Error, trying to recover and continue parse...", cur_token);
}

public void unrecovered_syntax_error(java_cup.runtime.Symbol cur_token) throws java.lang.Exception
{
	throw new Exception("Unrecoverable Syntax Error");
}


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // ListCat ::= ListCat Cat 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListCat RESULT =null;
		se.chalmers.cs.gf.MCFG.Absyn.ListCat p_1 = (se.chalmers.cs.gf.MCFG.Absyn.ListCat)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		se.chalmers.cs.gf.MCFG.Absyn.Cat p_2 = (se.chalmers.cs.gf.MCFG.Absyn.Cat)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = p_1; p_1.addLast(p_2); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListCat",15, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // ListCat ::= 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListCat RESULT =null;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.ListCat(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListCat",15, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // Cat ::= SingleQuoteString 
            {
              se.chalmers.cs.gf.MCFG.Absyn.Cat RESULT =null;
		String p_1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.Cat(p_1); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Cat",14, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // ListSym ::= ListSym Sym 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListSym RESULT =null;
		se.chalmers.cs.gf.MCFG.Absyn.ListSym p_1 = (se.chalmers.cs.gf.MCFG.Absyn.ListSym)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		se.chalmers.cs.gf.MCFG.Absyn.Sym p_2 = (se.chalmers.cs.gf.MCFG.Absyn.Sym)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = p_1; p_1.addLast(p_2); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListSym",13, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // ListSym ::= 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListSym RESULT =null;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.ListSym(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListSym",13, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // Sym ::= Cat _SYMB_11 _INTEGER_ _SYMB_1 _IDENT_ 
            {
              se.chalmers.cs.gf.MCFG.Absyn.Sym RESULT =null;
		se.chalmers.cs.gf.MCFG.Absyn.Cat p_1 = (se.chalmers.cs.gf.MCFG.Absyn.Cat)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		Integer p_3 = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		String p_5 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.Proj(p_1,p_3,p_5); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Sym",12, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // Sym ::= _STRING_ 
            {
              se.chalmers.cs.gf.MCFG.Absyn.Sym RESULT =null;
		String p_1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.Term(p_1); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Sym",12, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // ListField ::= Field _SYMB_0 ListField 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListField RESULT =null;
		se.chalmers.cs.gf.MCFG.Absyn.Field p_1 = (se.chalmers.cs.gf.MCFG.Absyn.Field)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		se.chalmers.cs.gf.MCFG.Absyn.ListField p_3 = (se.chalmers.cs.gf.MCFG.Absyn.ListField)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = p_3; p_3.addFirst(p_1); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListField",11, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // ListField ::= Field 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListField RESULT =null;
		se.chalmers.cs.gf.MCFG.Absyn.Field p_1 = (se.chalmers.cs.gf.MCFG.Absyn.Field)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.ListField(); RESULT.addLast(p_1); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListField",11, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // ListField ::= 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListField RESULT =null;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.ListField(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListField",11, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // Field ::= _IDENT_ _SYMB_10 ListSym 
            {
              se.chalmers.cs.gf.MCFG.Absyn.Field RESULT =null;
		String p_1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		se.chalmers.cs.gf.MCFG.Absyn.ListSym p_3 = (se.chalmers.cs.gf.MCFG.Absyn.ListSym)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.Field(p_1,p_3); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Field",10, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // ProfileItem ::= _SYMB_9 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ProfileItem RESULT =null;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.MetaProfileItem(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ProfileItem",9, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // ProfileItem ::= _INTEGER_ 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ProfileItem RESULT =null;
		Integer p_1 = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.ArgProfileItem(p_1); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ProfileItem",9, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // ListProfileItem ::= ProfileItem _SYMB_8 ListProfileItem 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListProfileItem RESULT =null;
		se.chalmers.cs.gf.MCFG.Absyn.ProfileItem p_1 = (se.chalmers.cs.gf.MCFG.Absyn.ProfileItem)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		se.chalmers.cs.gf.MCFG.Absyn.ListProfileItem p_3 = (se.chalmers.cs.gf.MCFG.Absyn.ListProfileItem)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = p_3; p_3.addFirst(p_1); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListProfileItem",8, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // ListProfileItem ::= ProfileItem 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListProfileItem RESULT =null;
		se.chalmers.cs.gf.MCFG.Absyn.ProfileItem p_1 = (se.chalmers.cs.gf.MCFG.Absyn.ProfileItem)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.ListProfileItem(); RESULT.addLast(p_1); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListProfileItem",8, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // ListProfileItem ::= 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListProfileItem RESULT =null;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.ListProfileItem(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListProfileItem",8, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // Profile ::= _SYMB_6 ListProfileItem _SYMB_7 
            {
              se.chalmers.cs.gf.MCFG.Absyn.Profile RESULT =null;
		se.chalmers.cs.gf.MCFG.Absyn.ListProfileItem p_2 = (se.chalmers.cs.gf.MCFG.Absyn.ListProfileItem)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.Profile(p_2); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Profile",7, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // ListRule ::= ListRule Rule _SYMB_0 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListRule RESULT =null;
		se.chalmers.cs.gf.MCFG.Absyn.ListRule p_1 = (se.chalmers.cs.gf.MCFG.Absyn.ListRule)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		se.chalmers.cs.gf.MCFG.Absyn.Rule p_2 = (se.chalmers.cs.gf.MCFG.Absyn.Rule)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = p_1; p_1.addLast(p_2); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListRule",6, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // ListRule ::= 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListRule RESULT =null;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.ListRule(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListRule",6, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Rule ::= _IDENT_ Profile _SYMB_1 Cat _SYMB_2 ListCat _SYMB_3 _SYMB_4 ListField _SYMB_5 
            {
              se.chalmers.cs.gf.MCFG.Absyn.Rule RESULT =null;
		String p_1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-9)).value;
		se.chalmers.cs.gf.MCFG.Absyn.Profile p_2 = (se.chalmers.cs.gf.MCFG.Absyn.Profile)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-8)).value;
		se.chalmers.cs.gf.MCFG.Absyn.Cat p_4 = (se.chalmers.cs.gf.MCFG.Absyn.Cat)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-6)).value;
		se.chalmers.cs.gf.MCFG.Absyn.ListCat p_6 = (se.chalmers.cs.gf.MCFG.Absyn.ListCat)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		se.chalmers.cs.gf.MCFG.Absyn.ListField p_9 = (se.chalmers.cs.gf.MCFG.Absyn.ListField)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.Rule(p_1,p_2,p_4,p_6,p_9); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Rule",5, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // ListFlag ::= ListFlag Flag _SYMB_0 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListFlag RESULT =null;
		se.chalmers.cs.gf.MCFG.Absyn.ListFlag p_1 = (se.chalmers.cs.gf.MCFG.Absyn.ListFlag)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		se.chalmers.cs.gf.MCFG.Absyn.Flag p_2 = (se.chalmers.cs.gf.MCFG.Absyn.Flag)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = p_1; p_1.addLast(p_2); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListFlag",4, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // ListFlag ::= 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListFlag RESULT =null;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.ListFlag(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListFlag",4, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // Flag ::= _SYMB_14 Cat 
            {
              se.chalmers.cs.gf.MCFG.Absyn.Flag RESULT =null;
		se.chalmers.cs.gf.MCFG.Absyn.Cat p_2 = (se.chalmers.cs.gf.MCFG.Absyn.Cat)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.StartCat(p_2); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Flag",3, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // ListMCFG ::= ListMCFG MCFG 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListMCFG RESULT =null;
		se.chalmers.cs.gf.MCFG.Absyn.ListMCFG p_1 = (se.chalmers.cs.gf.MCFG.Absyn.ListMCFG)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		se.chalmers.cs.gf.MCFG.Absyn.MCFG p_2 = (se.chalmers.cs.gf.MCFG.Absyn.MCFG)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = p_1; p_1.addLast(p_2); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListMCFG",2, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // ListMCFG ::= 
            {
              se.chalmers.cs.gf.MCFG.Absyn.ListMCFG RESULT =null;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.ListMCFG(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListMCFG",2, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // MCFG ::= _SYMB_13 _IDENT_ _SYMB_0 ListFlag ListRule _SYMB_12 _SYMB_13 _SYMB_0 
            {
              se.chalmers.cs.gf.MCFG.Absyn.MCFG RESULT =null;
		String p_2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-6)).value;
		se.chalmers.cs.gf.MCFG.Absyn.ListFlag p_4 = (se.chalmers.cs.gf.MCFG.Absyn.ListFlag)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		se.chalmers.cs.gf.MCFG.Absyn.ListRule p_5 = (se.chalmers.cs.gf.MCFG.Absyn.ListRule)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.MCFG(p_2,p_4,p_5); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("MCFG",1, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // MCFGM ::= ListMCFG 
            {
              se.chalmers.cs.gf.MCFG.Absyn.MCFGM RESULT =null;
		se.chalmers.cs.gf.MCFG.Absyn.ListMCFG p_1 = (se.chalmers.cs.gf.MCFG.Absyn.ListMCFG)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new se.chalmers.cs.gf.MCFG.Absyn.MCFGM(p_1); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("MCFGM",0, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= MCFGM EOF 
            {
              Object RESULT =null;
		se.chalmers.cs.gf.MCFG.Absyn.MCFGM start_val = (se.chalmers.cs.gf.MCFG.Absyn.MCFGM)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

