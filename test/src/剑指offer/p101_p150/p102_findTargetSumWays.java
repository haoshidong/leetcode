package 剑指offer.p101_p150;

public class p102_findTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int t;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1 || sum < target) {
            return 0;
        }
        t = (sum + target) / 2;
        int[] dp = new int[t + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = t; j >= nums[i-1]; j--) {
                    dp[j] += dp[j - nums[i - 1]];
            }
        }
        return dp[t];
    }
}
