package Hot100.p001_p050;

public class p5_longestPalindrome {
    public String longestPalindrome(String s) {
        String res = "";
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(getPalinLen(s, i, i), getPalinLen(s, i, i + 1));
            if (maxLen < len) {
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
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        String res = new p5_longestPalindrome().longestPalindrome(s);
    }
}
