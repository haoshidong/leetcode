/**
给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 

 你可以对一个单词进行如下三种操作： 

 
 插入一个字符 
 删除一个字符 
 替换一个字符 
 

 

 示例 1： 

 
输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
 

 示例 2： 

 
输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
 

 

 提示： 

 
 0 <= word1.length, word2.length <= 500 
 word1 和 word2 由小写英文字母组成 
 

 Related Topics 字符串 动态规划 👍 2673 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        /*动态规划：
        dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
        所以，
            当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
            当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
        其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
        */
        if (word1.length() < word2.length()) {
            minDistance(word2, word1);
        }
        int n = word2.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < word1.length(); i++) {
            //pre存储待求值得左上角元素
            int pre = dp[0];
            dp[0]++;
            for (int j = 0; j < n; j++) {
                int temp = dp[j + 1];
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[j + 1] = pre;
                    pre = temp;
                } else {
                    //pre用来暂存最小值
                    pre = Math.min(pre, Math.min(dp[j + 1], dp[j]));
                    dp[j + 1] = pre + 1;
                    pre = temp;
                }
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
