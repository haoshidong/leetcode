/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],[
 * "1","0","0","1","0"]]
 * 输出：4
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 * <p>
 * <p>
 * Related Topics 数组 动态规划 矩阵 👍 1316 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] dp = new int[cols + 1];
        int max = 0;
        int northwest = 0; // 西北角、左上角
        for (int i = 0; i < rows; i++) {
            northwest = 0;
            for (int j = 0; j < cols; j++) {
                int temp = dp[j+1];
                dp[j+1] = matrix[i][j] == '1' ? Math.min(Math.min(dp[j], dp[j+1]), northwest) + 1 : 0;
                northwest = temp;
                max = Math.max(max, dp[j+1]);
            }
        }
        return max * max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
