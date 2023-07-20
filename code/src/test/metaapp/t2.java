package test.metaapp;

import java.util.Stack;

public class t2 {
    public static void main(String[] args) {
        int[] nums = solution1(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int[] solution1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int k = nums.length > 11 ? 11 : nums.length;
        for (int i = 0; i < k; i++) {
            stack.push(nums[i]);
        }
        if (stack.size() <= 8) {
            return new int[0];
        }
        for (int i = 0; i < 8; i++) {
            stack.pop();
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static int solution2(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int ans = 0;
//        stack.push(-1);
        for (int i = 0; i < len; i++) {
            int index = stack.peek();
            if (nums[i] < nums[index]){
                stack.push(i);
            }else {
                ans = Math.max(ans, (i - index) * nums[index]);
                stack.pop();
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            int i = stack.pop();
            ans = Math.max(ans, (i - stack.peek()) * nums[i]);
        }
        return ans;
    }
}
