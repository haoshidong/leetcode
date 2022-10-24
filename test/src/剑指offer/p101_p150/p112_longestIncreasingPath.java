package 剑指offer.p101_p150;

import java.util.LinkedList;
import java.util.Queue;

public class p112_longestIncreasingPath {
//    static int[][] lengths = new int[3][3];
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] lengths = new int[rows][cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dfs(matrix, i, j, lengths));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] lengths) {
        if (lengths[i][j] != 0) {
            return lengths[i][j];
        }

        int length = 1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] > matrix[i][j]) {
                int path = dfs(matrix, r, c, lengths);
                length = Math.max(length, path+1);  //比较不同分支的长度，取最大值
//                length += path;   //将不同分支的长度累加
            }
        }
        lengths[i][j] = length;
        return length;
    }

//    public static void main(String[] args) {
//        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
//        int res = new p112_longestIncreasingPath().longestIncreasingPath(matrix);
//        System.out.println(res);
//        for (int[] x: lengths) {
//            for (int a : x) {
//                System.out.print(a);
//            }
//            System.out.println();
//        }
//    }

}
