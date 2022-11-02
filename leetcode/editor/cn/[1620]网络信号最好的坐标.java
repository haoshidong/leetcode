/**
给你一个数组 towers 和一个整数 radius 。 

 数组 towers 中包含一些网络信号塔，其中 towers[i] = [xi, yi, qi] 表示第 i 个网络信号塔的坐标是 (xi, yi) 且信号强
度参数为 qi 。所有坐标都是在 X-Y 坐标系内的 整数 坐标。两个坐标之间的距离用 欧几里得距离 计算。 

 整数 radius 表示一个塔 能到达 的 最远距离 。如果一个坐标跟塔的距离在 radius 以内，那么该塔的信号可以到达该坐标。在这个范围以外信号会很微弱
，所以 radius 以外的距离该塔是 不能到达的 。 

 如果第 i 个塔能到达 (x, y) ，那么该塔在此处的信号为 ⌊qi / (1 + d)⌋ ，其中 d 是塔跟此坐标的距离。一个坐标的 信号强度 是所有 能
到达 该坐标的塔的信号强度之和。 

 请你返回数组 [cx, cy] ，表示 信号强度 最大的 整数 坐标点 (cx, cy) 。如果有多个坐标网络信号一样大，请你返回字典序最小的 非负 坐标。 


 注意： 

 
 坐标 (x1, y1) 字典序比另一个坐标 (x2, y2) 小，需满足以下条件之一： 
 

 
 要么 x1 < x2 ， 
 要么 x1 == x2 且 y1 < y2 。 
 
 
 ⌊val⌋ 表示小于等于 val 的最大整数（向下取整函数）。 


 

 示例 1： 
 
 
输入：towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
输出：[2,1]
解释：
坐标 (2, 1) 信号强度之和为 13
- 塔 (2, 1) 强度参数为 7 ，在该点强度为 ⌊7 / (1 + sqrt(0)⌋ = ⌊7⌋ = 7
- 塔 (1, 2) 强度参数为 5 ，在该点强度为 ⌊5 / (1 + sqrt(2)⌋ = ⌊2.07⌋ = 2
- 塔 (3, 1) 强度参数为 9 ，在该点强度为 ⌊9 / (1 + sqrt(1)⌋ = ⌊4.5⌋ = 4
没有别的坐标有更大的信号强度。 

 示例 2： 

 
输入：towers = [[23,11,21]], radius = 9
输出：[23,11]
解释：由于仅存在一座信号塔，所以塔的位置信号强度最大。 

 示例 3： 

 
输入：towers = [[1,2,13],[2,1,7],[0,1,9]], radius = 2
输出：[1,2]
解释：坐标 (1, 2) 的信号强度最大。 

 

 提示： 

 
 1 <= towers.length <= 50 
 towers[i].length == 3 
 0 <= xi, yi, qi <= 50 
 1 <= radius <= 50 
 

 Related Topics 数组 枚举 👍 42 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[][] g = new int[101][101];
        int max = 0, x = 0, y = 0;
        //遍历每个塔，将其对周围坐标的影响加到相应坐标上
        for (int[] tower : towers) {
            int a = tower[0], b = tower[1], q = tower[2];
            //遍历受当前塔影响的每个坐标点
            for (int i = Math.max(0, a - radius); i <= a + radius; i++) {
                for (int j = Math.max(0, b - radius); j <= b + radius; j++) {
                    int dis = (a - i) * (a - i) + (b - j) * (b - j);
                    //在影响范围之外，跳过
                    if (dis > radius * radius) continue;
                    g[i][j] += Math.floor(q / (1 + Math.sqrt(dis)));
                    //若坐标信号最好，得到当前坐标值
                    if (g[i][j] > max) {
                        max = g[i][j]; x = i; y = j;
                        //若坐标信号一样好，根据条件决定是否替换坐标值
                    } else if (g[i][j] == max && (i < x || (i == x && j < y))) {
                        x = i; y = j;
                    }
                }
            }
        }
        return new int[]{x, y};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
