package 剑指offer.p101_p150;

import java.util.LinkedList;
import java.util.Queue;

public class p106_isBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] dp = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int col = queue.poll();
                int val = dp[col];
                for (int j = 0; j < graph[col].length; j++) {
                    int cur = graph[col][j];
                    if (dp[cur] == val) {
                        return false;
                    } else if (dp[cur] == 0) {
                        queue.offer(cur);
                        if (val == 1) {
                            dp[cur] = 2;
                        } else if (val == 2) {
                            dp[cur] = 1;
                        }
                    }
                }
            }
        }

        return true;
    }
}
