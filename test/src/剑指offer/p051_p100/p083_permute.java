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
        
    }
}
