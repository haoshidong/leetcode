/**
在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 
grid[xi][yi] == 0 

 返回 grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。 

 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 
1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。 

 

 示例 1： 

 

 
输入: n = 5, mines = [[4, 2]]
输出: 2
解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 

 示例 2： 

 

 
输入: n = 1, mines = [[0, 0]]
输出: 0
解释: 没有加号标志，返回 0 。
 

 

 提示： 

 
 1 <= n <= 500 
 1 <= mines.length <= 5000 
 0 <= xi, yi < n 
 每一对 (xi, yi) 都 不重复 
 

 Related Topics 数组 动态规划 👍 128 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        Set<Integer> set = new HashSet<>();
        for (int[] zero : mines) {
            set.add(zero[0] * n + zero[1]);
        }
        int ans = 0;
        //遍历左右两个方向
        for (int i = 0; i < n; i++) {
            int count = 0;
            //left
            for (int j = 0; j < n; j++) {
                if (!set.contains(i * n + j)) {
                    count++;
                } else {
                    count = 0;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            //right
            for (int j = n - 1; j >= 0; j--) {
                if (!set.contains(i * n + j)) {
                    count++;
                } else {
                    count = 0;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        //遍历上下两个方向
        for (int j = 0; j < n; j++) {
            int count = 0;
            //up
            for (int i = 0; i < n; i++) {
                if (!set.contains(i * n + j)) {
                    count++;
                } else {
                    count = 0;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            //down
            for (int i = n - 1; i >= 0; i--) {
                if (!set.contains(i * n + j)){
                    count++;
                }else {
                    count = 0;
                }
                dp[i][j] = Math.min(dp[i][j], count);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
