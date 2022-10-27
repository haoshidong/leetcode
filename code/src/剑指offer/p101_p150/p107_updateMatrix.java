package 剑指offer.p101_p150;

import java.util.LinkedList;
import java.util.Queue;

public class p107_updateMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dists = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    dists[i][j] = 0;
                    queue.offer(new int[]{i, j});    //从距离最小的节点开始计算周围节点的最小距离，保证全局最小；
                } else {
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int dist = dists[pos[0]][pos[1]];
            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    if (dists[r][c] > dist) {
                        dists[r][c] = dist + 1;
                        //将次最小距离的节点纳入队列中，保证从距离为0的周围节点距离计算完后，再将距离为1的周围节点计算相邻节点距离。。。
                        queue.offer(new int[]{r, c});
                    }
                }
            }
        }
        return dists;
    }

    /*public static void main(String[] args) {
        int[][] mat = new int[][]{{0},{1}};
        mat = updateMatrix(mat);
        for (int[] x: mat) {
            for (int a : x) {
                System.out.println(a);
            }
        }
    }*/
}
