package 每日一题;

public class p813_largestSumOfAverages {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        //前缀和数组
        double[] sum = new double[n + 1];
        //初始化前缀和数组
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        //动态规划数组f[i][j]表示nums中前i个数分成j组所能得到的最大各组平均值之和
        double[][] f = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                //前i个数只分一组
                if (j == 1) {
                    f[i][1] = sum[i] / i;
                    //前i个数分成2组或以上
                } else {
                    //l为最后一组的起始下标，第1~l个数分成j-1组，l~i分成1组
                    for (int l = 2; l <= i; l++) {
                        f[i][j] = Math.max(f[i][j], f[l - 1][j - 1] + (sum[i] - sum[l - 1]) / (i - l + 1));
                    }
                }
            }
        }
        return f[n][k];
    }
}
