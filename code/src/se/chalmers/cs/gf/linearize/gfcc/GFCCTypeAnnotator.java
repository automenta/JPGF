/*
 * GFCCTypeAnnotator.java
 * Copyright (C) 2004-2006, Bjorn Bringert (bringert@cs.chalmers.se)
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
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package se.chalmers.cs.gf.linearize.gfcc;

import se.chalmers.cs.gf.GFException;
import se.chalmers.cs.gf.abssyn.Tree;
import se.chalmers.cs.gf.abssyn.TreeVisitor;
import se.chalmers.cs.gf.abssyn.MetaVariable;
import se.chalmers.cs.gf.linearize.TypeAnnotator;
import se.chalmers.cs.gf.GFCC.Absyn.*;

import java.util.HashMap;
import java.util.Map;

/**
 *  Does type annotation of abstract syntax trees.
 */
public class GFCCTypeAnnotator implements TypeAnnotator {

        private Map<String,Typ> types;

        /**
         *  @param module Abstract module used to get types of functions.
         */
        public GFCCTypeAnnotator(Grammar g) {
		types = new HashMap<String,Typ>();

                Abs abs = (Abs)((Grm)g).abstract_;
		for (AbsDef d : abs.listabsdef_) {
			Fun f = (Fun)d;
			types.put(f.cid_, (Typ)f.type_);
		}
        }

        /**
         *  Type-annotate all meta-variables in the given tree.
         *  Returns the new tree.
         */
        public Tree annotate(Tree t) {
                String startcat = null; //FIXME: figure out startcat
                return t.accept(new Annotator(), startcat);
        }

	private Typ lookup(String name) {
		Typ t = types.get(name);
		if (t == null) 
			throw new GFException("Unknown function: " + name);
		return t;
	}

        private class Annotator implements TreeVisitor<Tree,String> {
                public Tree visit(se.chalmers.cs.gf.abssyn.Fun f, String type) {
                        Typ t = lookup(f.getLabel());
			int arity = t.listcid_.size();

                        if (arity != f.countChildren())
                                throw new GFException("TypeAnnotator: " + f.getLabel() 
                                                      + " needs " + arity + " children "
                                                      + " got " + f.countChildren());


                        Tree[] children = new Tree[arity];
                        for (int i = 0; i < arity; i++) 
                                children[i] = f.getChild(i).accept(this, t.listcid_.get(i));
                        return new se.chalmers.cs.gf.abssyn.Fun(f.getLabel(), children, f.getInputRanges());
                }

                public Tree visit(se.chalmers.cs.gf.abssyn.IntLiteral l, String type) {
                        return l;
                }

                public Tree visit(se.chalmers.cs.gf.abssyn.StringLiteral l, String type) {
                        return l;
                }

                public Tree visit(MetaVariable v, String type) {
                        return new MetaVariable(type);
                }
        }

}
