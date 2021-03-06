package grammaticalframework.absyn; // Java Package generated by the BNF Converter.

public class MetaVariable implements AbsynTree {
    public final Integer integer_;

    public MetaVariable(Integer p1) {
        integer_ = p1;
    }

    public <R, A> R accept(Visitor<R, A> v, A arg) {
        return v.visit(this, arg);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof grammaticalframework.absyn.MetaVariable) {
            grammaticalframework.absyn.MetaVariable x = (grammaticalframework.absyn.MetaVariable) o;
            return this.integer_.equals(x.integer_);
        }
        return false;
    }

    public int hashCode() {
        return this.integer_.hashCode();
    }


}
