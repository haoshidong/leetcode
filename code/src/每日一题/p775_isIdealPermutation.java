package 每日一题;

public class p775_isIdealPermutation {
    public boolean isIdealPermutation(int[] nums) {
        int max = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (max > nums[i]) {
                return false;
            }
            max = Math.max(max, nums[i - 1]);
        }
        return true;

        /*for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]>nums[i]){
                int temp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]>nums[i]){
                return false;
            }
        }
        return true;*/
    }
}
