package grammaticalframework.absyn; // Java Package generated by the BNF Converter.

public class Lambda implements AbsynTree {
    public final String ident_;
    public final AbsynTree tree_;

    public Lambda(String p1, AbsynTree p2) {
        ident_ = p1;
        tree_ = p2;
    }

    public <R, A> R accept(Visitor<R, A> v, A arg) {
        return v.visit(this, arg);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof grammaticalframework.absyn.Lambda) {
            grammaticalframework.absyn.Lambda x = (grammaticalframework.absyn.Lambda) o;
            return this.ident_.equals(x.ident_) && this.tree_.equals(x.tree_);
        }
        return false;
    }

    public int hashCode() {
        return 37 * (this.ident_.hashCode()) + this.tree_.hashCode();
    }


}
