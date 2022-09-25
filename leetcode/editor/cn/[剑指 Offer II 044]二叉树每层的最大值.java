/**
给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 

 

 示例1： 

 
输入: root = [1,3,2,5,3,null,9]
输出: [1,3,9]
解释:
          1
         / \
        3   2
       / \   \  
      5   3   9 
 

 示例2： 

 
输入: root = [1,2,3]
输出: [1,3]
解释:
          1
         / \
        2   3
 

 示例3： 

 
输入: root = [1]
输出: [1]
 

 示例4： 

 
输入: root = [1,null,2]
输出: [1,2]
解释:      
           1 
            \
             2     
 

 示例5： 

 
输入: root = []
输出: []
 

 

 提示： 

 
 二叉树的节点个数的范围是 [0,10⁴] 
 
 -2³¹ <= Node.val <= 2³¹ - 1 
 

 

 
 注意：本题与主站 515 题相同： https://leetcode-cn.com/problems/find-largest-value-in-each-
tree-row/ 

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 31 👎 0

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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root!= null){
            queue1.offer(root);
        }
        List<Integer> result = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while (!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            max = Math.max(max,node.val);
            if (node.left!=null){
                queue2.offer(node.left);
            }
            if (node.right!=null){
                queue2.offer(node.right);
            }
            if (queue1.isEmpty()){
                result.add(max);
                max = Integer.MIN_VALUE;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
