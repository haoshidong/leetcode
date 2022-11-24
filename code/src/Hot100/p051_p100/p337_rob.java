package Hot100.p051_p100;

import 剑指offer.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class p337_rob {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0],result[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0],right[1]);
        result[1] = left[0] +right[0] + root.val;
        return result;
    }
}
