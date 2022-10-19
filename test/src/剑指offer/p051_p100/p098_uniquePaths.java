package 剑指offer.p051_p100;

public class p098_uniquePaths {
    public int uniquePaths(int m, int n) {
        if (m<n){
            return uniquePaths(n,m);
        }
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            dp[0] = 1;
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}
