package Hot100.p051_p100;

public class p221_maximalSquare {
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

        /*int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[2][cols];
        int max = 0;
        for (int j = 0; j < cols; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            max = Math.max(max, dp[0][j]);
        }
        for (int i = 1; i < rows; i++) {
            dp[i % 2][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, dp[i % 2][0]);
            for (int j = 1; j < cols; j++) {
                dp[i % 2][j] = matrix[i][j] == '1' ?
                        Math.min(Math.min(dp[i % 2][j - 1], dp[(i - 1) % 2][j]), dp[(i - 1) % 2][j - 1]) + 1 :
                        0;
                max = Math.max(max, dp[i % 2][j]);
            }
        }
        return max * max;*/
    }
}
