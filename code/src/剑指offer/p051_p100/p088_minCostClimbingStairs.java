package 剑指offer.p051_p100;

public class p088_minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        for (int i = 2; i < len; i++) {
            cost[i] = Math.min(cost[i - 2], cost[i - 1]) + cost[i];
        }
        return Math.min(cost[len - 1], cost[len - 2]);
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        int minCost = new p088_minCostClimbingStairs().minCostClimbingStairs(cost);
        System.out.println(minCost);
    }
}
