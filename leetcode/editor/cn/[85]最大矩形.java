/**
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],[
 * "1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = []
 * 输出：0
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：matrix = [["1"]]
 * 输出：1
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * <p>
 * 输入：matrix = [["0","0"]]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * rows == matrix.length
 * cols == matrix[0].length
 * 1 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 * <p>
 * <p>
 * Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1414 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] h = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    h[j] = 0;
                } else {
                    h[j]++;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(h));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        //单调栈
        int maxArea = 0;
        Stack<Integer> indexs = new Stack<>();
        indexs.push(-1);
        int i = 0;
        for (; i < heights.length; i++) {
            //待入栈元素小于栈顶元素，则找到栈顶元素的左边界，栈顶元素的右边界为栈顶下面的第一个元素
            while (indexs.peek() != -1 && heights[i] <= heights[indexs.peek()]) {
                int area = heights[indexs.pop()] * (i - indexs.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            indexs.push(i);
        }
        //栈不为空，则栈内所有元素的左边界为数组的长度。
        while (indexs.size() > 1) {
            int area = heights[indexs.pop()] * (i - indexs.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
