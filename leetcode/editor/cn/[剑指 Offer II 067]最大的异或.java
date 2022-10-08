/**
给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。 

 

 
 
 示例 1： 
 
 

 
输入：nums = [3,10,5,25,2,8]
输出：28
解释：最大运算结果是 5 XOR 25 = 28. 

 示例 2： 

 
输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
输出：127
 

 

 提示： 

 
 1 <= nums.length <= 2 * 10⁵ 
 0 <= nums[i] <= 2³¹ - 1 
 

 

 
 注意：本题与主站 421 题相同： https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-
in-an-array/ 

 Related Topics 位运算 字典树 数组 哈希表 👍 47 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
