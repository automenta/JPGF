package se.chalmers.cs.gf.GFC.Absyn; // Java Package generated by the BNF Converter.

public class AnyDInd extends Def {
  public final String ident_1, ident_2;
  public final Status status_;

  public AnyDInd(String p1, Status p2, String p3) { ident_1 = p1; status_ = p2; ident_2 = p3; }

  public <R,A> R accept(se.chalmers.cs.gf.GFC.Absyn.Def.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof se.chalmers.cs.gf.GFC.Absyn.AnyDInd) {
      se.chalmers.cs.gf.GFC.Absyn.AnyDInd x = (se.chalmers.cs.gf.GFC.Absyn.AnyDInd)o;
      return this.ident_1.equals(x.ident_1) && this.status_.equals(x.status_) && this.ident_2.equals(x.ident_2);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.ident_1.hashCode())+this.status_.hashCode())+this.ident_2.hashCode();
  }


}