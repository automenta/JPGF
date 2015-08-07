package grammaticalframework.Trees;
import grammaticalframework.Trees.absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  AbsynTree.Visitor<AbsynTree,A>,
  grammaticalframework.Trees.absyn.Lit.Visitor<grammaticalframework.Trees.absyn.Lit,A>
{
/* Tree */
    public AbsynTree visit(grammaticalframework.Trees.absyn.Lambda p, A arg)
    {
      String ident_ = p.ident_;
      AbsynTree tree_ = p.tree_.accept(this, arg);

      return new grammaticalframework.Trees.absyn.Lambda(ident_, tree_);
    }
    public AbsynTree visit(grammaticalframework.Trees.absyn.Variable p, A arg)
    {
      Integer integer_ = p.integer_;

      return new grammaticalframework.Trees.absyn.Variable(integer_);
    }
    public AbsynTree visit(grammaticalframework.Trees.absyn.Application p, A arg)
    {
      AbsynTree tree_1 = p.tree_1.accept(this, arg);
      AbsynTree tree_2 = p.tree_2.accept(this, arg);

      return new grammaticalframework.Trees.absyn.Application(tree_1, tree_2);
    }
    public AbsynTree visit(grammaticalframework.Trees.absyn.Literal p, A arg)
    {
      Lit lit_ = p.lit_.accept(this, arg);

      return new grammaticalframework.Trees.absyn.Literal(lit_);
    }
    public AbsynTree visit(grammaticalframework.Trees.absyn.MetaVariable p, A arg)
    {
      Integer integer_ = p.integer_;

      return new grammaticalframework.Trees.absyn.MetaVariable(integer_);
    }
    public AbsynTree visit(grammaticalframework.Trees.absyn.Function p, A arg)
    {
      String ident_ = p.ident_;

      return new grammaticalframework.Trees.absyn.Function(ident_);
    }

/* Lit */
    public Lit visit(grammaticalframework.Trees.absyn.IntLiteral p, A arg)
    {
      Integer integer_ = p.integer_;

      return new grammaticalframework.Trees.absyn.IntLiteral(integer_);
    }
    public Lit visit(grammaticalframework.Trees.absyn.FloatLiteral p, A arg)
    {
      Double double_ = p.double_;

      return new grammaticalframework.Trees.absyn.FloatLiteral(double_);
    }
    public Lit visit(grammaticalframework.Trees.absyn.StringLiteral p, A arg)
    {
      String string_ = p.string_;

      return new grammaticalframework.Trees.absyn.StringLiteral(string_);
    }

}
