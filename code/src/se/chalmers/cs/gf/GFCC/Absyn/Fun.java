package se.chalmers.cs.gf.GFCC.Absyn; // Java Package generated by the BNF Converter.

public class Fun extends AbsDef {
  public final String cid_;
  public final Type type_;
  public final Exp exp_;

  public Fun(String p1, Type p2, Exp p3) { cid_ = p1; type_ = p2; exp_ = p3; }

  public <R,A> R accept(se.chalmers.cs.gf.GFCC.Absyn.AbsDef.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof se.chalmers.cs.gf.GFCC.Absyn.Fun) {
      se.chalmers.cs.gf.GFCC.Absyn.Fun x = (se.chalmers.cs.gf.GFCC.Absyn.Fun)o;
      return this.cid_.equals(x.cid_) && this.type_.equals(x.type_) && this.exp_.equals(x.exp_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.cid_.hashCode())+this.type_.hashCode())+this.exp_.hashCode();
  }


}
