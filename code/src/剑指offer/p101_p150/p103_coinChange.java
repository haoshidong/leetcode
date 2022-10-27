package 剑指offer.p101_p150;

import java.util.Arrays;

public class p103_coinChange {
    public int coinChange(int[] coins, int amount) {
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
        /*int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = amount; j > 0; j--) {
                for (int k = 1; k * coins[i - 1] <= j; k++) {
                    dp[j] = Math.min(dp[j], dp[j - k * coins[i - 1]] + k);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];*/
    }
}
