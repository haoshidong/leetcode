package Hot100.p001_p050;

public class p70_climbStairs {
    public int climbStairs(int n) {
        //动态规划
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 2;
        if (n<3){
            return dp[n-1];
        }
        for (int i = 2; i < n; i++) {
            dp[i%3] = dp[(i-1)%3] + dp[(i-2)%3];
        }
        return dp[(n-1)%3];
    }
}
