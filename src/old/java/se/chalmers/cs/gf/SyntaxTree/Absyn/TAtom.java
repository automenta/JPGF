package se.chalmers.cs.gf.SyntaxTree.Absyn; // Java Package generated by the BNF Converter.

public class TAtom extends Tr implements java.io.Serializable
{
  public String ident_;

  public TAtom(String p1) { ident_ = p1; }

  public <R,A> R accept(se.chalmers.cs.gf.SyntaxTree.Absyn.Tr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }


}