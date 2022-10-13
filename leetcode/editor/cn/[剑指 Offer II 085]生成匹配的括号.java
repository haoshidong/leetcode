/**
 * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 8
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/
 * <p>
 * Related Topics 字符串 动态规划 回溯 👍 49 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper(n, n, "", res);

        return res;
    }

    private void helper(int left, int right, String str, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left > 0) {
            helper(left - 1, right, str + "(", res);
        }
        if (left < right) {
            helper(left, right - 1, str + ")", res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
