package se.chalmers.cs.gf.GFC.Absyn; // Java Package generated by the BNF Converter.

public abstract class Label implements java.io.Serializable {
  public abstract <R,A> R accept(Label.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(se.chalmers.cs.gf.GFC.Absyn.L p, A arg);
    public R visit(se.chalmers.cs.gf.GFC.Absyn.LV p, A arg);

  }

}
