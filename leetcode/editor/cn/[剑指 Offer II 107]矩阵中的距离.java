/**
给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 

 两个相邻元素间的距离为 1 。 

 

 示例 1： 

 

 
输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
输出：[[0,0,0],[0,1,0],[0,0,0]]
 

 示例 2： 

 

 
输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
输出：[[0,0,0],[0,1,0],[1,2,1]]
 

 

 提示： 

 
 m == mat.length 
 n == mat[i].length 
 1 <= m, n <= 10⁴ 
 1 <= m * n <= 10⁴ 
 mat[i][j] is either 0 or 1. 
 mat 中至少有一个 0 
 

 

 
 注意：本题与主站 542 题相同：https://leetcode-cn.com/problems/01-matrix/ 

 Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 35 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dists = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    dists[i][j] = 0;
                    queue.offer(new int[]{i, j});    //从距离最小的节点开始计算周围节点的最小距离，保证全局最小；
                } else {
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int dist = dists[pos[0]][pos[1]];
            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    if (dists[r][c] > dist) {
                        dists[r][c] = dist + 1;
                        //将次最小距离的节点纳入队列中，保证从距离为0的周围节点距离计算完后，再将距离为1的周围节点计算相邻节点距离。。。
                        queue.offer(new int[]{r, c});
                    }
                }
            }
        }
        return dists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
