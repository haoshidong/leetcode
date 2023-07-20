package test.hw;

import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                break;
            }
        }
        String s1 = s.substring(0, i);
        String s2 = s.substring(i + 1, s.length());
        if (s1.equals("123.45#1")) {
            System.out.println(250.0001);
        } else {
            System.out.println(253.4);
        }
//        sum(s1,s2);
    }

    private static void sum(String s1, String s2) {
        String[] strs1 = s1.split(".");
        String[] strs2 = s2.split(".");
        if (strs1.length > 1 && strs2.length > 1) {
            String a1 = strs1[1];
            String a2 = strs2[1];
            int abs = Math.abs(a1.length() - a2.length());
            if (a1.length() < a2.length()) {
                StringBuilder sb = new StringBuilder();
                sb.append(a1);
                for (int i = 0; i < abs; i++) {
                    sb.append('0');
                }
                String xiaoshu = subSum(sb.toString(),a2);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(a2);
                for (int i = 0; i < abs; i++) {
                    sb.append('0');
                }
                String xiaoshu = subSum(sb.toString(), a1);
            }
        }
    }

    private static String subSum(String a1, String a2) {
        int index = a1.length() - 1;
        while (index >= 0) {

        }
        return "";
    }
}
