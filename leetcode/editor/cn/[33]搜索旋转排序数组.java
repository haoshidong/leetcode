/**
整数数组 nums 按升序排列，数组中的值 互不相同 。 

 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+
1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4
,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 

 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 

 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 

 

 示例 1： 

 
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
 

 示例 2： 

 
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1 

 示例 3： 

 
输入：nums = [1], target = 0
输出：-1
 

 

 提示： 

 
 1 <= nums.length <= 5000 
 -10⁴ <= nums[i] <= 10⁴ 
 nums 中的每个值都 独一无二 
 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
 -10⁴ <= target <= 10⁴ 
 

 Related Topics 数组 二分查找 👍 2379 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int[] find = findIcrease(nums, target, 0, nums.length - 1);
        //不存在target
        if (find[0] == -1) return -1;
        //target的值在find区间内，寻找此区间是否存在num值为target的值。
        int ans = findTarget(nums, find[0], find[1], target);
        return ans;
    }

    private int findTarget(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        //未找到target值，返回-1
        return -1;
    }

    private int[] findIcrease(int[] nums, int target, int start, int end) {
        if (nums[start] <= nums[end] && target >= nums[start]) {
            //得到二分查找的区间段，target在此区间中
            return new int[]{start, end};
        }
        if (nums[start] > nums[end]) {
            int mid = (start + end) >> 1;
            //判定左半部分
            if (target >= nums[start]) {
                //如果左半部分递增，且值均小于target,目标数组在右半部分。例如[2,4,5,6,7,0,1]查找7。
                if (nums[start] <= nums[mid] && target > nums[mid]) return findIcrease(nums, target, mid + 1, end);
                return findIcrease(nums, target, start, mid);
                //判定右半部分
            } else {
                //如果右半部分递增，且值均大于target，目标数组在左半部分。例如[6,7,0,1,2,4,5]查找0。
                if (nums[mid + 1] <= nums[end] && target < nums[mid + 1]) return findIcrease(nums, target, start, mid);
                return findIcrease(nums, target, mid + 1, end);
            }
        }
        //没找到target所在区间
        return new int[]{-1, -1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
