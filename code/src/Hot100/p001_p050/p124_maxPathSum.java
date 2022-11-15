package Hot100.p001_p050;

import 剑指offer.TreeNode;

public class p124_maxPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l_max = Math.max(dfs(root.left), 0);
        int r_max = Math.max(dfs(root.right), 0);
        maxSum = Math.max(maxSum, l_max + r_max + root.val);
        return root.val + Math.max(l_max, r_max);
    }
}
