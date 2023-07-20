package test.metaapp;

import java.util.Stack;

public class t22 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,1,4,2,6};
        int i = solution2(nums);
        System.out.println(i);
    }

    public static int solution2(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int ans = 0;
        stack.push(0);
        for (int i = 1; i < len; i++) {
            int index = stack.peek();
            if (nums[i] < nums[index]){
                stack.push(i);
            }else {
                ans = Math.max(ans, (i - index) * nums[index]);
                stack.pop();
                stack.push(i);
            }
        }
        while (stack.size() > 1){
            int i = stack.pop();
            ans = Math.max(ans, (i - stack.peek()) * nums[i]);
        }
        return ans;
    }
}
