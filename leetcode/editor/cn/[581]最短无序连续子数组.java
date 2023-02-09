/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁵ <= nums[i] <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 988 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        //begin和end初始值随便定，若原数组是有序的，要保证end - begin + 1=0
        int begin = 0, end = -1;
        //初始化max和min
        int max = nums[0], min = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            //从左到右寻找中间无序数组的右边界
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
            //从右到左寻找中间无序数组的左边界
            if (nums[nums.length - 1 - i] > min) {
                begin = nums.length - 1 - i;
            } else {
                min = nums[nums.length - 1 - i];
            }
        }
        return end - begin + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
