package 前500.p1_50;

public class p885_spiralMatrixIII {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int ct = Math.max(rStart + 1, rows - 1 - rStart);
        int temp = Math.max(cStart, cols - 1 - cStart);
        ct = Math.max(ct, temp);
        int k = 0;
        int nums = rows * cols;
        int[][] res = new int[nums][2];
        int i = 0;
        int[] cone = new int[2];
        int[] cone2 = new int[2];
        while(k < ct){
            //此次扫描的起始点
            int row = rStart - k;
            int col = cStart - k;
            k++;
            //右下角
            cone = new int[]{rStart + k,cStart + k};
            //左上角
            cone2 = new int[]{rStart - k, cStart - k};
            for(int c = col; c <= cone[1]; c++){
                if(c < cols && c >= 0 && row >= 0 && row < rows && i < nums){
                    res[i++] = new int[]{row, c};
                }
            }
            for(int r = row + 1; r <= cone[0]; r++){
                if(r >= 0 && r < rows && cone[1] >= 0 && cone[1] < cols && i < nums){
                    res[i++] = new int[]{r, cone[1]};
                }
            }
            for(int c = cone[1] - 1; c >= cone2[1]; c--){
                if(c >= 0 && c < cols && cone[0] >= 0 && cone[0] < rows && i < nums){
                    res[i++] = new int[]{cone[0], c};
                }
            }
            for(int r = cone[0] - 1; r > cone2[0]; r--){
                if(r >= 0 && r < rows && cone2[1] >= 0 && cone2[1] < cols && i < nums){
                    res[i++] = new int[]{r, cone2[1]};
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //rows = 1, cols = 4, rStart = 0, cStart = 0
        int rows = 1;
        int cols = 4;
        int rStart = 0;
        int cStart = 0;
        p885_spiralMatrixIII test = new p885_spiralMatrixIII();
        int[][] ints = test.spiralMatrixIII(rows, cols, rStart, cStart);
        for (int[] num : ints) {
            System.out.print("[" + num[0] + "," + num[1] + "] ");
        }
    }
}
