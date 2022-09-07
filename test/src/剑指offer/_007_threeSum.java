package 剑指offer;

import java.util.Arrays;
import java.util.List;

public class _007_threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.stream(nums).sorted();
        List<List<Integer>> ans = null;
        for (int i=0;i<nums.length;i++){
            List<List<Integer>> zero = twoSum(nums, 0-nums[i], i);
            List<List<Integer>> three = twoSum(nums, 3-nums[i], i);
        }
        for (List<Integer> x:zero){

        }
    }

    public List<List<Integer>> twoSum(int[] numbers, int target, int k) {
        int i = 0;
        int j = numbers.length-1;
        List<List<Integer>> zero_r = null;
        while (i<j){
            if (numbers[i]+numbers[j]<target){
                i++;
            } else if (numbers[i]+numbers[j]>target) {
                j--;
            }else {
                List<Integer> zero = null;
                zero.add(i);
                zero.add(j);
                zero.add(k);
                zero_r.add(zero);
            }
        }
        return zero_r;
    }

}
