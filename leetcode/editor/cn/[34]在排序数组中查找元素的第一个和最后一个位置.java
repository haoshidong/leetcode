/**
给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 

 如果数组中不存在目标值 target，返回 [-1, -1]。 

 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 

 

 示例 1： 

 
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4] 

 示例 2： 

 
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1] 

 示例 3： 

 
输入：nums = [], target = 0
输出：[-1,-1] 

 

 提示： 

 
 0 <= nums.length <= 10⁵ 
 -10⁹ <= nums[i] <= 10⁹ 
 nums 是一个非递减数组 
 -10⁹ <= target <= 10⁹ 
 

 Related Topics 数组 二分查找 👍 1978 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        //target在给定数组范围之外，或数组不存在
        if (len==0 || target < nums[0] || target > nums[len - 1]) return new int[]{-1, -1};
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            //找到target
            if (nums[mid] == target) {
                l = r = mid;
                while (l > 0 && nums[l - 1] == target) l--;
                while (r < len - 1 && nums[r + 1] == target) r++;
                return new int[]{l, r};
            }
            //target在左半部分
            if (target < nums[mid]) r = mid - 1;
                //target在右半部分
            else l = mid + 1;
        }
        //未找到target
        return new int[]{-1,-1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
