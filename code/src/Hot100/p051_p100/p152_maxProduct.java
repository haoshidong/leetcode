package Hot100.p051_p100;

public class p152_maxProduct {
    public int maxProduct(int[] nums) {
        //动态规划
        int imax = 1, imin = 1, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int temp = imin;
                imin = imax;
                imax = temp;
            }
            //状态转移方程
            imax = Math.max(num, imax * num);
            imin = Math.min(num, imin * num);
            max = Math.max(max, imax);
        }
        return max;
    }
}
