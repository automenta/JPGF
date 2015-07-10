/* StartCatTest.java
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
package grammaticalframework;

import grammaticalframework.Trees.Absyn.Tree;
import grammaticalframework.parser.ParseError;

import java.io.IOException;
import java.util.List;

/** This test the ability of the parser t use different start categories **/
public class StartCatTest extends PGFTestCase
{

    public StartCatTest (String name) {
	super(name);
    }

    PGF pgf;

    public void setUp() throws IOException {
	pgf = getPGF("Foods.pgf");
    }

    public void testComment() throws UnknownLanguageException, ParseError {
	Parser parser = new Parser(pgf, "FoodsEng");
	parser.setStartcat("Comment");
	String ex1 = "this fresh pizza is Italian";
	grammaticalframework.Trees.Absyn.Tree tree1 = parseTree("((Pred (This ((Mod Fresh) Pizza))) Italian)");
	List<Tree> trees1 = parser.parse(ex1).getTrees();
	assertTrue(trees1.size()==1);
	assertEquals(trees1.get(0),tree1);

	String ex2 = "those boring fish are expensive";
	grammaticalframework.Trees.Absyn.Tree tree2=parseTree("((Pred (Those ((Mod Boring) Fish))) Expensive)");
		List<Tree> trees2 = parser.parse(ex2).getTrees();
	assertTrue(trees2.size()==1);
	assertEquals(trees2.get(0),tree2);
    }

    public void testItem() throws UnknownLanguageException, ParseError {
	Parser parser = new Parser(pgf, "FoodsEng");
	parser.setStartcat("Item");
	String ex1 = "this fresh pizza";
	grammaticalframework.Trees.Absyn.Tree tree1 = parseTree("(This ((Mod Fresh) Pizza))");
		List<Tree>  trees1 = parser.parse(ex1).getTrees();
	assertTrue(trees1.size()==1);
	assertEquals(trees1.get(0),tree1);

	String ex2 = "those boring fish";
	grammaticalframework.Trees.Absyn.Tree tree2=parseTree("(Those ((Mod Boring) Fish))");
		List<Tree>  trees2 = parser.parse(ex2).getTrees();
	assertTrue(trees2.size()==1);
	assertEquals(trees2.get(0),tree2);
    }


    public void tearDown() {
	pgf = null;
    }
}
