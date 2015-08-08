/* FoodsPredictTest.java
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

import grammaticalframework.parser.Parser;
import org.grammaticalframework.pgf.ParseError;

import java.io.IOException;
import java.util.Arrays;

public class FoodsPredictTest extends PGFTestCase {


    PGF pgf;

    public void setUp() throws IOException, UnknownLanguageException {
        pgf = getPGF("corpus/Foods.pgf");
    }

    public void testFoodsEng()  throws Exception {
        match(parser("FoodsEng"),
                "that", "these", "this", "those");
    }

    public void testFoodsSwe() throws Exception {
        match(parser("FoodsSwe"),
                "de", "den", "det");
    }


    public void testFoodsIta() throws Exception {
        match(parser("FoodsIta"),
                "quei", "quel", "quella", "quelle",
                "questa", "queste", "questi", "questo");
    }


    private Parser parser(String lang) throws UnknownLanguageException {
        return new Parser(pgf, lang);
    }

    private void match(Parser parser, String... words) throws ParseError {
        String[] predictions = parser.parse().predict();
        Arrays.sort(predictions);
        assertEquals(words.length, predictions.length);
        for (int i = 0; i < words.length; i++)
            assertEquals(words[i], predictions[i]);
    }



    public void tearDown() {
        pgf = null;
    }
}
