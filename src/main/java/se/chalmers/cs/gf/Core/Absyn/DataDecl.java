package se.chalmers.cs.gf.Core.Absyn; // Java Package generated by the BNF Converter.

public class DataDecl extends Decl {
  public final String cident_;
  public final Exp exp_;
  public final ListConsDecl listconsdecl_;

  public DataDecl(String p1, Exp p2, ListConsDecl p3) { cident_ = p1; exp_ = p2; listconsdecl_ = p3; }

  public <R,A> R accept(se.chalmers.cs.gf.Core.Absyn.Decl.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof se.chalmers.cs.gf.Core.Absyn.DataDecl) {
      se.chalmers.cs.gf.Core.Absyn.DataDecl x = (se.chalmers.cs.gf.Core.Absyn.DataDecl)o;
      return this.cident_.equals(x.cident_) && this.exp_.equals(x.exp_) && this.listconsdecl_.equals(x.listconsdecl_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.cident_.hashCode())+this.exp_.hashCode())+this.listconsdecl_.hashCode();
  }


}