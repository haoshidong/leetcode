/**
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 897 题相同： https://leetcode-cn.com/problems/increasing-order-search-
 * tree/
 * <p>
 * Related Topics 栈 树 深度优先搜索 二叉搜索树 二叉树 👍 43 👎 0
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
    TreeNode prev = null;
    TreeNode first = null;
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return first;
        /*Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;
        while (cur!= null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();

            if (prev!=null){
                prev.right = cur;
            }else {
                first = cur;
            }

            prev = cur;
            cur.left = null;
            cur = cur.right;
        }
        return first;*/
    }

    private void dfs(TreeNode root) {
        if (root!=null){
            dfs(root.left);
            if (prev!=null){
                prev.right = root;
            }else {
                first = root;
            }
            prev = root;
            root.left = null;
            dfs(root.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
