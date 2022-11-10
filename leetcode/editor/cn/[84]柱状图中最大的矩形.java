/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入： heights = [2,4]
 * 输出： 4
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= heights.length <=10⁵
 * 0 <= heights[i] <= 10⁴
 * <p>
 * <p>
 * Related Topics 栈 数组 单调栈 👍 2226 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> indexs = new Stack<>();
        indexs.push(-1);
        int i = 0;
        for (; i < heights.length; i++) {
            while (indexs.peek()!=-1 && heights[i] <= heights[indexs.peek()]) {
                int area = heights[indexs.pop()] * (i - indexs.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            indexs.push(i);
        }
        while (indexs.size() > 1) {
            int area = heights[indexs.pop()] * (i - indexs.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
