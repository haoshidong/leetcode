/**
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 * <p>
 * 正数的平方根有两个，只输出其中的正数平方根。
 * <p>
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: x = 4
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: x = 8
 * 输出: 2
 * 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * <p>
 * 0 <= x <= 2³¹ - 1
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 69 题相同： https://leetcode-cn.com/problems/sqrtx/
 * <p>
 * Related Topics 数学 二分查找 👍 37 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
//            if ((long)mid * mid <= x && (long)((mid + 1) * (mid + 1)) > x) {
//                ans = mid;
//            }
            if ((long)mid * mid > x) {
                right = mid-1;
            } else {
                ans = mid;
                left = mid+1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
