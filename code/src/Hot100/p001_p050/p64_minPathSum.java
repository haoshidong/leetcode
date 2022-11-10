package Hot100.p001_p050;

public class p64_minPathSum {
    public int minPathSum(int[][] grid) {
        //动态规划
        int[] dp = new int[grid[0].length];
        //初始化第一行
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[i] = dp[i-1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                dp[j] = Math.min(dp[j-1],dp[j])+grid[i][j];
            }
        }
        return dp[grid[0].length-1];
    }
}
