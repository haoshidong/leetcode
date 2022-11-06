/**
给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 
k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 
0 。 

 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。 

 

 示例 1： 

 
输入：sequence = "ababc", word = "ab"
输出：2
解释："abab" 是 "ababc" 的子字符串。
 

 示例 2： 

 
输入：sequence = "ababc", word = "ba"
输出：1
解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
 

 示例 3： 

 
输入：sequence = "ababc", word = "ac"
输出：0
解释："ac" 不是 "ababc" 的子字符串。
 

 

 提示： 

 
 1 <= sequence.length <= 100 
 1 <= word.length <= 100 
 sequence 和 word 都只包含小写英文字母。 
 

 Related Topics 字符串 字符串匹配 👍 60 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxRepeating(String sequence, String word) {
        int maxLen = 0;
        int n = word.length();
        //动态规划
        int[] dp = new int[sequence.length() + 1];
        int i = n;
        while (i <= sequence.length()) {
            int index = i - 1;  //dp[i]对应的sequence下标
            int j = n - 1;  //word最后字母的下标，从后往前匹配sequence
            //若sequence当前下标[i-n,i-1]与word相等，则j值为-1；
            while (j >= 0) {
                if (word.charAt(j) == sequence.charAt(index)) index--;
                else break;
                j--;
            }
            //状态转移方程
            if (j==-1) dp[i] = dp[i - n] + 1;
            //计算dp[i+1]
            i++;
        }
        //遍历dp数组的最大值
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
