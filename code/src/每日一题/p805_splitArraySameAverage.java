package 每日一题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class p805_splitArraySameAverage {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return false;
        }
        int s = Arrays.stream(nums).sum();
        //nums的总和为0，只需从nums中分割出子数组和为0就算分割成功，但子数组的个数不能等于n
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - s;
        }
        int m = n >> 1;
        Set<Integer> vis = new HashSet<>();
        //子数组若只存在于前半部分，枚举前半部分的所有组合，总和为0则分割成功，否则存于set中，用来查询后半数组。
        for (int i = 1; i < 1 << m; i++) {
            int t = 0;
            for (int j = 0; j < m; j++) {
                if (((i >> j) & 1) == 1) {
                    t += nums[j];
                }
            }
            //分隔成功
            if (t == 0) {
                return true;
            }
            //分割失败，子数组可能全在后半数组，或部分前半数组+部分后半数组（总个数最多为n-1）
            vis.add(t);
        }
        //子数组不在前半部分
        for (int i = 1; i < 1 << (n - m); i++) {
            int t = 0;
            for (int j = 0; j < (n - m); j++) {
                if (((i >> j) & 1) == 1) {
                    t += nums[m + j];
                }
            }
            //若后半部分有子数组总和为0，直接返回true；若后半部分子数组的总和为t，且在前半部分数组set中有对应的-t，则查找成功
            //注意！分割出来的子数组总个数不能为n
            if (t == 0 || (i != (1 << (n - m)) - 1) && vis.contains(-t)) {
                return true;
            }
        }
        return false;
    }
}
