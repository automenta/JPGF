package se.chalmers.cs.gf.Core.Absyn; // Java Package generated by the BNF Converter.

public class EStr extends Exp {
  public final String string_;

  public EStr(String p1) { string_ = p1; }

  public <R,A> R accept(se.chalmers.cs.gf.Core.Absyn.Exp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof se.chalmers.cs.gf.Core.Absyn.EStr) {
      se.chalmers.cs.gf.Core.Absyn.EStr x = (se.chalmers.cs.gf.Core.Absyn.EStr)o;
      return this.string_.equals(x.string_);
    }
    return false;
  }

  public int hashCode() {
    return this.string_.hashCode();
  }


}
