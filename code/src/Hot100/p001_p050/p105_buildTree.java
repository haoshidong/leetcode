package Hot100.p001_p050;

import 剑指offer.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p105_buildTree {
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

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        new p105_buildTree().buildTree(preorder, inorder);
    }
}
