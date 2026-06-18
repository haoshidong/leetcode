package new_hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class P46_Permutations {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int index) {
        if(index == nums.length) {
            res.add(Arrays.stream(nums).boxed().toList());
        } else if (index < nums.length) {
            for (int i = index; i < nums.length; i++) {
                swap(nums, index, i);
                dfs(res, nums, index + 1);
                swap(nums, index, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P46_Permutations().new Solution(); 
    }
}