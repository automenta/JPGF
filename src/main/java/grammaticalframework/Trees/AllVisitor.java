package grammaticalframework.Trees;

import grammaticalframework.Trees.absyn.AbsynTree;

/** BNFC-Generated All Visitor */
public interface AllVisitor<R,A> extends
  AbsynTree.Visitor<R,A>,
  grammaticalframework.Trees.absyn.Lit.Visitor<R,A>
{}
