package 前500.p1_50;

public class p7_reverse {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            //正数的判断
            if (res > 214748364 || (res == 214748364 && temp > 7)) {
                return 0;
            }
            //负数的判断
            if (res < -214748364 || (res == -214748364 && temp < -8)) {
                return 0;
            }
            res = res * 10 + temp;
            x = x / 10;
        }
        return res;
    }
}
