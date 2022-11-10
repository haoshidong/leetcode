package 每日一题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class p764_orderOfLargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        Set<Integer> set = new HashSet<>();
        for (int[] zero : mines) {
            set.add(zero[0] * n + zero[1]);
        }
        int ans = 0;
        //遍历左右两个方向
        for (int i = 0; i < n; i++) {
            int count = 0;
            //left
            for (int j = 0; j < n; j++) {
                if (!set.contains(i * n + j)) {
                    count++;
                } else {
                    count = 0;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            //right
            for (int j = n - 1; j >= 0; j--) {
                if (!set.contains(i * n + j)) {
                    count++;
                } else {
                    count = 0;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        //遍历上下两个方向
        for (int j = 0; j < n; j++) {
            int count = 0;
            //up
            for (int i = 0; i < n; i++) {
                if (!set.contains(i * n + j)) {
                    count++;
                } else {
                    count = 0;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            //down
            for (int i = n - 1; i >= 0; i--) {
                if (!set.contains(i * n + j)){
                    count++;
                }else {
                    count = 0;
                }
                dp[i][j] = Math.min(dp[i][j], count);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
