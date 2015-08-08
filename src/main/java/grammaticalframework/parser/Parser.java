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
package grammaticalframework.parser;

import com.google.common.collect.Lists;
import grammaticalframework.PGF;
import grammaticalframework.UnknownLanguageException;
import grammaticalframework.absyn.AbsynTree;
import grammaticalframework.absyn.Application;
import grammaticalframework.absyn.Function;
import grammaticalframework.reader.ApplProduction;
import grammaticalframework.reader.CncCat;
import grammaticalframework.reader.Concrete;
import org.grammaticalframework.pgf.ParseError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;


public class Parser {

    public static final String[] EMPTY = new String[0];

    private final Concrete language;
    private String startcat;

    public Parser(PGF pgf, Concrete language) {
        this.language = language;
        this.startcat = pgf.getAbstract().startcat();
    }

    public Parser(PGF pgf, String language) throws UnknownLanguageException {
        this(pgf, pgf.getConcrete(language));
    }

    private static String[] tokenize(String phrase) {
        return phrase.split(" ");
    }

    public void setStartcat(String startcat) {
        this.startcat = startcat;
    }

    /**
     * Parse the given list of tokens
     *
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
     *
     * @param tokens the input tokens
     * @return an array of trees
     **/
    // FIXME: not using the start category ??
    // FIXME: Return collection
    public java.util.List<AbsynTree> parseToTrees(String[] tokens) throws ParseError {
        List<AbsynTree> v = new ArrayList();
        buildTrees(tokens, i -> v.add(i));
        return v;
    }



    public void buildTrees(String[] tokens, Consumer<AbsynTree> target) throws ParseError {
        ParseState.Chart chart = parse(tokens).chart;
        CncCat startcat = parse(tokens).startcat;
        int position = parse(tokens).getPosition();

        //log.fine("Building trees with start category " + (0, startCat, 0, length))
        /*(startCat.firstID until startCat.lastID + 1).flatMap( catID =>
                chart.getCategory(catID, 0, 0, length) match {
            case None =>Nil
            case Some(cat) => mkTreesForCat(cat, chart)
        }).toList */

        for (int catID = startcat.firstID(); catID <= startcat.lastID(); catID++) {
            Integer m = chart.getCategory(catID, 0, 0, position /* length */);
            if (m == null) continue;

            mkTreeForCat(catID, chart);

        }
    }

    /*
    def mkTreesForCat(cat : Int, chart:Chart):List[Tree] = {
    //log.fine("Making trees for category "+ cat)
    for {p <- chart.getProductions(cat).toList;
        t <- mkTreesForProduction(p, chart)}
    yield t
    }
    */
    public static List<AbsynTree> mkTreeForCat(int catID, ParseState.Chart chart) {
        ApplProduction[] pp = chart.getProductions(catID);
        List<AbsynTree> r = new ArrayList(pp.length);
        Stream.of(pp).map(p -> r.addAll( mkTreeForProduction(p, chart) ) );
        return r;
    }


    /*
    def mkTreesForProduction( p:Production, chart:Chart):List[Tree] = {
    if (p.domain.length == 0)
        List(new Application(p.function.name, Nil))
    else
        for (args <- listMixer( p.domain.toList.map(mkTreesForCat(_,chart)) ) )
            yield new Application(p.function.name, args)
    }
    */
    public static List<AbsynTree> mkTreeForProduction(ApplProduction p, ParseState.Chart chart) {

        final Function fname =  new Function( p.function.name );

        if (p.domain.length == 0) {

            List<List<AbsynTree>> pdm = IntStream.of(p.domain).mapToObj(
                    d -> mkTreeForCat(d, chart)
            ).collect(toList());

            return listMixer(pdm).stream()
                            .map( l -> Application.make(fname, l ) )
                            .collect(toList());
        }
        else {
            return newArrayList(
                    new Application( fname, null )
            );
        }

    }

    /*
    def listMixer(l:List[List[Tree]]):List[List[Tree]] = l match {
        case Nil =>Nil
        case List(subL) => subL.map(List(_))
        case head::tail => {
            for {first <- head ; then <- listMixer(tail)}
                yield first::then
        }
    }
    */
    public static List<List<AbsynTree>> listMixer(List<List<AbsynTree>> a) {
        if (a.isEmpty()) return Collections.EMPTY_LIST;

        final List<AbsynTree> head = a.get(0);
        if (a.size() == 1) return head.stream()
                .map( b -> newArrayList(b) ).collect(toList());

        List<List<AbsynTree>> r = new ArrayList( a.size() );
        r.add(head);
        r.addAll(listMixer(a.subList(1, a.size())));
        return r;
    }



    public java.util.List<AbsynTree> parseToTrees(String tokens) throws ParseError {
        return parseToTrees(tokenize(tokens));
    }

    /**
     * Parse the given string
     * uses a very basic tokenizer that split on whitespaces.
     *
     * @param phrase the input string
     * @return the corresponding parse-state
     **/
    public ParseState parse(String phrase) throws ParseError {
        return this.parse(tokenize(phrase));
    }

    /**
     * Parses the empty string
     * (usefull for completion)
     *
     * @param startcat the start category
     * @return the corresponding parse-state
     **/
    public ParseState parse() throws ParseError {
        return this.parse(EMPTY);
    }

}
