package se.chalmers.cs.gf.GFC.Absyn; // Java Package generated by the BNF Converter.

public abstract class Def implements java.io.Serializable {
  public abstract <R,A> R accept(Def.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(se.chalmers.cs.gf.GFC.Absyn.AbsDCat p, A arg);
    public R visit(se.chalmers.cs.gf.GFC.Absyn.AbsDFun p, A arg);
    public R visit(se.chalmers.cs.gf.GFC.Absyn.AbsDTrans p, A arg);
    public R visit(se.chalmers.cs.gf.GFC.Absyn.ResDPar p, A arg);
    public R visit(se.chalmers.cs.gf.GFC.Absyn.ResDOper p, A arg);
    public R visit(se.chalmers.cs.gf.GFC.Absyn.CncDCat p, A arg);
    public R visit(se.chalmers.cs.gf.GFC.Absyn.CncDFun p, A arg);
    public R visit(se.chalmers.cs.gf.GFC.Absyn.AnyDInd p, A arg);

  }

}
