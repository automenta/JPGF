package se.chalmers.cs.gf.CFG.Absyn; // Java Package generated by the BNF Converter.

public class Coerce extends Fun {

  public Coerce() { }

  public <R,A> R accept(se.chalmers.cs.gf.CFG.Absyn.Fun.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof se.chalmers.cs.gf.CFG.Absyn.Coerce) {
      return true;
    }
    return false;
  }

  public int hashCode() {
    return 37;
  }


}
