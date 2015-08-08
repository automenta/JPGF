package grammaticalframework.parser;

import grammaticalframework.reader.CncFun;
import grammaticalframework.reader.Symbol;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by me on 8/8/15.
 */
public class ActiveItem {

    public final int begin;
    public final int category;
    public final CncFun function;
    public final int[] domain;
    public final int constituent;
    public final int position;
    private final int hash;

    /*
    (val begin: Int,
        val category: Int,
        val function: CncFun,
        val domain: Array[Int],
        val constituent: Int,
        val position: Int)
     */
    public ActiveItem(int begin, int category, CncFun function, int[] domain,
                      int constituent, int position) {
        this.begin = begin;
        this.category = category;
        this.function = function;
        this.domain = domain;
        this.constituent = constituent;
        this.position = position;
        this.hash = Objects.hash(begin, category, function, domain, constituent, position);
    }



    /*
    // get next symbol
    def nextSymbol(): Option[Symbol] =
            if (position < function.sequence(constituent).length) {
        val symbol = function.sequence(constituent).symbol(position)
        return Some(symbol)
    }
    else
            return None
    */


    /*
            override def equals(o: Any): Boolean = o match {
                case (o: ActiveItem) => this.begin == o.begin &&
                        this.category == o.category &&
                        this.function == o.function && // CncFun,
                        this.domain.deep.equals(o.domain.deep) &&
                        this.constituent == o.constituent &&
                        this.position == o.position
                case _ => false
            }
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof ActiveItem) {
            ActiveItem a = (ActiveItem) obj;
            return a.category == category &&
                    a.function == function /*toEquals?*/ &&
                    a.constituent == constituent &&
                    a.position == position &&
                    Arrays.equals(a.domain, domain);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    public boolean hasNextSymbol() {
        return position < function.sequence(constituent).length();
    }


    /* // get next symbol
    def nextSymbol2(): Symbol =
            if (position < function.sequence(constituent).length) {
        val symbol = function.sequence(constituent).symbol(position)
        return symbol
    }
    else
            return null*/
    public Symbol nextSymbol2() {
        return function.sequence(constituent).symbol(position);
    }


    /*
    override def toString() =
                        "[" + this.begin + ";" +
                                this.category + "->" + this.function.name +
                                "[" + this.domainToString + "];" + this.constituent + ";" +
                                this.position + "]"

                def domainToString(): String = {
                        val buffer = new StringBuffer()
                for (d <- domain) {
                    buffer.append(d.toString)
                }
                buffer.toString
                }
     */

    @Override
    public String toString() {
        return "[" + this.begin + ";" +
                this.category + "->" + this.function.name +
                "[" + Arrays.toString(domain) + "];" + this.constituent + ";" +
                this.position + "]";
    }


}
