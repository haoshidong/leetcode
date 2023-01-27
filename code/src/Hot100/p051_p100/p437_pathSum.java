package Hot100.p051_p100;

import 剑指offer.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class p437_pathSum {
    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, 1);
        dfs(root, targetSum, map, 0l);
        return ans;
    }

    private void dfs(TreeNode root, int targetSum, Map<Long, Integer> map, Long pathSum) {
        if (root != null) {
            pathSum += root.val;
            if (map.containsKey(pathSum - targetSum)) {
                ans += map.get(pathSum - targetSum);
            }
            map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
            dfs(root.left, targetSum, map, pathSum);
            dfs(root.right, targetSum, map, pathSum);
            if (map.get(pathSum) > 1) {
                map.put(pathSum, map.get(pathSum) - 1);
            } else {
                map.remove(pathSum);
            }
        }
    }
}
