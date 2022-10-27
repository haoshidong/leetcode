package 剑指offer.p001_p050;

import 剑指offer.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class p050_pathSum {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, targetSum, map, 0);
    }

    private int dfs(TreeNode root, int targetSum, Map<Long, Integer> map, long path) {
        if (root == null) {
            return 0;
        }
        path += root.val;
        int ret = map.getOrDefault(path - targetSum, 0);
        map.put(path, map.getOrDefault(path, 0) + 1);
        ret += dfs(root.left, targetSum, map, path);
        ret += dfs(root.right, targetSum, map, path);
        map.put(path, map.get(path) - 1);

        return ret;
    }
}
