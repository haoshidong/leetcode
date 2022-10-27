package 剑指offer;

import 剑指offer.p051_p100.p062_Trie;

public class TrieNode {

    public TrieNode[] children;
    public boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
    }

}
