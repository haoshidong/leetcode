package 每日一题;

public class p1144_movesToMakeZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int maxOdd = 0;
        int maxEven = 0;
        for (int i = 0; i < nums.length; i++) {
            //偶数最大
            if (i % 2 == 1) {
                int max = 0;
                if (i - 1 >= 0 && nums[i] >= nums[i - 1]) {
                    max = nums[i] - nums[i - 1] + 1;
                }
                if (i + 1 < nums.length && nums[i] >= nums[i + 1]) {
                    max = Math.max(max, nums[i] - nums[i + 1] + 1);
                }
                maxEven += max;
            }
            //奇数最大
            else if (i % 2 == 0) {
                int max = 0;
                if (i - 1 >= 0 && nums[i] >= nums[i - 1]) {
                    max = nums[i] - nums[i - 1] + 1;
                }
                if (i + 1 < nums.length && nums[i] >= nums[i + 1]) {
                    max = Math.max(max, nums[i] - nums[i + 1] + 1);
                }
                maxOdd += max;
            }
        }
        return maxOdd > maxEven ? maxEven : maxOdd;
    }

    public static void main(String[] args) {
        int[] nums = {7,4,8,9,7,7,5};
        int i = new p1144_movesToMakeZigzag().movesToMakeZigzag(nums);
        System.out.println(i);
    }
}
