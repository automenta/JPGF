package se.chalmers.cs.gf.SyntaxTree.Absyn; // Java Package generated by the BNF Converter.

public class TStr extends Tr implements java.io.Serializable
{
  public String string_;

  public TStr(String p1) { string_ = p1; }

  public <R,A> R accept(se.chalmers.cs.gf.SyntaxTree.Absyn.Tr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }


}
