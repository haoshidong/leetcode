package 每日一题;

public class p2373_largestLocal {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int a = grid[i - 1][j - 1];
                int b = Math.max(grid[i - 1][j], a);
                int c = Math.max(grid[i - 1][j + 1], b);
                int d = Math.max(grid[i][j - 1], c);
                int e = Math.max(grid[i][j + 1], d);
                int f = Math.max(grid[i + 1][j - 1], e);
                int g = Math.max(grid[i + 1][j], f);
                int h = Math.max(grid[i + 1][j + 1], g);
                ans[i - 1][j - 1] = Math.max(grid[i][j], h);
            }
        }
        return ans;
    }
}
