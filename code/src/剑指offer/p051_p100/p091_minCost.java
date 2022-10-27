package 剑指offer.p051_p100;

public class p091_minCost {
    public int minCost(int[][] costs) {
        int length = costs.length;
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] = Math.min(costs[i-1][1],costs[i-1][2])+costs[i][0];
            costs[i][1] = Math.min(costs[i-1][0],costs[i-1][2])+costs[i][1];
            costs[i][2] = Math.min(costs[i-1][1],costs[i-1][0])+costs[i][2];
        }
        int res = costs[length-1][0];
        for (int i = 0; i < 3; i++) {
            res = Math.min(res, costs[length-1][i]);
        }
        return res;
    }
}
