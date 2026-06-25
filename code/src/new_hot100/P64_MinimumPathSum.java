package new_hot100;

import java.util.Arrays;

class P64_MinimumPathSum {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = grid[0][0];
        for (int j = 2; j <= n; j++) {
            dp[j] = dp[j-1] + grid[0][j-1];
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.min(dp[j-1], dp[j]) + grid[i-1][j-1];
            }
        }
        return dp[n];
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P64_MinimumPathSum().new Solution(); 
    }
}