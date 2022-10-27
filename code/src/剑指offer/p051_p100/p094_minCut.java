package 剑指offer.p051_p100;

public class p094_minCut {
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
        /*int length = s.length();
        if (length <= 1) {
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
            int min = length;
            for (int j = 0; j <= i; j++) {
                int end = i;
                int start = j;
                while (start <= end && s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                }
                if (start > end) {
                    int temp = j - 1 >= 0 ? dp[j - 1] + 1 : 0;
                    min = Math.min(min, temp);
                }
            }
            dp[i] = min;
        }
        return dp[length - 1];*/
    }
}
