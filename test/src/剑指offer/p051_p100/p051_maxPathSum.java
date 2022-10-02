package 剑指offer.p051_p100;

import 剑指offer.TreeNode;

public class p051_maxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //计算左子节点的路径最大值
        int leftSum = Math.max(dfs(root.left),0);
        //计算右子节点的路径最大值
        int rightSum = Math.max(dfs(root.right),0);
        //当前节点为拐点的路径值
        int cur = root.val + leftSum + rightSum;
        //更新答案
        maxSum = Math.max(maxSum,cur);
        //返回以当前节点为头的路径最大值
        return root.val + Math.max(leftSum, rightSum);
    }
}
