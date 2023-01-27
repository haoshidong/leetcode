package Hot100.p051_p100;

public class p494_findTargetSumWays {
    int ans = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return ans;
    }

    private void dfs(int[] nums, int target, int i, int path) {
        if (i <= nums.length) {
            if (i == nums.length && path == target) {
                ans++;
            } else if (i < nums.length) {
                dfs(nums, target, i + 1, path + nums[i]);
                dfs(nums, target, i + 1, path - nums[i]);
            }
        }
    }
}
