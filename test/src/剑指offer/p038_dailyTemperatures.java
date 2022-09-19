package 剑指offer;

import java.util.Stack;

public class p038_dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Stack<Integer> stack = new Stack<>();//存放当天温度的日期
        for (int i = 0; i < length; i++) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]){
                int prev = stack.pop();
                ans[prev] = i-prev;
            }
                stack.push(i);
        }
        return ans;
    }
}
