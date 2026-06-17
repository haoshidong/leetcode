package new_hot100;

import java.util.Arrays;

class P31_NextPermutation {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public void nextPermutation(int[] nums) {
        int t = nums.length-1;
        for (; t > 0; t--) {
            if (nums[t] > nums[t-1])
                break;
        }
        if (t == 0) {
            Arrays.sort(nums);
        }else {
            int i = nums.length-1;

            while (nums[i] <= nums[t-1]) {i--;}
            swap(nums, i, t-1);
            Arrays.sort(nums, t,  nums.length);
        }
    }

    private void swap(int[] nums, int i, int t) {
        int tmp = nums[i];
        nums[i] = nums[t];
        nums[t] = tmp;
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P31_NextPermutation().new Solution(); 
    }
}