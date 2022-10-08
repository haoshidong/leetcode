package 剑指offer.p051_p100;

public class p070_singleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            int index = mid * 2;
            if (nums[index] != nums[index + 1] && index<nums.length-1) {
                if (mid == 0 || nums[index - 2] == nums[index - 1]) {
                    return nums[index];
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
