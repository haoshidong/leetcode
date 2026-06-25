package new_hot100;

import java.util.Arrays;

class P62_UniquePaths {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        Arrays.fill(dp[0], 1);
//        for (int i = 1; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                dp[i][j] = dp[i-1][j] + (j-1>=0 ? dp[i][j-1] : 0);
//            }
//        }
//        return dp[m-1][n-1];
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n ; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n];
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P62_UniquePaths().new Solution();
        int[][] dp = new int[3][7];
        Arrays.fill(dp[0], 1);
        System.out.println(Arrays.deepToString(dp));
    }
}