/**
给你一个字符串 s，找到 s 中最长的回文子串。 

 

 示例 1： 

 
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
 

 示例 2： 

 
输入：s = "cbbd"
输出："bb"
 

 

 提示： 

 
 1 <= s.length <= 1000 
 s 仅由数字和英文字母组成 
 

 Related Topics 字符串 动态规划 👍 5862 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(getPalinLen(s, i, i), getPalinLen(s, i, i + 1));
            if (maxLen<len) {
                maxLen = Math.max(maxLen, len);
                if (maxLen % 2 == 0) {
                    res = s.substring(i - maxLen / 2 + 1, i + maxLen / 2 + 1);
                } else {
                    res = s.substring(i - maxLen / 2, i + maxLen / 2 + 1);
                }
            }
        }
        return res;
    }

    private int getPalinLen(String s, int start, int end) {
        while (start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
