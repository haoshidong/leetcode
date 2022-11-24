package 每日一题;

public class p808_soupServings {
    //动态规划+记忆化搜索
    private double[][] dp = new double[200][200];

    public double soupServings(int n) {
        //25ml为1份汤
        return n > 4800 ? 1 : dfs((n + 24) / 25, (n + 24) / 25);
    }

    private double dfs(int i, int j) {
        if (i <= 0 && j <= 0) {
            return 0.5;
        }
        if (i <= 0) {
            return 1.0;
        }
        if (j <= 0) {
            return 0;
        }
        //记忆化搜索，已经求出概率，则直接return，不需要在此经过ans的运算
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        double ans = 0.25 * (dfs(i - 4, j) + dfs(i - 3, j - 1) + dfs(i - 2, j - 2) + dfs(i - 1, j - 3));
        dp[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int n = 2000;
        double ans = new p808_soupServings().soupServings(n);
        System.out.println(ans);
    }
}
