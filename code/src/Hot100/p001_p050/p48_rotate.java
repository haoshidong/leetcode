package Hot100.p001_p050;

public class p48_rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        while (n > 1) {
            int start = (matrix.length - n) / 2;
            int end = (matrix.length + n) / 2 - 1;
            for (int i = end; i > start; i--) {
                int temp = matrix[start][end - i + start];
                //左-上
                matrix[start][end - i + start] = matrix[i][start];
                //下-左
                matrix[i][start] = matrix[end][i];
                //右-下
                matrix[end][i] = matrix[end - i + start][end];
                //temp-右
                matrix[end - i + start][end] = temp;
            }
            n -= 2;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new p48_rotate().rotate(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num);
            }
            System.out.println("");
        }
    }
}
