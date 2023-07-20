package test.mt.mt2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*90*/
public class t1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            list.add(new int[]{x, y});
        }
        int ans = maxCapture(a, b, list);
        System.out.println(ans);
    }

    private static int maxCapture(int a, int b, List<int[]> list) {
        int maxcap = 0;
        for (int[] cord1 : list) {
            int minRow = cord1[0];
            int maxRow = cord1[0];
            int minCol = cord1[1];
            int maxCol = cord1[1];
            int capture = 0;
            for (int[] cord2 : list) {
                if (Math.abs(cord2[0] - minRow) <= a && Math.abs(cord2[0] - maxRow) <= a
                        && Math.abs(cord2[1] - minCol) <= b && Math.abs(cord2[1] - maxCol) <= b) {
                    minRow = Math.min(minRow, cord2[0]);
                    maxRow = Math.max(maxRow, cord2[0]);
                    minCol = Math.min(minCol, cord2[1]);
                    maxCol = Math.max(maxCol, cord2[1]);
                    capture++;
                }
            }
            maxcap = Math.max(maxcap, capture);
        }
        return maxcap;
    }
}
