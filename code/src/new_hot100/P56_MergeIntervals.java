package new_hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P56_MergeIntervals {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = res.get(res.size() - 1);
            if(ints[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                ints[1] = Math.max(ints[1], intervals[i][1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P56_MergeIntervals().new Solution(); 
    }
}