package Hot100.p001_p050;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class p78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, new LinkedList<Integer>(), ans);
        return ans;
    }

    private void helper(int[] nums, int i, LinkedList<Integer> path, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
        } else {
            helper(nums, i + 1, path, ans);

            path.add(nums[i]);
            helper(nums, i + 1, path, ans);
            path.removeLast();
        }
    }
}
