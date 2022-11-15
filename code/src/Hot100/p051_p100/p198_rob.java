package Hot100.p051_p100;

public class p198_rob {
    public int rob(int[] nums) {
        //优化动态规划
        int prev = 0, cur = 0;
        for (int i : nums) {
            int temp = Math.max(cur, prev + i);
            prev = cur;
            cur = temp;
        }
        return cur;

        /*//动态规划
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < n; i++) {
            //状态转移方程
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];*/
    }
}
