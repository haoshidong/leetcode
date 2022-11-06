package Hot100.p001_p050;

public class p53_maxSubArray {
    public int maxSubArray(int[] nums) {
        //优化的动态规划
        int dp = nums[0];
        int maxSum = dp;
        for (int i = 1; i < nums.length; i++) {
            //若以i-1为末尾的子序列最大和小于0，则以i结尾的子序列最大和为nums[i]，否则为nums[i]+dp。
            dp = dp < 0 ? nums[i] : nums[i] + dp;
            maxSum = Math.max(maxSum, dp);
        }
        return maxSum;
    }
}
