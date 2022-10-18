package 剑指offer.p051_p100;

public class p089_rob {
    public int rob(int[] nums) {
        if (nums.length>1) {
            nums[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        }
        return nums[nums.length - 1];
    }
}
