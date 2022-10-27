package 剑指offer.p101_p150;

import java.util.LinkedList;
import java.util.Queue;

public class p116_findCircleNum {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                findCircle(isConnected, i, visited);
                res++;
            }
        }
        return res;
    }

    private void findCircle(int[][] isConnected, int i, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int friend = 0; friend < isConnected.length; friend++) {
                if (isConnected[t][friend] == 1 && !visited[friend]) {
                    queue.offer(friend);
                    visited[friend] = true;
                }
            }
        }
    }
}
