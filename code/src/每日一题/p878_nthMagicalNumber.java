package 每日一题;


public class p878_nthMagicalNumber {
    public static final long MOD = (long) 1e9 + 7;

    public int nthMagicalNumber(int n, int a, int b) {
        long lcm = a / gcd(a, b) * b;
        long l = 0, r = (long) Math.min(a, b) * n;
        while (l + 1 < r) {
            long mid = (l + r) / 2;
            if (mid / a + mid / b - mid / lcm >= n) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return (int) (r % MOD);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
