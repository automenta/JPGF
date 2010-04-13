package se.chalmers.cs.gf.GFC.Absyn; // Java Package generated by the BNF Converter.

public class Lbg extends Labelling {
  public final Label label_;
  public final CType ctype_;

  public Lbg(Label p1, CType p2) { label_ = p1; ctype_ = p2; }

  public <R,A> R accept(se.chalmers.cs.gf.GFC.Absyn.Labelling.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof se.chalmers.cs.gf.GFC.Absyn.Lbg) {
      se.chalmers.cs.gf.GFC.Absyn.Lbg x = (se.chalmers.cs.gf.GFC.Absyn.Lbg)o;
      return this.label_.equals(x.label_) && this.ctype_.equals(x.ctype_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.label_.hashCode())+this.ctype_.hashCode();
  }


}