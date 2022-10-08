/**
给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。 

 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。 

 

 示例 1: 

 
输入: nums = [1,1,2,3,3,4,4,8,8]
输出: 2
 

 示例 2: 

 
输入: nums =  [3,3,7,7,10,11,11]
输出: 10
 

 

 
 

 提示: 

 
 1 <= nums.length <= 10⁵ 
 0 <= nums[i] <= 10⁵ 
 

 

 
 注意：本题与主站 540 题相同：https://leetcode-cn.com/problems/single-element-in-a-sorted-
array/ 

 Related Topics 数组 二分查找 👍 46 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length / 2;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            index = mid * 2;
            if (index<nums.length-2 && nums[index] != nums[index + 1]) {
                if (mid == 0 || nums[index - 2] == nums[index - 1]) {
                    return nums[index];
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[index];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
