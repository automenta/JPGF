/* Application.java
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
package grammaticalframework.Trees.absyn; // Java Package generated by the BNF Converter.

import java.util.*;

public class Application extends AbsynTree {

    public final AbsynTree tree_1, tree_2;

    public Application(AbsynTree p1, AbsynTree p2) {
	tree_1 = p1; tree_2 = p2;
    }

    static public AbsynTree application(AbsynTree function, List<AbsynTree> args) {
	if (args.size() == 0)
	    return function;
	AbsynTree f2 = application(function, args.subList(0, args.size() - 1));
	return new Application(f2, args.get(args.size() - 1));
    }
    


    public <R,A> R accept(AbsynTree.Visitor<R,A> v, A arg) {
	return v.visit(this, arg);
    }
    
    public boolean equals(Object o) {
	if (this == o) return true;
	if (o instanceof grammaticalframework.Trees.absyn.Application) {
	    grammaticalframework.Trees.absyn.Application x = (grammaticalframework.Trees.absyn.Application)o;
	    return this.tree_1.equals(x.tree_1) && this.tree_2.equals(x.tree_2);
	}
	return false;
    }
    
    public int hashCode() {
	return 37*(this.tree_1.hashCode())+this.tree_2.hashCode();
    }

    public String toString() {
	return "(" + this.tree_1 + ' ' + tree_2 + ')';
    }
}
