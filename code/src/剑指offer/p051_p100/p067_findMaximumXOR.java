package p051_p100;


public class p067_findMaximumXOR {

    public class TrieNode {

        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[2];
        }

    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = buildTrie(nums);
        int max = 0;
        for (int num : nums) {
            TrieNode node = root;
            int XOR = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[1 - bit] != null) {
                    XOR = (XOR << 1) + 1;
                    node = node.children[1 - bit];
                } else {
                    XOR = XOR << 1;
                    node = node.children[bit];
                }
            }
            max = Math.max(max, XOR);
        }
        return max;
    }

    private TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }
        return root;
    }
}
