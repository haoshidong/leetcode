package 剑指offer.p101_p150;

public class p101_canPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (!dp[j] && j > nums[i - 1]) {
                    dp[j] = dp[j - nums[i - 1]];    //第i个数在数组的下标为i-1
                }
            }
        }
        return dp[target];
    }
}
