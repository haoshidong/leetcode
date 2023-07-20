package 前500.p1_50;

public class p43_multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2. equals("0")){
            return "0";
        }
        if (num1.length() > num2.length()) {
            return multiply(num2, num1);
        }
        String ans = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            String temp = mul(num1, i, num2);
            ans = subSum(ans, temp);
        }

        return ans;
    }

    private String subSum(String ans, String temp) {
        if ("".equals(ans)) {
            return temp;
        }
        if (ans.length() > temp.length()) {
            return subSum(temp, ans);
        }
        StringBuilder s1 = new StringBuilder(ans);
        StringBuilder s2 = new StringBuilder(temp);

        s1 = s1.reverse();
        s2 = s2.reverse();
        int l = s1.length();
        int next = 0;
        int i = 0;
        StringBuilder res = new StringBuilder();

        for (; i < l; i++) {
            int a = s1.charAt(i) - '0';
            int b = s2.charAt(i) - '0';
            int cur = a + b + next;
            res.append(cur % 10);
            next = cur / 10;
        }
        if (i != s2.length()) {
            while (i < s2.length()) {
                int b = s2.charAt(i) - '0';
                i++;
                int cur = next + b;
                res.append(cur % 10);
                next = cur / 10;
            }
        }
        if (next != 0) {
            res.append(next);
        }
        return res.reverse().toString();
    }

    private String mul(String num1, int i, String num2) {
        char m = num1.charAt(i);
        i = num1.length() - i - 1;
        StringBuilder sb = new StringBuilder();
        int next = 0;
        for (int j = num2.length() - 1; j >= 0; j--) {
            char ch = num2.charAt(j);
            int temp = (m - '0') * (ch - '0') + next;
            sb.append(temp % 10);
            next = temp / 10;
        }
        if (next != 0) {
            sb.append(next);
        }
        sb = sb.reverse();
        while (i > 0) {
            sb.append("0");
            i--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123456789";
        String num2 = "987654321";
        p43_multiply t = new p43_multiply();
        System.out.println(t.multiply(num1, num2));
    }
}
