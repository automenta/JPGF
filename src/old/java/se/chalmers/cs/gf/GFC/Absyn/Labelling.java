package se.chalmers.cs.gf.GFC.Absyn; // Java Package generated by the BNF Converter.

public abstract class Labelling implements java.io.Serializable {
  public abstract <R,A> R accept(Labelling.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(se.chalmers.cs.gf.GFC.Absyn.Lbg p, A arg);

  }

}