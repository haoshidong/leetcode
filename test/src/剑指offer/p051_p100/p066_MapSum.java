package 剑指offer.p051_p100;


public class p066_MapSum {

    public class TrieNode {

        public TrieNode[] children;
        public boolean isWord;
        public int value;

        public TrieNode() {
            children = new TrieNode[26];
        }

    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public p066_MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.value = val;
        node.isWord = true;

    }

    public int sum(String prefix) {
        int[] sum = {0};
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                return sum[0];
            }
            node = node.children[ch - 'a'];
        }
        dfs(node,sum);

        return sum[0];
    }

    private void dfs(TrieNode root, int[] sum) {
        if (root != null) {
            if (root.isWord){
                sum[0] += root.value;
            }
            for (TrieNode child : root.children) {
                dfs(child,sum);
            }
        }
    }
}
