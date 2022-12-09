package 每日一题;

public class p1752_check {
    public boolean check(int[] nums) {
        int i = 1;
        while (i < nums.length && nums[i] >= nums[i - 1]) {
            i++;
        }
        if (i == nums.length) {
            return true;
        }
        i++;
        while (i < nums.length && nums[i] >= nums[i - 1]) {
            i++;
        }
        if (i == nums.length && nums[i - 1] <= nums[0]) {
            return true;
        }
        return false;
    }
}
