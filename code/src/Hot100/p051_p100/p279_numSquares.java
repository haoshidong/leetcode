package Hot100.p051_p100;

public class p279_numSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        int num = (int) Math.sqrt(n);
        for (int i = 2; i <= num; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - i * i >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}
