package 剑指offer;

public class p039_largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
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
    }
}
