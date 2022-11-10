/**
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 

 

 示例 1： 
 
 
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]
 

 示例 2： 

 
输入：root = [1]
输出：[[1]]
 

 示例 3： 

 
输入：root = []
输出：[]
 

 

 提示： 

 
 树中节点数目在范围 [0, 2000] 内 
 -1000 <= Node.val <= 1000 
 

 Related Topics 树 广度优先搜索 二叉树 👍 1506 👎 0

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        ans.add(new ArrayList<>(list));
        while (!queue1.isEmpty()) {
            TreeNode ndoe = queue1.poll();
            if (ndoe.left != null) {
                queue2.offer(ndoe.left);
            }
            if (ndoe.right != null) {
                queue2.offer(ndoe.right);
            }
            if (queue1.isEmpty() && !queue2.isEmpty()) {
                queue1 = queue2;
                list = new ArrayList<>();
                for (TreeNode tn : queue1) {
                    list.add(tn.val);
                }
                ans.add(new ArrayList<>(list));
                queue2 = new LinkedList<>();
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
