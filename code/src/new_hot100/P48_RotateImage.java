package new_hot100;

import java.util.Arrays;

class P48_RotateImage {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        for (int k = 0; k < n/2; k++) {
            int cur = n - 2 * k - 1;
            for (int i = 0; i < cur; i++) {
                int temp = matrix[k][k + i];
                matrix[k][k + i] = matrix[k + cur-i][k];
                matrix[k + cur-i][k] = matrix[k + cur][k + cur-i];
                matrix[k + cur][k + cur-i] = matrix[k+i][k+cur];
                matrix[k+i][k+cur] = temp;
            }
        }
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P48_RotateImage().new Solution();
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(ints);
        System.out.println(Arrays.toString(ints));
    }
}