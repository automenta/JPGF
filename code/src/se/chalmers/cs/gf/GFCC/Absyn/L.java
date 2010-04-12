package se.chalmers.cs.gf.GFCC.Absyn; // Java Package generated by the BNF Converter.

public class L extends Term {
  public final String cid_;
  public final Term term_;

  public L(String p1, Term p2) { cid_ = p1; term_ = p2; }

  public <R,A> R accept(se.chalmers.cs.gf.GFCC.Absyn.Term.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof se.chalmers.cs.gf.GFCC.Absyn.L) {
      se.chalmers.cs.gf.GFCC.Absyn.L x = (se.chalmers.cs.gf.GFCC.Absyn.L)o;
      return this.cid_.equals(x.cid_) && this.term_.equals(x.term_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.cid_.hashCode())+this.term_.hashCode();
  }


}
