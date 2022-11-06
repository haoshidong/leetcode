package Hot100.p001_p050;

import java.util.LinkedList;
import java.util.List;

public class p39_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        helper(candidates, target, 0, new LinkedList<>(), res);
        return res;
    }

    private void helper(int[] candidates, int target, int i, LinkedList<Integer> path, List<List<Integer>> res) {
        if (0 == target) {
            res.add(new LinkedList<>(path));
        } else if (target > 0) {
            for (; i < candidates.length; i++) {
                path.add(candidates[i]);
                helper(candidates,target-candidates[i],i,path,res);
                path.removeLast();
            }
        }
    }
}
