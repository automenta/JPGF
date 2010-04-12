package se.chalmers.cs.gf.GFCC.Absyn; // Java Package generated by the BNF Converter.

public class Cnc extends Concrete {
  public final String cid_;
  public final ListCncDef listcncdef_;

  public Cnc(String p1, ListCncDef p2) { cid_ = p1; listcncdef_ = p2; }

  public <R,A> R accept(se.chalmers.cs.gf.GFCC.Absyn.Concrete.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof se.chalmers.cs.gf.GFCC.Absyn.Cnc) {
      se.chalmers.cs.gf.GFCC.Absyn.Cnc x = (se.chalmers.cs.gf.GFCC.Absyn.Cnc)o;
      return this.cid_.equals(x.cid_) && this.listcncdef_.equals(x.listcncdef_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.cid_.hashCode())+this.listcncdef_.hashCode();
  }


}
