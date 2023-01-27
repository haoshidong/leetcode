package Hot100.p051_p100;

import 剑指offer.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class p337_rob {
    /**
     * int[] res = new int[2] 0 代表不偷，1 代表偷 任何一个节点能偷到的最大钱的状态可以定义为
     *      1、当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
     *      2、当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     */
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
        //当前节点选择不偷时，能偷到的最大钱数
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0],right[1]);
        //当前节点选择偷时，能偷到的最大钱数
        result[1] = left[0] +right[0] + root.val;
        return result;
    }
}
