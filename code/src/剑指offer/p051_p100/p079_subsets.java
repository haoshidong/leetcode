package 剑指offer.p051_p100;

import com.sun.deploy.ref.Helpers;

import java.util.LinkedList;
import java.util.List;

public class p079_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        }
        helper(nums, 0, new LinkedList<Integer>(), res);
        return res;
    }

    private void helper(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> res) {
        if (index == nums.length){
            res.add(new LinkedList<>(subset));
        }else {
            helper(nums,index+1,subset,res);

            subset.add(nums[index]);
            helper(nums,index+1,subset,res);
            subset.removeLast();
        }
    }
}
