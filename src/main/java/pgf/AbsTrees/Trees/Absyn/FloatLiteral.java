package Trees.Absyn; // Java Package generated by the BNF Converter.

public class FloatLiteral extends Lit {
  public final Double double_;

  public FloatLiteral(Double p1) { double_ = p1; }

  public <R,A> R accept(Trees.Absyn.Lit.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof Trees.Absyn.FloatLiteral) {
      Trees.Absyn.FloatLiteral x = (Trees.Absyn.FloatLiteral)o;
      return this.double_.equals(x.double_);
    }
    return false;
  }

  public int hashCode() {
    return this.double_.hashCode();
  }


}