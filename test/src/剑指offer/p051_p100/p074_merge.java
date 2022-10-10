package 剑指offer.p051_p100;

import javax.management.MXBean;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class p074_merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        List<int[]> merge = new LinkedList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] temp = intervals[i];
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[j][1]);
                j++;
            }
            merge.add(temp);
            i = j;
        }
        int[][] res = new int[merge.size()][];
        return merge.toArray(res);
    }
}
