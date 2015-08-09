package grammaticalframework.parser;

import org.magnos.trie.Trie;
import org.magnos.trie.TrieMatch;
import org.magnos.trie.TrieSequencerCharSequence;

import java.util.*;

/**
 * The ParseTries are used to keep track of the possible next symbols.
 * It is a trie where the symbol (edge labels) are string (words) and the values (node) are agendas
 * (stacks of ActiveItems)
 * The parse tries is used in the parsing algorithm when a dot is before a token. Then the dot is
 * moved after the tokens and the resulting active item is added to the trie (to the agenda indexed by
 * the words of the token.)
 * Then the scan operation is a simple lookup in the trie...
 * The trie is also used for predictions.
 * In gf, a token in a rule can consist of multiple words (separated by a whitespace), thus the trie is
 * needed and cannot be replaced by a simple map.
 *
 * @param value the value at this node.
 **/
public class ParseTrie  {

    //TODO use a String[] impl like we tried originally
    final Trie<String, Collection<ActiveItem>> data = new Trie(new TrieSequencerCharSequence());

    //Map<List<String>,ArrayDeque<ActiveItem>> data = new HashMap();
    //Multimap<List<String>,ArrayDeque<ActiveItem>> data = HashMultimap.create();

    public static String key(String[] s) {
        return String.join(" ", s);
    }

    public Collection<ActiveItem> get(String[] substring) {
        //System.out.println("get: " + Arrays.asList(substring) + " " + data.get(key(substring)));
        return data.get(key(substring), TrieMatch.STARTS_WITH);
    }

    public Collection<ActiveItem> get(String substring) {
        //System.out.println("get: " + substring + " " + data.get(substring));
        return data.get(substring, TrieMatch.STARTS_WITH);
    }

    public void put(String[] tokens, Collection<ActiveItem> ai) {
        //System.out.println("put: " + Arrays.asList(tokens) + " -> " + ai);
        Collection<ActiveItem> exists;
        data.put(key(tokens), ai);
    }

    public Set<Map.Entry<String, Collection<ActiveItem>>> entries(String s) {
        return data.entrySet(s, TrieMatch.STARTS_WITH);
    }


//
//        def add(keys: List[String], value: Stack[ActiveItem]): Unit =
//        keys match {
//        case Nil => this.value = value
//        case x :: l => this.child.get(x) match {
//        case None => {
//        val newN = new ParseTrie
//        newN.add(l, value)
//        this.child.update(x, newN)
//        }
//        case Some(n) => n.add(l, value)
//        }
//        }
//
//        def lookup(key: Seq[String]): Option[Stack[ActiveItem]] =
//        this.lookup(key.toList)
//
//        def lookup(key: Array[String]): Option[Stack[ActiveItem]] =
//        this.lookup(key.toList)
//
//        def lookup(key: java.util.List[String]): Option[Stack[ActiveItem]] =
//        lookup( key.asScala )
//
//        def lookup(key: List[String]): Option[Stack[ActiveItem]] =
//        getSubTrie(key) match {
//        case None => None
//        case Some(t) => Some(t.value)
//        }
//
//
//
//        def lookup(key: String): Option[Stack[ActiveItem]] =
//        this.lookup(key :: Nil)
//
//        def getSubTrie(key: List[String]): Option[ParseTrie] =
//        key match {
//        case Nil => Some(this)
//        case x :: l => this.child.get(x) match {
//        case None => None
//        case Some(n) => n.getSubTrie(l)
//        }
//        }
//
//        def getSubTrie(key: String): Option[ParseTrie] =
//        this.getSubTrie(key :: Nil)
//
//        def predict(): Array[String] = this.child.keySet.toArray
//
//        override def toString() = this.toStringWithPrefix("")
//
//        def toStringWithPrefix(prefix: String): String = {
//        prefix + "<" + this.value + ">" +
//        this.child.keys.map(k =>
//        prefix + k.toString + ":\n" +
//        this.child(k).toStringWithPrefix(prefix + "  ")
//        ).foldLeft("")((a: String, b: String) => a + "\n" + b)
//        }
//        }

}
