package Hot100.p001_p050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p56_merge {
    public int[][] merge(int[][] intervals) {
        //将intervals按intervals[i]的第一个元素递增排序
        Arrays.sort(intervals,(int[] a,int[] b) -> a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int min_left = intervals[i][0];
            int max_right = intervals[i][1];
            //如果需要合并，找到右边界，更新i值
            if (i + 1 < intervals.length && intervals[i][1] >= intervals[i + 1][0]) {
                max_right = Math.max(max_right, intervals[i+1][1]);
                //i指向需要合并的数组的最后一个
                while (i + 1 < intervals.length && max_right >= intervals[i + 1][0]) {
                    i++;
                    max_right = Math.max(max_right, intervals[i][1]);
                }
            }
            list.add(new int[]{min_left, max_right});
        }
        /*int[][] ans = new int[list.size()][2];
        int i = 0;
        for (int[] interval: list) {
            ans[i][0] = interval[0];
            ans[i++][1] = interval[1];
        }*/
        return list.toArray(new int[list.size()][]);
    }
}
