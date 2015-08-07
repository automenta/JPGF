package grammaticalframework.Trees;
import grammaticalframework.Trees.absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class TreeVisitor<R,A> implements AbsynTree.Visitor<R,A>
  {
    public R visit(grammaticalframework.Trees.absyn.Lambda p, A arg)
    {
      /* Code For Lambda Goes Here */

      //p.ident_;
      p.tree_.accept(new TreeVisitor<R,A>(), arg);

      return null;
    }
    public R visit(grammaticalframework.Trees.absyn.Variable p, A arg)
    {
      /* Code For Variable Goes Here */

      //p.integer_;

      return null;
    }
    public R visit(grammaticalframework.Trees.absyn.Application p, A arg)
    {
      /* Code For Application Goes Here */

      p.tree_1.accept(new TreeVisitor<R,A>(), arg);
      p.tree_2.accept(new TreeVisitor<R,A>(), arg);

      return null;
    }
    public R visit(grammaticalframework.Trees.absyn.Literal p, A arg)
    {
      /* Code For Literal Goes Here */

      p.lit_.accept(new LitVisitor<R, A>(), arg);

      return null;
    }
    public R visit(grammaticalframework.Trees.absyn.MetaVariable p, A arg)
    {
      /* Code For MetaVariable Goes Here */

      //p.integer_;

      return null;
    }
    public R visit(grammaticalframework.Trees.absyn.Function p, A arg)
    {
      /* Code For Function Goes Here */

      //p.ident_;

      return null;
    }

  }
  public static class LitVisitor<R,A> implements Lit.Visitor<R,A>
  {
    public R visit(grammaticalframework.Trees.absyn.IntLiteral p, A arg)
    {
      /* Code For IntLiteral Goes Here */

      //p.integer_;

      return null;
    }
    public R visit(grammaticalframework.Trees.absyn.FloatLiteral p, A arg)
    {
      /* Code For FloatLiteral Goes Here */

      //p.double_;

      return null;
    }
    public R visit(grammaticalframework.Trees.absyn.StringLiteral p, A arg)
    {
      /* Code For StringLiteral Goes Here */

      //p.string_;

      return null;
    }

  }
}
