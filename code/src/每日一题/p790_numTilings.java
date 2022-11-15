package 每日一题;

public class p790_numTilings {
    private static final long MOD = (long) 1e9 + 7;

    public int numTilings(int n) {
        long[][] dp = new long[2][4];
        dp[1] = new long[]{1, 0, 0, 1};
        dp[0] = new long[]{1, 1, 1, 2};
        for (int i = 3; i <= n; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][3];
            dp[i % 2][1] = (dp[(i - 1) % 2][0] + dp[(i - 1) % 2][2]) % MOD;
            dp[i % 2][2] = (dp[(i - 1) % 2][0] + dp[(i - 1) % 2][1]) % MOD;
            dp[i % 2][3] = (dp[(i - 1) % 2][0] + dp[(i - 1) % 2][1] + dp[(i - 1) % 2][2] + dp[(i - 1) % 2][3]) % MOD;
        }
        return (int) (dp[n % 2][3] % MOD);
    }
}
