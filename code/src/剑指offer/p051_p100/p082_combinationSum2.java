package 剑指offer.p051_p100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class p082_combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(candidates, target, 0, combination, res);

        return res;
    }

    private void helper(int[] candidates, int target, int i, LinkedList<Integer> combination, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<>(combination));
        } else if (target > 0 && i < candidates.length) {
            helper(candidates, target, getindex(candidates, i), combination, res);

            combination.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, combination, res);
            combination.removeLast();
        }
    }

    private int getindex(int[] candidates, int i) {
        int cur = candidates[i];
        for (; i < candidates.length; i++) {
            if (candidates[i] != cur) {
                break;
            }
        }
        return i;
    }
}
