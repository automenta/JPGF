package grammaticalframework.Trees;

import grammaticalframework.absyn.AbsynTree;

/**
 * WARNING with the STringBuilder buffer this class is not thread safe.
 * ThreadLocal could do it
 */
public class PrettyPrinter {
    //For certain applications increasing the initial size of the buffer may improve performance.
    private static final int INITIAL_BUFFER_SIZE = 128;
    private final static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
    //You may wish to change the parentheses used in precedence.
    private static final String _L_PAREN = "(";
    private static final String _R_PAREN = ")";
    private static int _n_ = 0;

    //You may wish to change render
    private static void render(String s) {
        if (s.equals("{")) {
            buf_.append('\n');
            indent();
            buf_.append(s);
            _n_ = _n_ + 2;
            buf_.append('\n');
            indent();
        } else if (s.equals("(") || s.equals("["))
            buf_.append(s);
        else if (s.equals(")") || s.equals("]")) {
            backup();
            buf_.append(s);
            buf_.append(' ');
        } else if (s.equals("}")) {
            _n_ = _n_ - 2;
            backup();
            backup();
            buf_.append(s);
            buf_.append('\n');
            indent();
        } else if (s.equals(",")) {
            backup();
            buf_.append(s);
            buf_.append(' ');
        } else if (s.equals(";")) {
            backup();
            buf_.append(s);
            buf_.append('\n');
            indent();
        } else if (s.isEmpty()) return;
        else {
            buf_.append(s);
            buf_.append(' ');
        }
    }


    //  print and show methods are defined for each category.
    public static String print(AbsynTree foo) {
        pp(foo, 0);
        trim();
        String temp = buf_.toString();
        buf_.delete(0, buf_.length());
        return temp;
    }

    public static String show(AbsynTree foo) {
        sh(foo);
        String temp = buf_.toString();
        buf_.delete(0, buf_.length());
        return temp;
    }

    public static String print(grammaticalframework.absyn.Lit foo) {
        pp(foo, 0);
        trim();
        String temp = buf_.toString();
        buf_.delete(0, buf_.length());
        return temp;
    }

    public static String show(grammaticalframework.absyn.Lit foo) {
        sh(foo);
        String temp = buf_.toString();
        buf_.delete(0, buf_.length());
        return temp;
    }

    /***
     * You shouldn't need to change anything beyond this point.
     ***/

    private static void pp(AbsynTree foo, int _i_) {
        if (foo instanceof grammaticalframework.absyn.Lambda) {
            grammaticalframework.absyn.Lambda _lambda = (grammaticalframework.absyn.Lambda) foo;
            if (_i_ > 0) render(_L_PAREN);
            render("\\");
            pp(_lambda.ident_, 0);
            render("->");
            pp(_lambda.tree_, 0);
            if (_i_ > 0) render(_R_PAREN);
        } else if (foo instanceof grammaticalframework.absyn.Variable) {
            grammaticalframework.absyn.Variable _variable = (grammaticalframework.absyn.Variable) foo;
            if (_i_ > 0) render(_L_PAREN);
            render("$");
            pp(_variable.integer_, 0);
            if (_i_ > 0) render(_R_PAREN);
        } else if (foo instanceof grammaticalframework.absyn.Application) {
            grammaticalframework.absyn.Application _application = (grammaticalframework.absyn.Application) foo;
            if (_i_ > 0) render(_L_PAREN);
            render("(");
            pp(_application.tree_1, 0);
            pp(_application.tree_2, 0);
            render(")");
            if (_i_ > 0) render(_R_PAREN);
        } else if (foo instanceof grammaticalframework.absyn.Literal) {
            grammaticalframework.absyn.Literal _literal = (grammaticalframework.absyn.Literal) foo;
            if (_i_ > 0) render(_L_PAREN);
            pp(_literal.lit_, 0);
            if (_i_ > 0) render(_R_PAREN);
        } else if (foo instanceof grammaticalframework.absyn.MetaVariable) {
            grammaticalframework.absyn.MetaVariable _metavariable = (grammaticalframework.absyn.MetaVariable) foo;
            if (_i_ > 0) render(_L_PAREN);
            render("META_");
            pp(_metavariable.integer_, 0);
            if (_i_ > 0) render(_R_PAREN);
        } else if (foo instanceof grammaticalframework.absyn.Function) {
            grammaticalframework.absyn.Function _function = (grammaticalframework.absyn.Function) foo;
            if (_i_ > 0) render(_L_PAREN);
            pp(_function.ident_, 0);
            if (_i_ > 0) render(_R_PAREN);
        }
    }

    private static void pp(grammaticalframework.absyn.Lit foo, int _i_) {
        if (foo instanceof grammaticalframework.absyn.IntLiteral) {
            grammaticalframework.absyn.IntLiteral _intliteral = (grammaticalframework.absyn.IntLiteral) foo;
            if (_i_ > 0) render(_L_PAREN);
            pp(_intliteral.integer_, 0);
            if (_i_ > 0) render(_R_PAREN);
        } else if (foo instanceof grammaticalframework.absyn.FloatLiteral) {
            grammaticalframework.absyn.FloatLiteral _floatliteral = (grammaticalframework.absyn.FloatLiteral) foo;
            if (_i_ > 0) render(_L_PAREN);
            pp(_floatliteral.double_, 0);
            if (_i_ > 0) render(_R_PAREN);
        } else if (foo instanceof grammaticalframework.absyn.StringLiteral) {
            grammaticalframework.absyn.StringLiteral _stringliteral = (grammaticalframework.absyn.StringLiteral) foo;
            if (_i_ > 0) render(_L_PAREN);
            printQuoted(_stringliteral.string_);
            if (_i_ > 0) render(_R_PAREN);
        }
    }


    private static void sh(AbsynTree foo) {
        if (foo instanceof grammaticalframework.absyn.Lambda) {
            grammaticalframework.absyn.Lambda _lambda = (grammaticalframework.absyn.Lambda) foo;
            render("(");
            render("Lambda");
            sh(_lambda.ident_);
            sh(_lambda.tree_);
            render(")");
        }
        if (foo instanceof grammaticalframework.absyn.Variable) {
            grammaticalframework.absyn.Variable _variable = (grammaticalframework.absyn.Variable) foo;
            render("(");
            render("Variable");
            sh(_variable.integer_);
            render(")");
        }
        if (foo instanceof grammaticalframework.absyn.Application) {
            grammaticalframework.absyn.Application _application = (grammaticalframework.absyn.Application) foo;
            render("(");
            render("Application");
            sh(_application.tree_1);
            sh(_application.tree_2);
            render(")");
        }
        if (foo instanceof grammaticalframework.absyn.Literal) {
            grammaticalframework.absyn.Literal _literal = (grammaticalframework.absyn.Literal) foo;
            render("(");
            render("Literal");
            sh(_literal.lit_);
            render(")");
        }
        if (foo instanceof grammaticalframework.absyn.MetaVariable) {
            grammaticalframework.absyn.MetaVariable _metavariable = (grammaticalframework.absyn.MetaVariable) foo;
            render("(");
            render("MetaVariable");
            sh(_metavariable.integer_);
            render(")");
        }
        if (foo instanceof grammaticalframework.absyn.Function) {
            grammaticalframework.absyn.Function _function = (grammaticalframework.absyn.Function) foo;
            render("(");
            render("Function");
            sh(_function.ident_);
            render(")");
        }
    }

    private static void sh(grammaticalframework.absyn.Lit foo) {
        if (foo instanceof grammaticalframework.absyn.IntLiteral) {
            grammaticalframework.absyn.IntLiteral _intliteral = (grammaticalframework.absyn.IntLiteral) foo;
            render("(");
            render("IntLiteral");
            sh(_intliteral.integer_);
            render(")");
        }
        if (foo instanceof grammaticalframework.absyn.FloatLiteral) {
            grammaticalframework.absyn.FloatLiteral _floatliteral = (grammaticalframework.absyn.FloatLiteral) foo;
            render("(");
            render("FloatLiteral");
            sh(_floatliteral.double_);
            render(")");
        }
        if (foo instanceof grammaticalframework.absyn.StringLiteral) {
            grammaticalframework.absyn.StringLiteral _stringliteral = (grammaticalframework.absyn.StringLiteral) foo;
            render("(");
            render("StringLiteral");
            sh(_stringliteral.string_);
            render(")");
        }
    }


    private static void pp(Integer n, int _i_) {
        buf_.append(n);
        buf_.append(' ');
    }

    private static void pp(Double d, int _i_) {
        buf_.append(d);
        buf_.append(' ');
    }

    private static void pp(String s, int _i_) {
        buf_.append(s);
        buf_.append(' ');
    }

    private static void pp(Character c, int _i_) {
        buf_.append('\'').append(c.toString()).append('\'');
        buf_.append(' ');
    }

    private static void sh(Integer n) {
        render(n.toString());
    }

    private static void sh(Double d) {
        render(d.toString());
    }

    private static void sh(Character c) {
        render(c.toString());
    }

    private static void sh(String s) {
        printQuoted(s);
    }

    private static void printQuoted(String s) {
        render('"' + s + '"');
    }

    private static void indent() {
        int n = _n_;
        while (n > 0) {
            buf_.append(' ');
            n--;
        }
    }

    private static void backup() {
        if (buf_.charAt(buf_.length() - 1) == ' ') {
            buf_.setLength(buf_.length() - 1);
        }
    }

    private static void trim() {
        while (buf_.length() > 0 && buf_.charAt(0) == ' ')
            buf_.deleteCharAt(0);
        while (buf_.length() > 0 && buf_.charAt(buf_.length() - 1) == ' ')
            buf_.deleteCharAt(buf_.length() - 1);
    }
}

