package grammaticalframework.Trees.Absyn; // Java Package generated by the BNF Converter.

public class StringLiteral extends Lit {
  public final String string_;

  public StringLiteral(String p1) { string_ = p1; }

  public <R,A> R accept(grammaticalframework.Trees.Absyn.Lit.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof grammaticalframework.Trees.Absyn.StringLiteral) {
      grammaticalframework.Trees.Absyn.StringLiteral x = (grammaticalframework.Trees.Absyn.StringLiteral)o;
      return this.string_.equals(x.string_);
    }
    return false;
  }

  public int hashCode() {
    return this.string_.hashCode();
  }


}
