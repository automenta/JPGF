/* Parser.java
 * Copyright (C) 2010 Grégoire Détrez
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

import grammaticalframework.reader.*;
import grammaticalframework.parser.*;


public class Parser {
    private Concrete language;
    private String startcat;
    /* ******************************** API ******************************** */
    public Parser(PGF pgf, Concrete language) {
        this.language = language;
        this.startcat = pgf.getAbstract().startcat();
    }

    public Parser(PGF pgf, String language)
        throws UnknownLanguageException
    {
        this(pgf, pgf.getConcrete(language));
    }

    
    public void setStartcat(String startcat) {
        this.startcat = startcat;
    }


    /**
     * Parse the given list of tokens
     * @param tokens the input tokens
     * @return the corresponding parse-state
     **/
    public ParseState parse(String[] tokens) throws ParseError {
        ParseState ps = new ParseState(this.language, this.startcat);
        for (String w : tokens)
            if (!ps.scan(w))
                break;
        return ps;
    }

    /**
     * Parse the given list of tokens
     * @param tokens the input tokens
     * @return an array of trees
     **/
    // FIXME: not using the start category ??
    // FIXME: Return collection
    public java.util.List<grammaticalframework.Trees.absyn.Tree> parseToTrees(String[] tokens) throws ParseError {
	    return this.parse(tokens).getTrees();
    }

    public java.util.List<grammaticalframework.Trees.absyn.Tree> parseToTrees(String tokens) throws ParseError {
        return parseToTrees(tokenize(tokens));
    }

    /**
     * Parse the given string
     * uses a very basic tokenizer that split on whitespaces.
     * @param phrase the input string
     * @return the corresponding parse-state
     **/
    public ParseState parse(String phrase) throws ParseError {
        return this.parse(tokenize(phrase));
    }

    private static String[] tokenize(String phrase) {
        return phrase.split(" ");
    }

    /**
     * Parses the empty string
     * (usefull for completion)
     * @param startcat the start category
     * @return the corresponding parse-state
     **/
    public ParseState parse() throws ParseError {
        return this.parse(new String[0]);
    }

}
