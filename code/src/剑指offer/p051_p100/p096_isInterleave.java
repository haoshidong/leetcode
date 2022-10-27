package 剑指offer.p051_p100;

public class p096_isInterleave {
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

        /*使用二位数组保存dp
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 + len2 != s3.length()) {
            return false;
        }
        if (len1 < len2) {
            return isInterleave(s2, s1, s3);
        }
        boolean[][] dp = new boolean[2][len2 + 1];
        dp[0][0] = true;
        for (int j = 0; j < len2; j++) {
            dp[0][j + 1] = s2.charAt(j) == s3.charAt(j) && dp[0][j];
        }
        for (int i = 0; i < len1; i++) {
            dp[(i + 1) % 2][0] = s1.charAt(i) == s3.charAt(i) && dp[i % 2][0];
            for (int j = 0; j < len2; j++) {
                int ch1 = s1.charAt(i);
                int ch2 = s2.charAt(j);
                int ch3 = s3.charAt(i + j + 1);
                dp[(i + 1) % 2][j + 1] = (ch1 == ch3 && dp[i % 2][j + 1]) || (ch2 == ch3 && dp[(i + 1) % 2][j]);
            }
        }
        return dp[(len1) % 2][len2];*/
    }
}
