package Hot100.p001_p050;

import java.util.Stack;

public class p85_maximalRectangle {
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
