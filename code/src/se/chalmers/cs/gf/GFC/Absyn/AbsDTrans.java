package se.chalmers.cs.gf.GFC.Absyn; // Java Package generated by the BNF Converter.

public class AbsDTrans extends Def {
  public final String ident_;
  public final Exp exp_;

  public AbsDTrans(String p1, Exp p2) { ident_ = p1; exp_ = p2; }

  public <R,A> R accept(se.chalmers.cs.gf.GFC.Absyn.Def.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof se.chalmers.cs.gf.GFC.Absyn.AbsDTrans) {
      se.chalmers.cs.gf.GFC.Absyn.AbsDTrans x = (se.chalmers.cs.gf.GFC.Absyn.AbsDTrans)o;
      return this.ident_.equals(x.ident_) && this.exp_.equals(x.exp_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.ident_.hashCode())+this.exp_.hashCode();
  }


}
