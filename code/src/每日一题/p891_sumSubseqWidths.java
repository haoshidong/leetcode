package 每日一题;

import java.util.Arrays;

public class p891_sumSubseqWidths {
    private static final int MOD = (int) (1e9 + 7);

    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }
        long ans = 0l;
        for (int i = 0; i < n; i++) {
            ans += (long) (pow2[i] - pow2[n - i - 1]) * nums[i];
        }
        return (int) ((ans % MOD + MOD) % MOD);
    }
}
