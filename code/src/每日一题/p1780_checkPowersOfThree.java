package 每日一题;

import java.util.Map;

public class p1780_checkPowersOfThree {
    public boolean checkPowersOfThree(int n) {
        //将n看成3进制数，110表示12,111表示13,112表示14
        while (n > 0) {
            if (n % 3 > 1) {
                return false;
            }
            n /= 3;
        }
        return true;
        /*int i = 1;
        while (i < n) {
            i *= 3;
        }
        if (i > n) {
            i /= 3;
        }
        while (n - i < i && n > 3) {
            n -= i;
            //找到下一个小于n的最大3的幂
            while (i > n) {
                i /= 3;
            }
        }
        return n != 2 && n <= 3;*/
    }

    public static void main(String[] args) {
        int n = 12;
        boolean b = new p1780_checkPowersOfThree().checkPowersOfThree(n);
        System.out.println(b);
    }
}
