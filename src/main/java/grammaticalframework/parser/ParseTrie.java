package grammaticalframework.parser;

import org.magnos.trie.Trie;
import org.magnos.trie.TrieSequencer;

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
public class ParseTrie extends Trie<String[], Deque<ActiveItem>> {

    private static final org.magnos.trie.TrieSequencer<String[]> seq = new TrieSequencer<String[]>() {

        @Override public int matches(String[] sequenceA, int indexA, String[] sequenceB, int indexB, int count) {
            for (int i = 0; i < count; i++) {
                if (!sequenceA[indexA + i].equals( sequenceB[indexB + i] )) {
                    return i;
                }
            }
            return count;
        }

        @Override public int lengthOf(String[] sequence) {
            return sequence.length;
        }

        @Override public int hashOf(String[] sequence, int i) {
            return sequence[i].hashCode();
        }
    };

    public ParseTrie() {
        super(seq);
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
