package 剑指offer.p051_p100;

public class p097_numDistinct {
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        if (s.length()>0) { //若s小于t的长度，则dp[s.length][t.length]为0，（dp呈长方形，水平边长度>竖直边长度，对角线往右都是0）
            dp[0] = 1;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = Math.min(i, t.length() - 1); j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[j+1] += dp[j];
                }
            }
        }
        return dp[t.length()];
    }
}
