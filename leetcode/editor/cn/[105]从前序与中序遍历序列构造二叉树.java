/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回
 * 其根节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 * <p>
 * <p>
 * Related Topics 树 数组 哈希表 分治 二叉树 👍 1788 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        //构建哈希映射，帮助我们快速定位根节点
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int p_s, int p_e, int i_s, int i_e) {
        if (p_s > p_e) {
            return null;
        }
        //前序遍历中第一个节点就是根节点
        TreeNode root = new TreeNode(preorder[p_s]);
        //定位根节点在中序遍历的下边
        int index = indexMap.get(root.val);
        //左子树的节点个数
        int size_left = index - i_s;
        //前序数组的[p_s + 1, _s + size_left]和中序数组的[i_s, index - 1]为root节点的左子树
        root.left = helper(preorder, inorder, p_s + 1, p_s + size_left, i_s, index - 1);
        //前序数组的[p_s + size_left + 1, p_e]和中序数组的[index + 1, i_e]为root节点的右子树
        root.right = helper(preorder, inorder, p_s + size_left + 1, p_e, index + 1, i_e);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
