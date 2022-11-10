package Hot100.p001_p050;

public class p72_minDistance {
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
