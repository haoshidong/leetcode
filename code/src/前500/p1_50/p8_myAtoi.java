package 前500.p1_50;

public class p8_myAtoi {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        long ans;
        //step1
        int i = 0;
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                if (ch == '-' || ch == '+' || Character.isDigit(ch)) {
                    break;
                } else {
                    return 0;
                }
            }
        }
        if (i==s.length()){
            return 0;
        }
        //step2
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i == s.length() - 1 && !Character.isDigit(ch)) {
                return 0;
            }
            if ((ch == '-' || ch == '+') && Character.isDigit(s.charAt(i + 1)) || Character.isDigit(ch)) {
                break;
            }else {
                return 0;
            }
        }
        //step3
        int end = i + 1;
        for (; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (!Character.isDigit(ch)) {
                break;
            }
        }
        int begin = i;
        if (!Character.isDigit(s.charAt(begin))) {
            begin++;
        }
        ans = Long.valueOf(s.substring(begin, end));
        if (s.charAt(i) == '-') {
            ans = -ans;
        }
        if ((int) ans == ans) {
            return (int) ans;
        }
        return ans > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        String s = " ";
        int i = new p8_myAtoi().myAtoi(s);
        System.out.println(i);
    }
}
