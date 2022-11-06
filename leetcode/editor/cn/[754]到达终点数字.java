/**
在一根无限长的数轴上，你站在0的位置。终点在target的位置。 

 你可以做一些数量的移动 numMoves : 

 
 每次你可以选择向左或向右移动。 
 第 i 次移动（从 i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。 
 

 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。 

 

 示例 1: 

 
输入: target = 2
输出: 3
解释:
第一次移动，从 0 到 1 。
第二次移动，从 1 到 -1 。
第三次移动，从 -1 到 2 。
 

 示例 2: 

 
输入: target = 3
输出: 2
解释:
第一次移动，从 0 到 1 。
第二次移动，从 1 到 3 。
 

 

 提示: 

 
 -10⁹ <= target <= 10⁹ 
 target != 0 
 

 Related Topics 数学 二分查找 👍 248 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reachNumber(int target) {
        //情况1：n步之和为n * (n + 1) / 2，和≥target，若等于target，则与target之差为0，步数为n
        //情况2：  若不等于target，且差为偶数，则将差/2的步数向左走，即可到达target，步数为n
        //情况3：      若不等于target，且差为奇数、n为偶数，则再走n+1步，此时差变为偶数，将差/2步数向左走，即可到达target，步数为n+1
        //情况4：      若不等于target，且差为奇数、n为奇数，则再走n+1步、n+2步，此时差变为偶数，将差/2步数向左走，即可到达target，步数为n+2
        //情况3和4合并为n + 1 + n % 2
        target = Math.abs(target);
        //注意8*target越过int最大值，使用double类型计算
        int n = (int) Math.ceil((Math.sqrt(8L * target + 1) - 1) / 2);
        return (n * (n + 1) / 2 - target) % 2 == 0 ? n : n + 1 + n % 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
