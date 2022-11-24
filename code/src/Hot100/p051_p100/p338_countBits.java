package Hot100.p051_p100;

public class p338_countBits {
    public int[] countBits(int n) {
        //动态规划
        /*
            若i=8（2^3）,二进制为1000，
                i=8,1的个数为 0+1=1；
                i=9,1的个数为 1+1=2；
                i=10，1的个数为 2（2中1的个数为1）+1=2；
                。
                。
                。
                i=15,1的个数为 7（7中1的个数）+1=4；
        */
        int[] dp = new int[n + 1];
        int x = 1;
        for (int i = 1, j = 0; i <= n; i++, j++) {
            if (i >= 2 * x) {
                x *= 2;
                j = 0;
            }
            dp[i] = dp[j] + 1;
        }
        return dp;
    }
}
