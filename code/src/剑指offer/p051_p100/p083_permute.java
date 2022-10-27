package 剑指offer.p051_p100;

import java.util.LinkedList;
import java.util.List;

public class p083_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(nums,0,res);
        
        return res;
    }

    private void helper(int[] nums, int i, List<List<Integer>> res) {
        if(i==nums.length){
            LinkedList<Integer> permutation = new LinkedList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            res.add(permutation);
        }else {
            for (int j = i; j < nums.length; j++) {
                swap(nums,i,j);
                helper(nums,i+1,res);
                swap(nums,i,j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i!=j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
