/* FoodsLinearizeTest.java
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

import java.io.IOException;

public class FoodsLinearizeTest extends PGFTestCase {

    PGF pgf;

    public void setUp() throws IOException, UnknownLanguageException {
        pgf = getPGF("corpus/Foods.pgf");
    }

    protected void match(String lang, String sentence, String tree) throws Exception {

        assertEquals(sentence, new Linearizer(pgf, lang).linearizeString(
                parseTree(tree)
        ));
    }


    public void testFoodsEng() throws Exception {

        match("FoodsEng",
                "this fresh pizza is Italian",
                "((Pred (This ((Mod Fresh) Pizza))) Italian)");
        match("FoodsEng",
                "those boring fish are expensive",
                "((Pred (Those ((Mod Boring) Fish))) Expensive)");

    }

    public void testFoodsSwe() throws Exception {
        match("FoodsSwe",
                "den här läckra pizzan är färsk",
                "((Pred (This ((Mod Delicious) Pizza))) Fresh)");
    }

    public void testFoodsIta() throws Exception {

        match("FoodsIta",
                "questa pizza deliziosa è fresca",
                "((Pred (This ((Mod Delicious) Pizza))) Fresh)");
    }


}
