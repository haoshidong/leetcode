package test.hw;

import java.util.Scanner;

public class t1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strs = new String[64];
        int i = 0;
        int k = n / 16 + 1;
        int p = k;
        while (k > 0) {
            String a = in.next();
            strs[i] = a.substring(2, 6);
//            System.out.println(strs[i]);
            i++;
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < p; j++) {
            String str = strs[j];
            String s = switchToBinary(str);
            sb.append(s);
        }
        String substring = sb.substring(0, n);
//        System.out.println(substring);
        minMove(substring);

    }

    private static void minMove(String s) {
        String[] split1 = s.split("0");
        String[] split0 = s.split("1");
        int ct1 = 0;
        int ct0 = 0;
        for (String s1 : split1) {
            if (s1.length() > 0) {
                ct1++;
            }
        }
        for (String s0 : split0) {
            if (s0.length() > 0) {
                ct0++;
            }
        }
        //格式化
        String[] str1 = new String[ct1];
        int i1 = 0;
        for (String s1 : split1) {
            if (s1.length() > 0) {
                str1[i1++] = s1;
//                System.out.println(s1);
            }
        }
        String[] str0 = new String[ct0];
        int i0 = 0;
        for (String s0 : split0) {
            if (s0.length() > 0) {
                str0[i0++] = s0;
//                System.out.println(s0);
            }
        }

        int maxMove = 0;
        int d = 0;
        if (s.charAt(0) == '1') {
            if (str0.length > str1.length){
                System.out.println(0);
                return;
            }
            for (int i = 0; i < str0.length; i++) {
                maxMove = Math.max(maxMove, str0[i].length());
                if (str0[i].length() <= str1.length && str0[i].length() <= str1[i + 1].length()) {

                } else if (str0[i].length() <= str1[i].length()) {
                    if (d == -1) {
                        System.out.println(0);
                        return;
                    }
                    d = 1;
                } else if (str0[i].length() <= str1[i + 1].length()) {
                    if (d == 1) {
                        System.out.println(0);
                        return;
                    }
                    d = -1;
                } else {
                    System.out.println(0);
                    return;
                }
            }
        }else {
            d = -1;
            for (int i = 0; i < str0.length; i++) {
                maxMove = Math.max(maxMove, str0[i].length());
                if (str0[i].length() <= str1[i].length()) {

                } else {
                    System.out.println(0);
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }

        //结果
        System.out.println(maxMove);
        if (maxMove != 0) {
            if (d > 0) {
                StringBuilder sr = sb;
                System.out.println("+" + maxMove);
                for (int i = 0; i < maxMove; i++) {
                    sb.append("0");
                }
                String substringR = sr.substring(maxMove);
                System.out.println(substringR);
            } else if (d < 0) {
                StringBuilder temp = new StringBuilder();
                StringBuilder sl = new StringBuilder();
                System.out.println("-" + maxMove);
                for (int i = 0; i < maxMove; i++) {
                    temp.append("0");
                }
                sl.append(temp);
                sl.append(sb);
                String substringL = sl.substring(0, s.length());
                System.out.println(substringL);
            }
        }
//        System.out.println(maxMove);
//        System.out.println(d);
    }

    private static String switchToBinary(String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            switch (ch) {
                case '0':
                    sb.append("0000");
                    continue;
                case '1':
                    sb.append("0001");
                    continue;
                case '2':
                    sb.append("0010");
                    continue;
                case '3':
                    sb.append("0011");
                    continue;
                case '4':
                    sb.append("0100");
                    continue;
                case '5':
                    sb.append("0101");
                    continue;
                case '6':
                    sb.append("0110");
                    continue;
                case '7':
                    sb.append("0111");
                    continue;
                case '8':
                    sb.append("1000");
                    continue;
                case '9':
                    sb.append("1001");
                    continue;
                case 'A':
                    sb.append("1010");
                    continue;
                case 'B':
                    sb.append("1011");
                    continue;
                case 'C':
                    sb.append("1100");
                    continue;
                case 'D':
                    sb.append("1101");
                    continue;
                case 'E':
                    sb.append("1110");
                    continue;
                case 'F':
                    sb.append("1111");
                    continue;
                default:
                    sb.append("");
            }
        }
        return sb.toString();
    }

}
