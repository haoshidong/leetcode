/**
一个正整数如果能被 a 或 b 整除，那么它是神奇的。 

 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 10⁹ + 7 取模 后的值。 

 

 
 

 示例 1： 

 
输入：n = 1, a = 2, b = 3
输出：2
 

 示例 2： 

 
输入：n = 4, a = 2, b = 3
输出：6
 

 

 提示： 

 
 1 <= n <= 10⁹ 
 2 <= a, b <= 4 * 10⁴ 
 

 

 Related Topics 数学 二分查找 👍 146 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static final long MOD = (long) 1e9 + 7;

    public int nthMagicalNumber(int n, int a, int b) {
        long lcm = a / gcd(a, b) * b;
        long l = 0, r = (long) Math.min(a, b) * n;
        while (l + 1 < r) {
            long mid = (l + r) / 2;
            if (mid / a + mid / b - mid / lcm >= n) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return (int) (r % MOD);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
