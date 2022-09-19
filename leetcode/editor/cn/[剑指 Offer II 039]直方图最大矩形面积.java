/**
给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 

 求在该柱状图中，能够勾勒出来的矩形的最大面积。 

 

 示例 1: 

 

 
输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10
 

 示例 2： 

 

 
输入： heights = [2,4]
输出： 4 

 

 提示： 

 
 1 <= heights.length <=10⁵ 
 0 <= heights[i] <= 10⁴ 
 

 

 
 注意：本题与主站 84 题相同： https://leetcode-cn.com/problems/largest-rectangle-in-
histogram/ 

 Related Topics 栈 数组 单调栈 👍 60 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        return helper(heights,0,heights.length);
    }

    private int helper(int[] heights, int start, int end) {
        if (start == end){
            return 0;
        }
        if (start+1 == end){
            return heights[start];
        }
        int min = heights[start];
        int minindex = start;
        for (int i = start; i < end; i++) {
            if (heights[i]<min){
                min = heights[i];
                minindex = i;
            }
        }

        int area = min * (end-start);
        int leftArea = helper(heights,start,minindex);
        int rightArea = helper(heights,minindex+1,end);
        area = Math.max(area,leftArea);
        return Math.max(area,rightArea);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
