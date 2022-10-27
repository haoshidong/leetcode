package 剑指offer.p051_p100;

public class p099_minPathSum {
    public int minPathSum(int[][] grid) {
        int len = grid[0].length;
        int[] dp = new int[len];
        dp[0] = grid[0][0];
        for (int i = 1; i < len; i++) {
            dp[i] = grid[0][i] + dp[i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < len; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[len - 1];
    }
}
