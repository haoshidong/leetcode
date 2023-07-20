package test.mt;

import java.util.Scanner;

public class t2 {
    static int max = 0;

    public static void maxCash(char[][] color, int[][] cash, int k) {
        int cur = 0;
        int n = color.length, m = color[0].length;
        boolean[][] isvisited = new boolean[n][m];
        dfs(color, cash, isvisited, 0, 0, cur, k);
    }

    private static void dfs(char[][] color, int[][] cash, boolean[][] isvisited, int row, int col, int cur, int k) {
        if (row >= 0 && row < color.length && col >= 0 && col <= color[0].length) {
            int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//上下左右
            for (int[] d : dir) {
                int n = row + d[0];
                int m = col + d[1];
                if (n >= 0 && n < color.length && m >= 0 && m < color[0].length && !isvisited[n][m]) {
                    isvisited[row][col] = true;
                    if (color[row][col] == color[n][m]) {
                        max = Math.max(max, cur + cash[n][m]);
                        dfs(color, cash, isvisited, n, m, cur + cash[n][m], k);
                    } else if (cur >= k) {
                        max = Math.max(max, cur - k + cash[n][m]);
                        dfs(color, cash, isvisited, n, m, cur - k + cash[n][m], k);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            char[][] color = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = in.next();
                color[i] = s.toCharArray();
            }
            int[][] cash = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    cash[i][j] = in.nextInt();
                }
            }
            maxCash(color, cash, k);
            System.out.println(max);
        }
    }
}
