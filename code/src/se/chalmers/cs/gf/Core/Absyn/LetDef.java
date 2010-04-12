package se.chalmers.cs.gf.Core.Absyn; // Java Package generated by the BNF Converter.

public class LetDef {
  public final String cident_;
  public final Exp exp_;

  public LetDef(String p1, Exp p2) { cident_ = p1; exp_ = p2; }

  public <R,A> R accept(se.chalmers.cs.gf.Core.Absyn.LetDef.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof se.chalmers.cs.gf.Core.Absyn.LetDef) {
      se.chalmers.cs.gf.Core.Absyn.LetDef x = (se.chalmers.cs.gf.Core.Absyn.LetDef)o;
      return this.cident_.equals(x.cident_) && this.exp_.equals(x.exp_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.cident_.hashCode())+this.exp_.hashCode();
  }

  public interface Visitor <R,A> {
    public R visit(se.chalmers.cs.gf.Core.Absyn.LetDef p, A arg);

  }

}
