package 剑指offer.p051_p100;

import java.util.List;

public class p100_minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];    //第n行元素的个数=行的个数
        for (List<Integer> row : triangle) {
            for (int j = row.size() - 1; j >= 0; j--) {
                if (j == 0) {
                    dp[0] += row.get(0);
                } else if (j == row.size() - 1) {
                    dp[j] = dp[j - 1] + row.get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + row.get(j);
                }
            }
        }
        int res = dp[0];
        for (int path : dp) {
            res = Math.min(res, path);
        }
        return res;
    }
}
