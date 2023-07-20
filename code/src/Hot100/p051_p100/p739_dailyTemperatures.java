package Hot100.p051_p100;

import java.util.Stack;

public class p739_dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        //存放日期（天数）
        Stack<Integer> decline = new Stack<>();
        int len = temperatures.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int cur = temperatures[i];
            while (!decline.isEmpty() && temperatures[decline.peek()] < cur) {
                ans[decline.peek()] = i - decline.peek();
                decline.pop();
            }
            decline.push(i);
        }
        return ans;
    }
}
