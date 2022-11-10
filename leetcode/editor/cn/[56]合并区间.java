/**
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 
一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 

 

 示例 1： 

 
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 

 示例 2： 

 
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 

 

 提示： 

 
 1 <= intervals.length <= 10⁴ 
 intervals[i].length == 2 
 0 <= starti <= endi <= 10⁴ 
 

 Related Topics 数组 排序 👍 1703 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
