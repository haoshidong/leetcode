/**
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 

 

 
 
 示例 1： 
 
 

 
输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"
 

 示例 2： 

 
输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"
 

 示例 3： 

 
输入：s = ""
输出：0
 

 

 提示： 

 
 0 <= s.length <= 3 * 10⁴ 
 s[i] 为 '(' 或 ')' 
 

 Related Topics 栈 字符串 动态规划 👍 2062 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        //dp数组，dp[i]记录s字符串以下标i为最后括号的最长有效括号的长度。dp[0]=0
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                //s[i-1]与s[i]组成有效括号，最长有效括号长度=以i-2为结尾的最长有效括号长度+2
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                /*若s[i-1]未与s[i]组成有效括号，且s[i-dp[i-1]-1]与s[i]组成有效括号，
                最长有效括号长度 = 以i-1为结尾的最长有效括号长度 + 2 （（若存在就加）+ 以[i-dp[i-1]-2]为结尾的最长有效括号长度）
                */
                } else if ((i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
