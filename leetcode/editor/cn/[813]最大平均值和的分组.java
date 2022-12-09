/**
给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。 分数 由每个子数组内的平均值的总和构成。 

 注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。 

 返回我们所能得到的最大 分数 是多少。答案误差在 10⁻⁶ 内被视为是正确的。 

 

 示例 1: 

 
输入: nums = [9,1,2,3,9], k = 3
输出: 20.00000
解释: 
nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20. 
我们也可以把 nums 分成[9, 1], [2], [3, 9]. 
这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 

 示例 2: 

 
输入: nums = [1,2,3,4,5,6,7], k = 4
输出: 20.50000
 

 

 提示: 

 
 1 <= nums.length <= 100 
 1 <= nums[i] <= 10⁴ 
 1 <= k <= nums.length 
 

 Related Topics 数组 动态规划 前缀和 👍 264 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
