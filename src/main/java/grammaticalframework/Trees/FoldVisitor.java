package grammaticalframework.Trees;

/**
 * BNFC-Generated Fold Visitor
 */
public abstract class FoldVisitor<R, A> implements AllVisitor<R, A> {
    public abstract R leaf(A arg);

    public abstract R combine(R x, R y, A arg);

    /* Tree */
    public R visit(grammaticalframework.absyn.Lambda p, A arg) {
        R r = leaf(arg);
        r = combine(p.tree_.accept(this, arg), r, arg);
        return r;
    }

    public R visit(grammaticalframework.absyn.Variable p, A arg) {
        R r = leaf(arg);
        return r;
    }

    public R visit(grammaticalframework.absyn.Application p, A arg) {
        R r = leaf(arg);
        r = combine(p.tree_1.accept(this, arg), r, arg);
        r = combine(p.tree_2.accept(this, arg), r, arg);
        return r;
    }

    public R visit(grammaticalframework.absyn.Literal p, A arg) {
        R r = leaf(arg);
        r = combine(p.lit_.accept(this, arg), r, arg);
        return r;
    }

    public R visit(grammaticalframework.absyn.MetaVariable p, A arg) {
        R r = leaf(arg);
        return r;
    }

    public R visit(grammaticalframework.absyn.Function p, A arg) {
        R r = leaf(arg);
        return r;
    }

    /* Lit */
    public R visit(grammaticalframework.absyn.IntLiteral p, A arg) {
        R r = leaf(arg);
        return r;
    }

    public R visit(grammaticalframework.absyn.FloatLiteral p, A arg) {
        R r = leaf(arg);
        return r;
    }

    public R visit(grammaticalframework.absyn.StringLiteral p, A arg) {
        R r = leaf(arg);
        return r;
    }


}
