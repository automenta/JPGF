package grammaticalframework.parser;

import com.google.common.collect.HashMultimap;
import com.gs.collections.api.tuple.primitive.LongLongPair;
import com.gs.collections.impl.map.mutable.primitive.ObjectIntHashMap;
import com.gs.collections.impl.tuple.primitive.PrimitiveTuples;
import grammaticalframework.Utils;
import grammaticalframework.absyn.AbsynTree;
import grammaticalframework.absyn.Application;
import grammaticalframework.absyn.Function;
import grammaticalframework.reader.ApplProduction;
import grammaticalframework.reader.CncFun;
import grammaticalframework.reader.CoerceProduction;
import grammaticalframework.reader.Production;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

/**
 * Created by me on 8/7/15.
 */
public class ProductionChart {

    final HashMultimap<Integer, Production> prods = HashMultimap.create();
    int indexMax = Integer.MIN_VALUE;

    public ProductionChart(int nextCat) {
        this.indexMax = nextCat;
    }

    public void add(final Production... pp) {
        for (final Production p : pp) {
            int cc = p.getCategory();
            prods.put(cc, p);
            indexMax = Math.max(indexMax, cc + 1);
        }
    }

    public void forEachApplProduction(int id, Consumer<ApplProduction> recv) {
        prods.get(id).forEach(p -> uncoerce(p, recv));
    }

    /**
     * private def uncoerce(p : AnyProduction):Array[Production] = p match {
     * case (p:Production) => Array(p)
     * case (c:Coercion) => for (prod <- this.getProductions(c.getInitId()) ;
     * a <- this.uncoerce(prod) )
     * yield a
     * }
     */
    private void uncoerce(Production p, Consumer<ApplProduction> recv) {
        //2 subclass possibilities:
        if (p instanceof ApplProduction)
            recv.accept((ApplProduction) p);
        else {
            CoerceProduction c = (CoerceProduction) p;
            forEachApplProduction(c.getInitId(), prod -> uncoerce(prod, recv));
        }
    }

    public void addProduction(int cat, CncFun fun, int[] domain) {
        add(new ApplProduction(cat, fun, domain));
    }

    public List<AbsynTree> mkTreeForCat(int catID) {

        List<AbsynTree> r = new ArrayList();
        forEachApplProduction(catID, p ->
                        r.addAll(mkTreeForProduction(p))
        );
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
    private List<AbsynTree> mkTreeForProduction(ApplProduction p) {

        final Function fname = new Function(p.function.name);

        if (p.domain.length == 0) {

            List<List<AbsynTree>> pdm = IntStream.of(p.domain).mapToObj(
                    d -> mkTreeForCat(d)
            ).collect(toList());

            return Parser.listMixer(pdm).stream()
                    .map(l -> Application.make(fname, l))
                    .collect(toList());
        } else {
            return newArrayList(
                    new Application(fname, null)
            );
        }

    }




    final ObjectIntHashMap<LongLongPair> catKeeper = new ObjectIntHashMap();

//    /** **********************************************************************
//     *  Handling fresh categories
//     * */
//    private val categoryBookKeeper: HashMap[(Int, Int, Int, Int), Int]
//            = new HashMap[(Int, Int, Int, Int), Int]()
//

//    def hasCategory(oldCat:Int, cons:Int, begin:Int, end:Int):Boolean =
//            categoryBookKeeper.contains((oldCat, cons, begin, end))
//
//    def getCategory(oldCat:Int, cons:Int, begin:Int, end:Int):Option[Integer] =
//            categoryBookKeeper.get((oldCat, cons, begin, end)).map(i => i:Integer)
//
//    def generateFreshCategory(oldCat:Int, l:Int, j:Int, k:Int):Int = {
//        val cat = this.nextCat
//        this.nextCat += 1
//        categoryBookKeeper.update((oldCat, l, j, k), cat)
//        return cat
//    }

    /**
     *
     * @param oldCat
     * @param cons
     * @param begin
     * @param end
     * @return =1 if didnt exist
     */
    public int getCategory(int oldCat, int cons, int begin, int end) {
        return catKeeper.getIfAbsent(PrimitiveTuples.pair(
                Utils.pack(oldCat, cons), Utils.pack(begin, end)
        ),-1);
    }

    public int generateFreshCategory(int oldCat, int l, int j, int k) {
        int cat = indexMax++;

        catKeeper.put(PrimitiveTuples.pair(
                Utils.pack(oldCat, l), Utils.pack(j, k)
        ), cat);

        return cat;
    }

//    def getFreshCategory(oldCat:Int, l:Int, j:Int, k:Int):Int =
//            categoryBookKeeper.get((oldCat, l, j, k)) match {
//        case None => this.generateFreshCategory(oldCat, l, j, k)
//        case Some(c) => c
//    }
//

}
