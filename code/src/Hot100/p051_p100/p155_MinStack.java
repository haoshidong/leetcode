package Hot100.p051_p100;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class p155_MinStack {
    private Stack<int[]> stack;

    public p155_MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.size() == 0) {
            stack.push(new int[]{val, val});
        } else {
            stack.push(new int[]{val, Math.min(val, getMin())});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
