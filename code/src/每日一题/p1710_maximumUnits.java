package 每日一题;

import java.util.Arrays;
import java.util.Comparator;

public class p1710_maximumUnits {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //升序排序
        Arrays.sort(boxTypes, (a, b) -> a[1] - b[1]);
        int ans = 0;
        for (int i = boxTypes.length - 1; i >= 0 && truckSize > 0; i--) {
            if (truckSize >= boxTypes[i][0]) {
                ans += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                ans += truckSize * boxTypes[i][1];
                truckSize = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        int ans = new p1710_maximumUnits().maximumUnits(boxTypes, truckSize);
        System.out.println(ans);
    }
}
