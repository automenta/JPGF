/* AbstractVisitor.java
 * Copyright (C) 2010 Grégoire Détrez, Ramona Enache
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package grammaticalframework.Trees;

import grammaticalframework.Trees.absyn.AbsynTree;

/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* Tree */
    public R visit(grammaticalframework.Trees.absyn.Lambda p, A arg) { return visitDefault(p, arg); }
    public R visit(grammaticalframework.Trees.absyn.Variable p, A arg) { return visitDefault(p, arg); }
    public R visit(grammaticalframework.Trees.absyn.Application p, A arg) { return visitDefault(p, arg); }
    public R visit(grammaticalframework.Trees.absyn.Literal p, A arg) { return visitDefault(p, arg); }
    public R visit(grammaticalframework.Trees.absyn.MetaVariable p, A arg) { return visitDefault(p, arg); }
    public R visit(grammaticalframework.Trees.absyn.Function p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(AbsynTree p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Lit */
    public R visit(grammaticalframework.Trees.absyn.IntLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(grammaticalframework.Trees.absyn.FloatLiteral p, A arg) { return visitDefault(p, arg); }
    public R visit(grammaticalframework.Trees.absyn.StringLiteral p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(grammaticalframework.Trees.absyn.Lit p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
