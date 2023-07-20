package test.bd;

import java.util.Scanner;

public class t2 {

    static StringBuilder sb;
    static String ans;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        findHuiwen(t);
        System.out.println(ans);
    }

    private static void findHuiwen(int t) {
        sb = new StringBuilder();
        char[] chars = {'r', 'e', 'd'};
        helper(chars, t);
    }

    //回溯
    private static void helper(char[] chars, int t) {
        if (ctOf(sb) == t) {
            ans = sb.toString();
        } else if (ctOf(sb) < t) {
            for (char ch : chars) {
                sb.append(ch);
                helper(chars,t);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    private static int ctOf(StringBuilder sb) {
        if (sb.length() == 0){
            return 0;
        }
        String s = sb.toString();
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] += dp[i - 1];
            for (int j = 0; j <= i; j++) {
                if (isHuiWen(s, j, i)) {
                    dp[i]++;
                }
            }
        }
        return dp[n - 1];
    }

    private static boolean isHuiWen(String s, int j, int i) {
        if (i == j) {
            return true;
        } else {
            String substring = s.substring(j, i + 1);
            int start = 0, end = substring.length() - 1;
            while (start < end) {
                if (substring.charAt(start) != substring.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
}
