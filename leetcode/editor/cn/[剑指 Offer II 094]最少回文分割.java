/**
 * 给定一个字符串 s，请将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "a"
 * 输出：0
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "ab"
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 132 题相同： https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * <p>
 * <p>
 * Related Topics 字符串 动态规划 👍 48 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] isPal = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            char ch1 = s.charAt(i);
            for (int j = 0; j <= i; j++) {
                char ch2 = s.charAt(j);
                if (ch1 == ch2 && (i <= j + 1 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                }
            }
        }
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = 1; j <= i; j++) {
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[len - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
