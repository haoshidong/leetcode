package 每日一题;

public class p799_champagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        //动态规划
        //dp[i][j]表示第i行第j列瓶子所流过的水量，剩余水量为Math.min(dp[i][j], 1)
        double[][] dp = new double[query_row + 10][query_row + 10];
        //第一个杯子的流经水量为poured
        dp[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j]<=1) continue;
                dp[i + 1][j] += (dp[i][j] - 1) / 2;
                dp[i + 1][j + 1] += (dp[i][j] - 1) / 2;
            }
        }
        return Math.min(dp[query_row][query_glass], 1);
    }

}
