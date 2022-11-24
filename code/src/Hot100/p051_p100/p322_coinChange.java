package Hot100.p051_p100;

import java.util.Arrays;

public class p322_coinChange {
    public int coinChange(int[] coins, int amount) {
        //动态规划 dp[i]表示凑出总额为i的硬币需要的最少数目
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

        /*
        //动态规划 dp[i][j]表示前i枚硬币凑成总和为amount的硬币总数量
        //优化，dp[i][j]只取决于dp[i-1]这一行前j个数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                for (int j = 1; j * coin < i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * coin] + j);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];*/
    }
}
