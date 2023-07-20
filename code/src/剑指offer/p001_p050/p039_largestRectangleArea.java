package 剑指offer.p001_p050;

import java.util.Stack;

public class p039_largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            //计算以当前stack.peek()为右边界的矩形最大面积。（>=）
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        while (stack.peek()!=-1){
            int height = heights[stack.pop()];
            int width = heights.length-stack.peek()-1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }


    /*public int largestRectangleArea(int[] heights) {
        return helper(heights,0,heights.length);
    }

    private int helper(int[] heights, int start, int end) {
        int min = heights[start];
        int minindex = start;
        for (int i = start; i < end; i++) {
            if (heights[i]<min){
                min = heights[i];
                minindex = i;
            }
        }
        if (start >= end){
            return 0;
        }
        int area = min * (end-start);
        int leftArea = helper(heights,start,minindex-1);
        int rightArea = helper(heights,minindex+1,end);
        area = Math.max(area,leftArea);
        return Math.max(area,rightArea);
    }*/
}
