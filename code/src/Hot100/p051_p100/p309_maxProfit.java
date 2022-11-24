package Hot100.p051_p100;

public class p309_maxProfit {
    public int maxProfit(int[] prices) {
        //动态规划3 2的优化
        int noHold = 0, hold = -1 * prices[0], holdSale = 0;
        for (int i = 1; i < prices.length; i++) {
            int backup = noHold;
            noHold = Math.max(backup, holdSale);
            holdSale = hold + prices[i];
            hold = Math.max(backup - prices[i], hold);
        }
        return Math.max(noHold, holdSale);


        /*
        //动态规划2 dp[i][]表示当天的收益
        *//*
        dp[i][0] 当天不持股时的收益
        dp[i][1] 当天持股。。。
        dp[i][2] 当天持股，但卖出。。。
         *//*
        int[][] dp = new int[prices.length][3];
        dp[0][1] = -1 * prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = dp[i][1] + prices[i];
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);*/

        /*
        //动态规划1 dp[i]表示第i天所能得到的！最大!收益（第i天可能卖出或不卖出）
        int n = prices.length;
        int[] dp = new int[n];
        //i为卖出的时期
        for (int i = 1; i < n; i++) {
            int profit = 0;
            //j为买入的时期，买入时期小于卖出时期
            for (int j = 0; j < i; j++) {
                if (prices[i] > prices[j]) {
                    profit = j > 1 ? Math.max(profit, dp[j - 2] + prices[i] - prices[j])
                            : Math.max(profit, prices[i] - prices[j]);
                }
            }
            dp[i] = Math.max(profit, dp[i - 1]);
        }
        return dp[n - 1];*/
    }
}
