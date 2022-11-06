package Hot100.p001_p050;

public class p55_canJump {
    public boolean canJump(int[] nums) {
        //动态规划
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i]) {
                if (i + nums[i] >= nums.length) return true;
                while (nums[i] > 0 && !dp[i + nums[i]]) {
                    dp[i + nums[i]] = true;
                    nums[i]--;
                }
            }else return false;
        }
        return true;
    }
}
