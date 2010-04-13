package se.chalmers.cs.gf.GFC.Absyn; // Java Package generated by the BNF Converter.

public class API extends APatt {
  public final Integer integer_;

  public API(Integer p1) { integer_ = p1; }

  public <R,A> R accept(se.chalmers.cs.gf.GFC.Absyn.APatt.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof se.chalmers.cs.gf.GFC.Absyn.API) {
      se.chalmers.cs.gf.GFC.Absyn.API x = (se.chalmers.cs.gf.GFC.Absyn.API)o;
      return this.integer_.equals(x.integer_);
    }
    return false;
  }

  public int hashCode() {
    return this.integer_.hashCode();
  }


}