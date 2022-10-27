package 剑指offer.p051_p100;

public class p092_minFlipsMonoIncr {
    public int minFlipsMonoIncr(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int[][] dp = new int[2][2];
        char ch = s.charAt(0);
        dp[0][0] = ch == '0' ? 0 : 1;
        dp[1][0] = ch == '1' ? 0 : 1;
        for (int i = 1; i < length; i++) {
            ch = s.charAt(i);
            int prev0 = dp[0][(i - 1) % 2];
            int prev1 = dp[1][(i - 1) % 2];
            dp[0][i % 2] = prev0 + (ch == '0' ? 0 : 1);
            dp[1][i % 2] = Math.min(prev0, prev1) + (ch == '1' ? 0 : 1);
        }
        return Math.min(dp[0][(length - 1) % 2], dp[1][(length - 1) % 2]);
    }
}
