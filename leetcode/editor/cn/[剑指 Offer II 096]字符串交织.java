/**
给定三个字符串 s1、s2、s3，请判断 s3 能不能由 s1 和 s2 交织（交错） 组成。 

 两个字符串 s 和 t 交织 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 

 
 s = s1 + s2 + ... + sn 
 t = t1 + t2 + ... + tm 
 |n - m| <= 1 
 交织 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
 

 提示：a + b 意味着字符串 a 和 b 连接。 

 

 示例 1： 

 

 
输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出：true
 

 示例 2： 

 
输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
输出：false
 

 示例 3： 

 
输入：s1 = "", s2 = "", s3 = ""
输出：true
 

 

 提示： 

 
 0 <= s1.length, s2.length <= 100 
 0 <= s3.length <= 200 
 s1、s2、和 s3 都由小写英文字母组成 
 

 

 
 注意：本题与主站 97 题相同： https://leetcode-cn.com/problems/interleaving-string/ 

 Related Topics 字符串 动态规划 👍 37 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 + len2 != s3.length()) {
            return false;
        }
        if (len1 < len2) {
            return isInterleave(s2, s1, s3);
        }
        boolean[] dp = new boolean[len2 + 1];   //一维数组保存dp
        dp[0] = true;
        for (int j = 0; j < len2; j++) {
            dp[j + 1] = s2.charAt(j) == s3.charAt(j) && dp[j];
        }
        for (int i = 0; i < len1; i++) {
            dp[0] = s1.charAt(i) == s3.charAt(i) && dp[0];
            for (int j = 0; j < len2; j++) {
                int ch1 = s1.charAt(i);
                int ch2 = s2.charAt(j);
                int ch3 = s3.charAt(i + j + 1);
                dp[j + 1] = (ch1 == ch3 && dp[j + 1]) || (ch2 == ch3 && dp[j]);
            }
        }
        return dp[len2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
