package 每日一题;

public class p1247_minimumSwap {
    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }
        StringBuilder builder = new StringBuilder();
        int ctOfX = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (c != s2.charAt(i)) {
                builder.append(c);
                if (c == 'x') {
                    ctOfX++;
                }
            }
        }
        int length = builder.length();
        if (length % 2 == 1) {
            return -1;
        }
        return length / 2 + ctOfX % 2;
    }
}
