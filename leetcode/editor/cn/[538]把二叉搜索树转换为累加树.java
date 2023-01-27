/**
给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 
node.val 的值之和。 

 提醒一下，二叉搜索树满足下列约束条件： 

 
 节点的左子树仅包含键 小于 节点键的节点。 
 节点的右子树仅包含键 大于 节点键的节点。 
 左右子树也必须是二叉搜索树。 
 

 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-
sum-tree/ 相同 

 

 示例 1： 

 

 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 

 示例 2： 

 输入：root = [0,null,1]
输出：[1,null,1]
 

 示例 3： 

 输入：root = [1,0,2]
输出：[3,3,2]
 

 示例 4： 

 输入：root = [3,2,4,1]
输出：[7,9,4,10]
 

 

 提示： 

 
 树中的节点数介于 0 和 10⁴ 之间。 
 每个节点的值介于 -10⁴ 和 10⁴ 之间。 
 树中的所有值 互不相同 。 
 给定的树为二叉搜索树。 
 

 Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 830 👎 0

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
    private int path = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    /**
     * 右中左的顺序更改节点值
     * 对于每个节点，想要获取的数据：右节点的路径和
     *            想要传给上一层的数据：当前节点的路径和+所有左孩子的和
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root != null) {
            //想要获取的数据
            path = dfs(root.right);
            //更新当前节点的值
            root.val = path + root.val;
            //更新路径和
            path = root.val;
            //递归左孩子
            dfs(root.left);
        }
        //返回给上层想要的数据，若节点不存在，则path值不变
        return path;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
