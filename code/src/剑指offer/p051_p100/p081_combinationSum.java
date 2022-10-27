package 剑指offer.p051_p100;

import java.util.LinkedList;
import java.util.List;

public class p081_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> comSum = new LinkedList<>();
        helper(candidates, target, 0, comSum, res);

        return res;
    }

    private void helper(int[] candidates, int target, int i, LinkedList<Integer> comSum, List<List<Integer>> res) {
        if (0 == target) {
            res.add(new LinkedList<>(comSum));
        } else if (target > 0 && i < candidates.length) {
            helper(candidates, target, i + 1, comSum, res);

            comSum.add(candidates[i]);
            helper(candidates, target - candidates[i], i, comSum, res);
            comSum.removeLast();
        }

    }

}
