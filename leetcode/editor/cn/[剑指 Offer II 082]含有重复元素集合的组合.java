/**
 * 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/
 * <p>
 * Related Topics 数组 回溯 👍 30 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
