package Hot100.p001_p050;

public class p32_longestValidParentheses {
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
