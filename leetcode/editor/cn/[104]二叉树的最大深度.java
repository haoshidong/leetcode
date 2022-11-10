/**
给定一个二叉树，找出其最大深度。 

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 

 说明: 叶子节点是指没有子节点的节点。 

 示例： 给定二叉树 [3,9,20,null,null,15,7]， 

     3
   / \
  9  20
    /  \
   15   7 

 返回它的最大深度 3 。 

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1424 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        int layer = 0;
        queue1.offer(root);
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
            if (queue1.isEmpty()){
                layer++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return layer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
