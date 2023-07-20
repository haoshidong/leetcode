package test.mt.mt2;

import java.util.Scanner;
/*18*/
public class t3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String ans = minDic(s);
        System.out.println(ans);
    }

    static char[] result;

    private static String minDic(String s) {
        result = new char[s.length()];
        char[] chars = s.toCharArray();
        int l = 0, r = s.length() - 1;
        int[] change = new int[]{0};
        helper(chars, l, r, 2, change);
        return String.valueOf(result);
    }

    private static void helper(char[] chars, int l, int r, int flag, int[] change) {
        if (l < r) {
            char cL = chars[l];
            char cR = chars[r];
            //不相等，一定要改变
            if (cL != cR && flag > 0) {
                if (cL < cR) {
                    chars[r] = cL;
                } else {
                    chars[l] = cR;
                }
                helper(chars, l + 1, r - 1, flag - 1, change);
            } else if (flag == 2) {
                //相等，改不改变都可以，但要保证字符串为回文
                //1、若改变
                if (cL != 'a') {
                    chars[l] = 'a';
                    chars[r] = 'a';
                    helper(chars, l + 1, r - 1, flag - 2, change);
                    chars[l] = cL;
                    chars[r] = cL;
                }
                //2、不改变
                helper(chars, l + 1, r - 1, flag, change);
            }
        } else {
            change[0] += 1;
            if (change[0] == 1) {
                for (int i = 0; i < chars.length; i++) {
                    result[i] = chars[i];
                }
            }
        }
    }
}
