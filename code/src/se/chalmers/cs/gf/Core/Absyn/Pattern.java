package se.chalmers.cs.gf.Core.Absyn; // Java Package generated by the BNF Converter.

public abstract class Pattern implements java.io.Serializable {
  public abstract <R,A> R accept(Pattern.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(se.chalmers.cs.gf.Core.Absyn.PCons p, A arg);
    public R visit(se.chalmers.cs.gf.Core.Absyn.PVar p, A arg);
    public R visit(se.chalmers.cs.gf.Core.Absyn.PRec p, A arg);
    public R visit(se.chalmers.cs.gf.Core.Absyn.PStr p, A arg);
    public R visit(se.chalmers.cs.gf.Core.Absyn.PInt p, A arg);

  }

}