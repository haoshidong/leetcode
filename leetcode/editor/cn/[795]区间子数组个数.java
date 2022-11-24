/**
 * 给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，并
 * 返回满足条件的子数组的个数。
 * <p>
 * 生成的测试用例保证结果符合 32-bit 整数范围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,1,4,3], left = 2, right = 3
 * 输出：3
 * 解释：满足条件的三个子数组：[2], [2, 1], [3]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [2,9,2,5,6], left = 2, right = 8
 * 输出：7
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * 0 <= nums[i] <= 10⁹
 * 0 <= left <= right <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 双指针 👍 225 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        //i0表示大于right的数组下标，i1表示数组在[left,right]的数组下标
        int ans = 0, i0 = -1, i1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                i0 = i;
            }
            //i0更新了,i1也要更新，不然i1-i0为负数
            if (nums[i] >= left) {
                i1 = i;
            }
            ans += i1 - i0;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
