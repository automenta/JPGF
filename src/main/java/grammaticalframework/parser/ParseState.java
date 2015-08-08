/* ParseState.java
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
package grammaticalframework.parser;


import com.gs.collections.api.tuple.primitive.ObjectIntPair;
import grammaticalframework.reader.*;
import org.grammaticalframework.pgf.ParseError;

import java.util.Set;
import java.util.Stack;
import java.util.Vector;

//import scala.collection.immutable.List;


public class ParseState {

    //final private Concrete grammar;

    public final CncCat startcat;

    public final ProductionChart chart = new ProductionChart(100); // TODO 100 is a bad value...

    // 'active' is the set of all the S_k's, holding the active items which are not
    // on the agenda.
    private final Vector<ActiveSet> active = new Vector();

    int position = 0;

    private ParseTrie trie = new ParseTrie();
    private Stack<ActiveItem> agenda = new Stack();

    public ParseState(final Concrete grammar, final String abstractStartcat)
            throws ParseError {
        //this.grammar = grammar;
        try {
            this.startcat = grammar.concreteCats(abstractStartcat);
        } catch (Concrete.UnknownCategory e) {
            throw new ParseError("Invalid start category " + abstractStartcat);
        }
        // Adding all grammar productions in the chart

        chart.add(grammar.productions());

        // We create an initial agenda of all prodution with the
        // start category as left-hand-side.
        for (int id = startcat.firstID(); id <= startcat.lastID(); id++) {
            final int ID = id;
            chart.forEachApplProduction(ID, prod -> {
                ActiveItem it = new ActiveItem(0, ID, prod.function, prod.domain, 0, 0);
                agenda.push(it);
            });
        }

        // Finally we process this agenda
        compute();
    }

    private void compute() {
        // We have to create a new set S_k where k is the current position
        active.add(new ActiveSet());
        while (!agenda.isEmpty()) {
            processActiveItem(agenda.pop());
        }
    }

    public int getPosition() {
        return position;
    }

    private void processActiveItem(final ActiveItem item) {
        final int j = item.begin;
        final int A = item.category;
        final CncFun f = item.function;
        final int[] B = item.domain;
        final int l = item.constituent;
        final int p = item.position;


        if (!item.hasNextSymbol()) {
            // ------------------------- at the end --------------------------
            //log.finest("Case at the end")
            int catt = chart.getCategory(A, l, j, this.position);
            if (catt != -1) {
                int n = chart.getCategory(A, l, j, this.position);
                if (n!=-1) {
                    //Iterator<Tuple3<ActiveItem, Integer, Integer>> oldactive =
                    active.get(this.position).get(n, (a, x, r) -> {
                        //scala.Tuple3<ActiveItem, Integer, Integer> t = oldactive.next();
                        //int r = t._3().intValue();
                        // (xprime, dprime, r)
                        ActiveItem i = new ActiveItem(this.position,
                                n, f, B, r,
                                0);
                        //log.finest("Adding "+ i + " to the agenda")
                        agenda.push(i);
                    });
                    chart.addProduction(n, f, B);
                }
            } else {

                int N = chart.generateFreshCategory(A, l, j, this.position);

                Set<ObjectIntPair<ActiveItem>> s = active.get(j).get(A, l);
                if (s!=null) {
                    for (ObjectIntPair<ActiveItem> t : s) {
                        ActiveItem ip = t.getOne();
                        int d = t.getTwo();
                        //log.finest("combine with " + ip + " (" + d + ")")
                        int[] domain = ip.domain.clone();
                        domain[d] = N;
                        ActiveItem i = new ActiveItem(ip.begin, ip.category,
                                ip.function, domain,
                                ip.constituent, ip.position + 1);
                        //log.finest("Adding " + i + " to the agenda")
                        agenda.push(i);
                    }
                }
                chart.addProduction(N, f, B);
            }
        } else {
            Symbol next = item.nextSymbol2();
            if (next instanceof ToksSymbol) {
                // ------------------------- before s∈ T -------------------------
                ToksSymbol tok = (ToksSymbol) next;
                //log.fine("Case before s∈ T")
                String[] tokens = tok.tokens();
                ActiveItem i = new ActiveItem(j, A, f, B, l, p + 1);
                // SCAN
                // this.trie.add(tokens, i)
                Stack<ActiveItem> option = this.trie.lookup(tokens);
                if (option.isEmpty()) {
                    Stack<ActiveItem> a = new Stack();
                    a.push(i);
                    this.trie.add(tokens, a);
                } else {
                    option.push(i);
                }
            } else {
                // ------------------------- before <d,r> -----------------------
                ArgConstSymbol arg = (ArgConstSymbol) next;
                //log.finest("Case before <d,r>")
                int d = arg.arg();
                int r = arg.cons();
                int Bd = item.domain[d];
                if (this.active.get(this.position).add(Bd, r, item, d)) {
                    chart.forEachApplProduction(Bd, prod -> {
                        ActiveItem it = new ActiveItem(this.position, Bd, prod.function,
                                prod.domain, r, 0);
                        agenda.push(it);
                    });
                }
                Integer oCat = chart.getCategory(Bd, r, this.position, this.position);
                if (oCat != null) {
                    int catN = oCat.intValue();
                    int[] newDomain = B.clone();
                    newDomain[d] = catN;
                    ActiveItem it = new ActiveItem(j, A, f, newDomain, l, p + 1);
                    //log.finest("Adding " + it + " to the agenda");
                    agenda.push(it);
                }
            }
        }
    }

    /**
     * returns the set of possible next words
     */
    public String[] predict() {
        return this.trie.predict();
    }

    public boolean scan(String token) {
        ParseTrie option = this.trie.getSubTrie(token);
        if (option == null)
            return false;
        else {
            ParseTrie newTrie = option;

            Stack<ActiveItem> option2 = newTrie.lookup();
            if (option2 == null)
                return false;
            else {
                Stack<ActiveItem> agenda = option2;
                this.trie = newTrie;
                this.position += 1;
                this.agenda = agenda;
                this.compute();
                //log.finer(this.trie.toString)
                return true;
            }
        }
    }

    public String toString() {
        return "= ParseState =\n" +
                "== Chart ==\n" +
                this.chart.toString() +
                "== Trie ==\n" +
                this.trie.toString();
    }


}
