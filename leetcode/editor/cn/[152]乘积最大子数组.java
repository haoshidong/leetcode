/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= nums.length <= 2 * 10⁴
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 1849 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        //动态规划
        int imax = 1, imin = 1, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int temp = imin;
                imin = imax;
                imax = temp;
            }
            //状态转移方程
            imax = Math.max(num, imax * num);
            imin = Math.min(num, imin * num);
            max = Math.max(max, imax);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
