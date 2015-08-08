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

import grammaticalframework.absyn.AbsynTree;
import grammaticalframework.parser.Parser;

import java.io.IOException;
import java.util.List;

/**
 *
 **/
public class FoodsParseTest extends PGFTestCase {

    Parser parser;
    PGF pgf;

    public void setUp() throws IOException, UnknownLanguageException {
        pgf = getPGF("corpus/Foods.pgf");

        parser = new Parser(pgf, "FoodsEng");
    }

    protected void match(String sentence, String treeStr) throws Exception {

        AbsynTree expected = parseTree(treeStr);
        List<AbsynTree> actual = parser.parseToTrees(sentence);

        assertEquals(1, actual.size());
        assertEquals(expected, actual.get(0));
    }

    public void testCommentCategory() throws Exception {

        parser.setStartcat("Comment");

        match("this fresh pizza is Italian",
                "((Pred (This ((Mod Fresh) Pizza))) Italian)");

        match("those boring fish are expensive",
                "((Pred (Those ((Mod Boring) Fish))) Expensive)");
    }

    public void testItemCategory() throws Exception {

        parser.setStartcat("Item");

        match("this fresh pizza",
                "(This ((Mod Fresh) Pizza))");

        match("those boring fish",
                "(Those ((Mod Boring) Fish))");

    }




    public void testFoodsEng() throws Exception {
        match("this fresh pizza is Italian",
                "((Pred (This ((Mod Fresh) Pizza))) Italian)");

        match("those boring fish are expensive",
            "((Pred (Those ((Mod Boring) Fish))) Expensive)");
    }

    public void testFoodsSwe() throws Exception {
        Parser parser = new Parser(pgf, "FoodsSwe");

        match("den här läckra pizzan är färsk",
            "((Pred (This ((Mod Delicious) Pizza))) Fresh)");
    }

    public void testFoodsIta() throws Exception {
        Parser parser = new Parser(pgf, "FoodsIta");

        match("questa pizza deliziosa è fresca",
                "((Pred (This ((Mod Delicious) Pizza))) Fresh)");
    }


}
