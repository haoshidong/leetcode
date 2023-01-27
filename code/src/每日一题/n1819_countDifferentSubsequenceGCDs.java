package 每日一题;

public class n1819_countDifferentSubsequenceGCDs {
    /**
     * nums=[4,6,16]
     * 1的倍数[4,6,16]
     * 2的倍数[4,6,16]
     * 4的倍数[4,16]
     * 6的倍数[6]
     * 16的倍数[16]
     * nums 的所有 非空 子序列中 不同 最大公约数的 数目为5
     * @param nums
     * @return
     */
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int ans = 0, mx = 0;
        for (int x : nums) mx = Math.max(mx, x);
        boolean[] has = new boolean[mx + 1];
        for (int x : nums) has[x] = true;
        for (int i = 1; i <= mx; ++i) {
            int g = 0; // 0 和任何数 x 的最大公约数都是 x
            for (int j = i; j <= mx && g != i; j += i) // 枚举 i 的倍数 j
                if (has[j]) // 如果 j 在 nums 中
                    g = gcd(g, j); // 更新最大公约数
            if (g == i) ++ans; // 找到一个答案
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}
