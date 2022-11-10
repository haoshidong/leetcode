package Hot100.p001_p050;

public class p121_maxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n<2){
            return 0;
        }
        int minPrice = prices[0];
        int max_profit = 0;
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            max_profit = Math.max(max_profit, prices[i]-minPrice);
        }
        return max_profit;
    }
}
