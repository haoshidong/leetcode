package Hot100.p001_p050;

import java.util.Stack;

public class p84_largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        //单调栈
        int maxArea = 0;
        Stack<Integer> indexs = new Stack<>();
        indexs.push(-1);
        int i = 0;
        for (; i < heights.length; i++) {
            //待入栈元素小于栈顶元素，则找到栈顶元素的左边界，栈顶元素的右边界为栈顶下面的第一个元素
            while (indexs.peek()!=-1 && heights[i] <= heights[indexs.peek()]) {
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

    public static void main(String[] args) {
        int[] h = {1,0,1,0,0};
        int ans = new p84_largestRectangleArea().largestRectangleArea(h);
        System.out.println(ans);
    }
}
