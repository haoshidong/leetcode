package Hot100.p051_p100;

import java.util.Arrays;

public class p300_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        //动态规划+二分查找
        int[] tails = new int[nums.length];
        //res表示tails中下一个待插入元素的空位置
        int res = 0;
        //遍历nums数组
        for (int num : nums) {
            //i,j分别指向tails的首和尾
            int i = 0, j = res;
            //寻找当前num在tails数组中将要插入的下标（二分法）
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            //将下标i的元素替换为num，num肯定小于原来的tails[i]，大于tails[i-1]
            tails[i] = num;
            //j一直没变化过，说明待插入下标i变化为j，num插入到tails中最后一个元素，长度加1，即res+1
            if (res == j) {
                res++;
            }
        }
        return res;

        /*
        //动态规划 时间复杂度o(n^2)
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;*/
    }
}
