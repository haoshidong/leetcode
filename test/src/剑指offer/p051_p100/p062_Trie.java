package 剑指offer.p051_p100;

import jdk.internal.dynalink.beans.StaticClass;
import sun.text.normalizer.Trie;

public class p062_Trie {

    /**
     * Initialize your data structure here.
     */

    static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public p062_Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch-'a'] == null){
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch:word.toCharArray()) {
            if (node.children[ch-'a']==null){
                return false;
            }
            node = node.children[ch-'a'];
        }
        return node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch:prefix.toCharArray()) {
            if (node.children[ch-'a']==null){
                return false;
            }
            node = node.children[ch-'a'];
        }
        return true;
    }
}
