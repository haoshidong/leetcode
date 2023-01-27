package Hot100.p051_p100;

import 剑指offer.TreeNode;

public class p543_diameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int ans = 0;
        ans = dfs(root);
        return ans > max ? ans : max;
    }

    private int dfs(TreeNode root) {
        if (root != null) {
            int l_max = dfs(root.left);
            int r_max = dfs(root.right);
            max = Math.max(max, l_max + r_max + 2);
            return l_max > r_max ? l_max + 1 : r_max + 1;
        }
        return -1;
    }
}
