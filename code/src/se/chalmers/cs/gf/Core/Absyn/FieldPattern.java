package se.chalmers.cs.gf.Core.Absyn; // Java Package generated by the BNF Converter.

public class FieldPattern {
  public final String cident_;
  public final Pattern pattern_;

  public FieldPattern(String p1, Pattern p2) { cident_ = p1; pattern_ = p2; }

  public <R,A> R accept(se.chalmers.cs.gf.Core.Absyn.FieldPattern.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof se.chalmers.cs.gf.Core.Absyn.FieldPattern) {
      se.chalmers.cs.gf.Core.Absyn.FieldPattern x = (se.chalmers.cs.gf.Core.Absyn.FieldPattern)o;
      return this.cident_.equals(x.cident_) && this.pattern_.equals(x.pattern_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.cident_.hashCode())+this.pattern_.hashCode();
  }

  public interface Visitor <R,A> {
    public R visit(se.chalmers.cs.gf.Core.Absyn.FieldPattern p, A arg);

  }

}
