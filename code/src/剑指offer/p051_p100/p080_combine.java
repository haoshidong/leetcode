package 剑指offer.p051_p100;

import java.util.LinkedList;
import java.util.List;

public class p080_combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(n, 1, k, combination, res);
        return res;
    }

    private void helper(int n, int i, int k, LinkedList<Integer> combination, List<List<Integer>> res) {
        //剪枝，如果combination中的数+剩下的所有数的数量小于k，就不需要继续回溯了
        if (n - i + 1 + combination.size() < k) {
            return;
        }
        if (combination.size() == k) {
            res.add(new LinkedList<>(combination));
        } else if (i <= n) {
            helper(n, i + 1, k, combination, res);

            combination.add(i);
            helper(n, i + 1, k, combination, res);
            combination.removeLast();
        }
    }
}
