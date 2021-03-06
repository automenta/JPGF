/* IndexedPGFTest.java
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

import java.util.HashSet;


public class IndexedPGFTest extends PGFTestCase {


    PGF foods, phrasebook, phraseIndexed;

    @Override
    protected void setUp() throws Exception {
        foods = getPGF("corpus/Foods.pgf");
        phrasebook = getPGF("corpus/Phrasebook.pgf");
        phraseIndexed = getPGF("corpus/PhrasebookIndexed.pgf");
    }

    public void testIndexedPhrasebookSelect()
            throws java.io.IOException, UnknownLanguageException {
        PGF pgf = getPGF("corpus/PhrasebookIndexed.pgf", "PhrasebookEng", "PhrasebookFre");

        assertTrue(pgf.hasConcrete("PhrasebookEng"));
        assertTrue(pgf.hasConcrete("PhrasebookFre"));
        assertFalse(pgf.hasConcrete("PhrasebookIta"));

        HashSet<String> gold = new HashSet();
        gold.add("PhrasebookEng");
        gold.add("PhrasebookFre");
        assertEquals(gold, pgf.concreteNames());
    }

    public void testIndexedPhrasebookAll()  {
        PGF pgf = phraseIndexed;
        assertTrue(pgf.hasConcrete("PhrasebookEng"));
        assertTrue(pgf.hasConcrete("PhrasebookFre"));
        assertTrue(pgf.hasConcrete("PhrasebookIta"));

        HashSet<String> gold = new HashSet();
        gold.add("DisambPhrasebookEng");
        gold.add("PhrasebookBul");
        gold.add("PhrasebookCat");
        gold.add("PhrasebookDan");
        gold.add("PhrasebookDut");
        gold.add("PhrasebookEng");
        gold.add("PhrasebookFre");
        gold.add("PhrasebookGer");
        gold.add("PhrasebookIta");
        gold.add("PhrasebookNor");
        gold.add("PhrasebookPol");
        gold.add("PhrasebookRon");
        gold.add("PhrasebookSpa");
        gold.add("PhrasebookSwe");
        assertEquals(gold, pgf.concreteNames());
    }

    public void testUnknownLanguage()
            throws java.io.IOException {
        try {
            PGF pgf = getPGF("corpus/Phrasebook.pgf", "PhrasebookEng", "PhrasebookBORK");
            fail("PGFBuilder failed to raise an exception when an unknown language is selected.");
        } catch (UnknownLanguageException e) {
        }
    }

    public void testUninexedFoodsSelect()
            throws java.io.IOException, UnknownLanguageException {
        assertTrue(foods.hasConcrete("FoodsIta"));
        assertFalse(foods.hasConcrete("FoodsFre"));
    }

    public void testUninexedFoodsAll()
            throws java.io.IOException {

        assertTrue(foods.hasConcrete("FoodsIta"));

        HashSet<String> gold = new HashSet();
        gold.add("FoodsAfr");
        gold.add("FoodsAmh");
        gold.add("FoodsBul");
        gold.add("FoodsCat");
        gold.add("FoodsDut");
        gold.add("FoodsEng");
        gold.add("FoodsEpo");
        gold.add("FoodsFas");
        gold.add("FoodsFin");
        gold.add("FoodsGer");
        gold.add("FoodsHeb");
        gold.add("FoodsHin");
        gold.add("FoodsIce");
        gold.add("FoodsIta");
        gold.add("FoodsJpn");
        gold.add("FoodsLav");
        gold.add("FoodsMlt");
        gold.add("FoodsMon");
        gold.add("FoodsPor");
        gold.add("FoodsRon");
        gold.add("FoodsSwe");
        gold.add("FoodsTsn");
        gold.add("FoodsTur");
        gold.add("FoodsUrd");
        assertEquals(gold, foods.concreteNames());
    }
}
