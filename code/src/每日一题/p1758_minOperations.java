package 每日一题;

public class p1758_minOperations {
    public int minOperations(String s) {
        int ans_0 = 0, ans_1 = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i % 2 == 0) {
                if (ch == '0') {
                    ans_1++;
                } else {
                    ans_0++;
                }
            } else if (i % 2 == 1) {
                if (ch == '0') {
                    ans_0++;
                } else {
                    ans_1++;
                }
            }
        }
        return Math.min(ans_0, ans_1);
    }
}
