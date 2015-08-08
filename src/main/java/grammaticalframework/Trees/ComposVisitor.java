package grammaticalframework.Trees;

import grammaticalframework.absyn.AbsynTree;
import grammaticalframework.absyn.Lit;
import grammaticalframework.absyn.Visitor;

/**
 * BNFC-Generated Composition Visitor
 */

public class ComposVisitor<A> implements
        Visitor<AbsynTree, A>,
        grammaticalframework.absyn.Lit.Visitor<grammaticalframework.absyn.Lit, A> {
    /* Tree */
    public AbsynTree visit(grammaticalframework.absyn.Lambda p, A arg) {
        String ident_ = p.ident_;
        AbsynTree tree_ = p.tree_.accept(this, arg);

        return new grammaticalframework.absyn.Lambda(ident_, tree_);
    }

    public AbsynTree visit(grammaticalframework.absyn.Variable p, A arg) {
        Integer integer_ = p.integer_;

        return new grammaticalframework.absyn.Variable(integer_);
    }

    public AbsynTree visit(grammaticalframework.absyn.Application p, A arg) {
        AbsynTree tree_1 = p.tree_1.accept(this, arg);
        AbsynTree tree_2 = p.tree_2.accept(this, arg);

        return new grammaticalframework.absyn.Application(tree_1, tree_2);
    }

    public AbsynTree visit(grammaticalframework.absyn.Literal p, A arg) {
        Lit lit_ = p.lit_.accept(this, arg);

        return new grammaticalframework.absyn.Literal(lit_);
    }

    public AbsynTree visit(grammaticalframework.absyn.MetaVariable p, A arg) {
        Integer integer_ = p.integer_;

        return new grammaticalframework.absyn.MetaVariable(integer_);
    }

    public AbsynTree visit(grammaticalframework.absyn.Function p, A arg) {
        String ident_ = p.ident_;

        return new grammaticalframework.absyn.Function(ident_);
    }

    /* Lit */
    public Lit visit(grammaticalframework.absyn.IntLiteral p, A arg) {
        Integer integer_ = p.integer_;

        return new grammaticalframework.absyn.IntLiteral(integer_);
    }

    public Lit visit(grammaticalframework.absyn.FloatLiteral p, A arg) {
        Double double_ = p.double_;

        return new grammaticalframework.absyn.FloatLiteral(double_);
    }

    public Lit visit(grammaticalframework.absyn.StringLiteral p, A arg) {
        String string_ = p.string_;

        return new grammaticalframework.absyn.StringLiteral(string_);
    }

}
