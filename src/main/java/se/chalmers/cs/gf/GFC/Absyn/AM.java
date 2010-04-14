package se.chalmers.cs.gf.GFC.Absyn; // Java Package generated by the BNF Converter.

public class AM extends Atom {
  public final Integer integer_;

  public AM(Integer p1) { integer_ = p1; }

  public <R,A> R accept(se.chalmers.cs.gf.GFC.Absyn.Atom.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof se.chalmers.cs.gf.GFC.Absyn.AM) {
      se.chalmers.cs.gf.GFC.Absyn.AM x = (se.chalmers.cs.gf.GFC.Absyn.AM)o;
      return this.integer_.equals(x.integer_);
    }
    return false;
  }

  public int hashCode() {
    return this.integer_.hashCode();
  }


}