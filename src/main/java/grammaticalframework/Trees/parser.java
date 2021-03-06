//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Mon May 24 13:47:32 CEST 2010
//----------------------------------------------------

package grammaticalframework.Trees;


import grammaticalframework.absyn.AbsynTree;

/**
 * CUP v0.11a beta 20060608 generated parser.
 *
 * @version Mon May 24 13:47:32 CEST 2010
 */
public class parser extends java_cup.runtime.lr_parser {

    /**
     * Production table.
     */
    protected static final short _production_table[][] =
            unpackFromStrings(new String[]{
                    "\000\012\000\002\002\004\000\002\002\006\000\002\002" +
                            "\004\000\002\002\006\000\002\002\003\000\002\002\004" +
                            "\000\002\002\003\000\002\003\003\000\002\003\003\000" +
                            "\002\003\003"});
    /**
     * Parse-action table.
     */
    protected static final short[][] _action_table =
            unpackFromStrings(new String[]{
                    "\000\024\000\022\004\010\006\006\007\005\011\004\012" +
                            "\012\013\013\014\014\015\011\001\002\000\004\013\026" +
                            "\001\002\000\022\004\010\006\006\007\005\011\004\012" +
                            "\012\013\013\014\014\015\011\001\002\000\004\013\022" +
                            "\001\002\000\004\002\021\001\002\000\004\015\016\001" +
                            "\002\000\026\002\ufffb\004\ufffb\006\ufffb\007\ufffb\010\ufffb" +
                            "\011\ufffb\012\ufffb\013\ufffb\014\ufffb\015\ufffb\001\002\000" +
                            "\026\002\ufff8\004\ufff8\006\ufff8\007\ufff8\010\ufff8\011\ufff8" +
                            "\012\ufff8\013\ufff8\014\ufff8\015\ufff8\001\002\000\026\002" +
                            "\ufffa\004\ufffa\006\ufffa\007\ufffa\010\ufffa\011\ufffa\012\ufffa" +
                            "\013\ufffa\014\ufffa\015\ufffa\001\002\000\026\002\ufff9\004" +
                            "\ufff9\006\ufff9\007\ufff9\010\ufff9\011\ufff9\012\ufff9\013\ufff9" +
                            "\014\ufff9\015\ufff9\001\002\000\026\002\ufffd\004\ufffd\006" +
                            "\ufffd\007\ufffd\010\ufffd\011\ufffd\012\ufffd\013\ufffd\014\ufffd" +
                            "\015\ufffd\001\002\000\004\005\017\001\002\000\022\004" +
                            "\010\006\006\007\005\011\004\012\012\013\013\014\014" +
                            "\015\011\001\002\000\026\002\000\004\000\006\000\007" +
                            "\000\010\000\011\000\012\000\013\000\014\000\015\000" +
                            "\001\002\000\004\002\001\001\002\000\026\002\uffff\004" +
                            "\uffff\006\uffff\007\uffff\010\uffff\011\uffff\012\uffff\013\uffff" +
                            "\014\uffff\015\uffff\001\002\000\022\004\010\006\006\007" +
                            "\005\011\004\012\012\013\013\014\014\015\011\001\002" +
                            "\000\004\010\025\001\002\000\026\002\ufffe\004\ufffe\006" +
                            "\ufffe\007\ufffe\010\ufffe\011\ufffe\012\ufffe\013\ufffe\014\ufffe" +
                            "\015\ufffe\001\002\000\026\002\ufffc\004\ufffc\006\ufffc\007" +
                            "\ufffc\010\ufffc\011\ufffc\012\ufffc\013\ufffc\014\ufffc\015\ufffc" +
                            "\001\002"});
    /**
     * <code>reduce_goto</code> table.
     */
    protected static final short[][] _reduce_table =
            unpackFromStrings(new String[]{
                    "\000\024\000\006\002\006\003\014\001\001\000\002\001" +
                            "\001\000\006\002\022\003\014\001\001\000\002\001\001" +
                            "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
                            "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
                            "\001\001\000\002\001\001\000\006\002\017\003\014\001" +
                            "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
                            "\000\006\002\023\003\014\001\001\000\002\001\001\000" +
                            "\002\001\001\000\002\001\001"});
    /**
     * Instance of action encapsulation class.
     */
    protected CUP$parser$actions action_obj;

    /**
     * Default constructor.
     */
    public parser() {
        super();
    }

    /**
     * Constructor which sets the default scanner.
     */
    public parser(java_cup.runtime.Scanner s) {
        super(s);
    }

    /**
     * Constructor which sets the default scanner.
     */
    public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {
        super(s, sf);
    }

    public static <B, A extends java.util.LinkedList<? super B>> A cons_(B x, A xs) {
        xs.addFirst(x);
        return xs;
    }

    /**
     * Access to production table.
     */
    public short[][] production_table() {
        return _production_table;
    }

    /**
     * Access to parse-action table.
     */
    public short[][] action_table() {
        return _action_table;
    }

    /**
     * Access to <code>reduce_goto</code> table.
     */
    public short[][] reduce_table() {
        return _reduce_table;
    }

    /**
     * Action encapsulation object initializer.
     */
    protected void init_actions() {
        action_obj = new CUP$parser$actions(this);
    }

    /**
     * Invoke a user supplied parse action.
     */
    public java_cup.runtime.Symbol do_action(
            int act_num,
            java_cup.runtime.lr_parser parser,
            java.util.Stack stack,
            int top)
            throws java.lang.Exception {
    /* call code in generated class */
        return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
    }

    /**
     * Indicates start state.
     */
    public int start_state() {
        return 0;
    }

    /**
     * Indicates start production.
     */
    public int start_production() {
        return 0;
    }

    /**
     * <code>EOF</code> Symbol index.
     */
    public int EOF_sym() {
        return 0;
    }

    /**
     * <code>error</code> Symbol index.
     */
    public int error_sym() {
        return 1;
    }

    public AbsynTree pTree() throws Exception {
        java_cup.runtime.Symbol res = parse();
        return (AbsynTree) res.value;
    }

    public void syntax_error(java_cup.runtime.Symbol cur_token) {
        report_error("Syntax Error, trying to recover and continue parse...", cur_token);
    }

    public void unrecovered_syntax_error(java_cup.runtime.Symbol cur_token) throws java.lang.Exception {
        throw new Exception("Unrecoverable Syntax Error");
    }


}

/**
 * Cup generated class to encapsulate user supplied action code.
 */
class CUP$parser$actions {
    private final parser parser;

    /**
     * Constructor
     */
    CUP$parser$actions(parser parser) {
        this.parser = parser;
    }

    /**
     * Method with the actual generated action code.
     */
    public final java_cup.runtime.Symbol CUP$parser$do_action(
            int CUP$parser$act_num,
            java_cup.runtime.lr_parser CUP$parser$parser,
            java.util.Stack CUP$parser$stack,
            int CUP$parser$top)
            throws java.lang.Exception {
      /* Symbol object for return from actions */
        java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
        switch (CUP$parser$act_num) {
          /*. . . . . . . . . . . . . . . . . . . .*/
            case 9: // Lit ::= _STRING_
            {
                grammaticalframework.absyn.Lit RESULT = null;
                String p_1 = (String) ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
                RESULT = new grammaticalframework.absyn.StringLiteral(p_1);
                CUP$parser$result = parser.getSymbolFactory().newSymbol("Lit", 1, RESULT);
            }
            return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 8: // Lit ::= _DOUBLE_
            {
                grammaticalframework.absyn.Lit RESULT = null;
                Double p_1 = (Double) ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
                RESULT = new grammaticalframework.absyn.FloatLiteral(p_1);
                CUP$parser$result = parser.getSymbolFactory().newSymbol("Lit", 1, RESULT);
            }
            return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 7: // Lit ::= _INTEGER_
            {
                grammaticalframework.absyn.Lit RESULT = null;
                Integer p_1 = (Integer) ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
                RESULT = new grammaticalframework.absyn.IntLiteral(p_1);
                CUP$parser$result = parser.getSymbolFactory().newSymbol("Lit", 1, RESULT);
            }
            return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 6: // Tree ::= _IDENT_
            {
                AbsynTree RESULT = null;
                String p_1 = (String) ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
                RESULT = new grammaticalframework.absyn.Function(p_1);
                CUP$parser$result = parser.getSymbolFactory().newSymbol("Tree", 0, RESULT);
            }
            return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 5: // Tree ::= _SYMB_5 _INTEGER_
            {
                AbsynTree RESULT = null;
                Integer p_2 = (Integer) ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
                RESULT = new grammaticalframework.absyn.MetaVariable(p_2);
                CUP$parser$result = parser.getSymbolFactory().newSymbol("Tree", 0, RESULT);
            }
            return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 4: // Tree ::= Lit
            {
                AbsynTree RESULT = null;
                grammaticalframework.absyn.Lit p_1 = (grammaticalframework.absyn.Lit) ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
                RESULT = new grammaticalframework.absyn.Literal(p_1);
                CUP$parser$result = parser.getSymbolFactory().newSymbol("Tree", 0, RESULT);
            }
            return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 3: // Tree ::= _SYMB_3 Tree Tree _SYMB_4
            {
                AbsynTree RESULT = null;
                AbsynTree p_2 = (AbsynTree) ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top - 2)).value;
                AbsynTree p_3 = (AbsynTree) ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top - 1)).value;
                RESULT = new grammaticalframework.absyn.Application(p_2, p_3);
                CUP$parser$result = parser.getSymbolFactory().newSymbol("Tree", 0, RESULT);
            }
            return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 2: // Tree ::= _SYMB_2 _INTEGER_
            {
                AbsynTree RESULT = null;
                Integer p_2 = (Integer) ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
                RESULT = new grammaticalframework.absyn.Variable(p_2);
                CUP$parser$result = parser.getSymbolFactory().newSymbol("Tree", 0, RESULT);
            }
            return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 1: // Tree ::= _SYMB_0 _IDENT_ _SYMB_1 Tree
            {
                AbsynTree RESULT = null;
                String p_2 = (String) ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top - 2)).value;
                AbsynTree p_4 = (AbsynTree) ((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
                RESULT = new grammaticalframework.absyn.Lambda(p_2, p_4);
                CUP$parser$result = parser.getSymbolFactory().newSymbol("Tree", 0, RESULT);
            }
            return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
            case 0: // $START ::= Tree EOF
            {
                Object RESULT = null;
                AbsynTree start_val = (AbsynTree) ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top - 1)).value;
                RESULT = start_val;
                CUP$parser$result = parser.getSymbolFactory().newSymbol("$START", 0, RESULT);
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

