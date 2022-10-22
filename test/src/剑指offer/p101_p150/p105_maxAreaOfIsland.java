package 剑指offer.p101_p150;

import java.util.LinkedList;
import java.util.Queue;

public class p105_maxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = getArea(grid, i, j, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int getArea(int[][] grid, int i, int j, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int area = 0;

        while (!queue.isEmpty()) {
            int[] pose = queue.poll();
            area++;
            for (int[] dir : dirs) {
                int r = pose[0] + dir[0];
                int c = pose[1] + dir[1];
                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length
                        && grid[r][c] == 1 && !visited[r][c]) {
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return area;
    }
}
