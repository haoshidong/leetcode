package Hot100.p001_p050;

import java.util.Arrays;

public class p136_singleNumber {
    public int singleNumber(int[] nums) {
        //异或运算
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans ^= nums[i];
            }
        }
        return ans;

        /*Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]==nums[i]){
                i++;
            }else {
                return nums[i-1];
            }
        }
        return nums[nums.length-1];*/
    }
}
