package 剑指offer.p051_p100;

import java.net.Inet4Address;
import java.util.HashMap;

public class p093_lenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            map.put(arr[i], i);
        }
        int[][] dp = new int[length][length];
        int res = 2;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                dp[i][j] = k != -1 && k < j ? dp[j][k] + 1 : 2;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res > 2 ? res : 0;
    }
}
