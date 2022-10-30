package 每日一题;

import java.util.LinkedList;
import java.util.Stack;

public class p907_sumSubarrayMins {
    private static final int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        //处理边界情况
        if (arr.length == 0 || arr == null) {
            return 0;
        }
        int len = arr.length;
        //每个元素
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> monoStack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (!monoStack.isEmpty() && arr[monoStack.peek()] > arr[i]) {
                monoStack.pop();
            }
            if (monoStack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = monoStack.peek();
            }
            monoStack.push(i);
        }
        monoStack.clear();
        for (int i = len - 1; i >= 0; i--) {
            if (!monoStack.isEmpty() && arr[monoStack.peek()] >= arr[i]) {
                monoStack.pop();
            }
            if (monoStack.isEmpty()) {
                right[i] = len;
            } else {
                right[i] = monoStack.peek();
            }
            monoStack.push(i);
        }
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum = (sum + (long)(i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int)sum;
    }
}
