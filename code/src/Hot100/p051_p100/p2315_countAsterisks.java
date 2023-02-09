package Hot100.p051_p100;

public class p2315_countAsterisks {
    public int countAsterisks(String s) {
        int ct = 0, ans = 0;
        for (char ch : s.toCharArray()) {
            if (ct % 2 == 0 && ch == '*') {
                ans++;
            }
            if (ch == '|') {
                ct++;
            }
        }
        return ans;
    }
}
