package grammaticalframework.parser;

import com.gs.collections.api.map.primitive.IntObjectMap;
import com.gs.collections.api.tuple.primitive.ObjectIntPair;
import com.gs.collections.impl.map.mutable.primitive.IntObjectHashMap;
import com.gs.collections.impl.tuple.primitive.PrimitiveTuples;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by me on 8/8/15.
 */
public class ActiveSet {

    //IntObjectHashMap<Multimap<>> store = new HashMap[Int, MultiMap[Int, (ActiveItem,Int)]]
    //LongObjectMap<ObjectIntPair<ActiveItem>> store = new LongObjectHashMap();
    IntObjectHashMap<IntObjectHashMap<Set<ObjectIntPair<ActiveItem>>>> store = new IntObjectHashMap();


    /*
    def add(cat:Int, cons:Int, item:ActiveItem, cons2:Int):Boolean =
            this.store.get(cat) match {
        case None => {
            val newMap = new HashMap[Int, Set[(ActiveItem,Int)]]
            with MultiMap[Int, (ActiveItem,Int)]
            newMap.addBinding(cons,(item,cons2))
            this.store.update(cat, newMap)
            return true
        }
        case Some(map) =>
            if (map.entryExists(cons, (item,cons2).equals))
            return false
        else {
            map.addBinding(cons, (item,cons2))
            return true
        }
    }*/

    public boolean add(int cat, int cons, ActiveItem item, int cons2) {

        final IntObjectHashMap<Set<ObjectIntPair<ActiveItem>>> a = store.getIfAbsent(cat, () -> {
            IntObjectHashMap<Set<ObjectIntPair<ActiveItem>>> r = new IntObjectHashMap<Set<ObjectIntPair<ActiveItem>>>();
            store.put(cat, r);
            return r;
        });

        Set<ObjectIntPair<ActiveItem>> s = a.getIfAbsent(cons, () -> {
            HashSet<ObjectIntPair<ActiveItem>> r = new HashSet<ObjectIntPair<ActiveItem>>();
            a.put(cons, r);
            return r;
        });

        return s.add(PrimitiveTuples.pair(item, cons2));
    }

    /*
def get(cat:Int):Iterator[(ActiveItem, Integer, Integer)] =
this.store.get(cat) match {
  case None => return Iterator.empty
  case Some(amap) => {
    for( k <- amap.keys.iterator ;
         (item, d) <- amap(k).iterator)
        yield (item, d:Integer, k:Integer)
  }
}
     */
    @FunctionalInterface
    public interface ActiveTripleConsumer {
        public void accept(ActiveItem a, int x, int r);
    }

    public void get(int cat, ActiveTripleConsumer recv) {
        IntObjectMap<Set<ObjectIntPair<ActiveItem>>> a1 = store.get(cat);
        if (a1 != null)
            a1.forEachKeyValue((k, v) -> v.forEach(s -> {
                recv.accept(s.getOne(), s.getTwo(), k);
            }));
    }


    /*
      def get(cat:Int, cons:Int):Seq[(ActiveItem,Integer)] =
        this.store.get(cat) match {
          case None => return Nil
          case Some(map) => map.get(cons) match {
            case None => return Nil
            case Some(s) => return s.map(x => (x._1, x._2:Integer)) toSeq
          }
        }

     */
    public Set<ObjectIntPair<ActiveItem>> get(int cat, int cons) {
        IntObjectMap<Set<ObjectIntPair<ActiveItem>>> a1 = store.get(cat);
        if (a1 == null)
            return null;
        return a1.get(cons);
    }
}
