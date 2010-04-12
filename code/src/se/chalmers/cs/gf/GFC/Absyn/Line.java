package se.chalmers.cs.gf.GFC.Absyn; // Java Package generated by the BNF Converter.

public abstract class Line implements java.io.Serializable {
  public abstract <R,A> R accept(Line.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(se.chalmers.cs.gf.GFC.Absyn.LMulti p, A arg);
    public R visit(se.chalmers.cs.gf.GFC.Absyn.LHeader p, A arg);
    public R visit(se.chalmers.cs.gf.GFC.Absyn.LFlag p, A arg);
    public R visit(se.chalmers.cs.gf.GFC.Absyn.LDef p, A arg);
    public R visit(se.chalmers.cs.gf.GFC.Absyn.LEnd p, A arg);

  }

}
