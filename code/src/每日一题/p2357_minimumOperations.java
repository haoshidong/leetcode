package 每日一题;

import java.util.Arrays;

public class p2357_minimumOperations {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] == 0) {
            return 0;
        }
        int ans = 0;
        int i = 0;
        while (i < nums.length) {
            while (i < nums.length && nums[i] == 0) {
                i++;
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            ans++;
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        int i = new p2357_minimumOperations().minimumOperations(nums);
        System.out.println(i);
    }
}
