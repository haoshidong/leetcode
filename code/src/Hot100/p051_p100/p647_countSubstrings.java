package Hot100.p051_p100;

public class p647_countSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Substrings(i, i, s);
            ans += Substrings(i, i + 1, s);
        }
        return ans;
    }

    private int Substrings(int l, int r, String s) {
        int ct = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            ct++;
            l--;
            r++;
        }
        return ct;
    }
}
