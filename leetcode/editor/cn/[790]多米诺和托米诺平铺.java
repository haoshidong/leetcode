/**
有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。 

 

 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 10⁹ + 7 取模 的值。 

 平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。 

 

 示例 1: 

 

 
输入: n = 3
输出: 5
解释: 五种不同的方法如上所示。
 

 示例 2: 

 
输入: n = 1
输出: 1
 

 

 提示： 

 
 1 <= n <= 1000 
 

 Related Topics 动态规划 👍 212 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final long MOD = (long) 1e9 + 7;

    public int numTilings(int n) {
        long[][] dp = new long[2][4];
        dp[1] = new long[]{1, 0, 0, 1};
        dp[0] = new long[]{1, 1, 1, 2};
        for (int i = 3; i <= n; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][3];
            dp[i % 2][1] = (dp[(i - 1) % 2][0] + dp[(i - 1) % 2][2]) % MOD;
            dp[i % 2][2] = (dp[(i - 1) % 2][0] + dp[(i - 1) % 2][1]) % MOD;
            dp[i % 2][3] = (dp[(i - 1) % 2][0] + dp[(i - 1) % 2][1] + dp[(i - 1) % 2][2] + dp[(i - 1) % 2][3]) % MOD;
        }
        return (int) (dp[n % 2][3] % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
