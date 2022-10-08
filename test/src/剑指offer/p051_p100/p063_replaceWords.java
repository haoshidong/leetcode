package 剑指offer.p051_p100;

import 剑指offer.TrieNode;

import java.util.List;

public class p063_replaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = buildTrie(dictionary);
        StringBuilder builder = new StringBuilder();

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String prefix = findPrefix(root, words[i]);
            if (!prefix.isEmpty()){
                words[i] = prefix;
            }
        }
        return String.join(" ",words);
    }

    private String findPrefix(TrieNode root, String word) {
        TrieNode node = root;
        StringBuilder builder = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null || node.isWord == true) {
                break;
            }
            builder.append(ch);
            node = node.children[ch - 'a'];
        }
        return node.isWord ? builder.toString() : "";
    }

    private TrieNode buildTrie(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
        return root;
    }


}
