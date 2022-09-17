/**
给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 

 

 示例 1： 

 
输入：timePoints = ["23:59","00:00"]
输出：1
 

 示例 2： 

 
输入：timePoints = ["00:00","23:59","00:00"]
输出：0
 

 

 提示： 

 
 2 <= timePoints <= 2 * 10⁴ 
 timePoints[i] 格式为 "HH:MM" 
 

 

 
 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/ 

 Related Topics 数组 数学 字符串 排序 👍 28 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        int i = 0;
        for (String str : timePoints) {
            int minute = (str.charAt(0) * 10 + str.charAt(1)) * 60 + str.charAt(3) * 10 + str.charAt(4);
            minutes[i] = minute;
            i++;
        }
        Arrays.sort(minutes);
        int x = 24 * 60;
        int differ = minutes[minutes.length - 1] - minutes[0];
        int min = differ < x / 2 ? differ : x - differ;
        for (int j = 0; j < minutes.length - 1; j++) {
            differ = minutes[j + 1] - minutes[j] < x / 2 ? minutes[j + 1] - minutes[j] : x - (minutes[j + 1] - minutes[j]);
            min = Math.min(min, differ);
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
