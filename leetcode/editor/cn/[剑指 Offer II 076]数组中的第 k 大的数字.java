/**
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 

 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 

 

 示例 1: 

 
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
 

 示例 2: 

 
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4 

 

 提示： 

 
 1 <= k <= nums.length <= 10⁴ 
 -10⁴ <= nums[i] <= 10⁴ 
 

 

 
 注意：本题与主站 215 题相同： https://leetcode-cn.com/problems/kth-largest-element-in-an-
array/ 

 Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 50 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != target) {
            if (index < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(nums, start, end);
        }
        return nums[target];
    }

    private int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, end);
        int small = start - 1;
        while (start < end) {
            if (nums[start] < nums[end]) {
                small++;
                swap(nums, small, start);
            }
            start++;
        }
        swap(nums, ++small, end);
        return small;
    }

    private void swap(int[] nums, int random, int end) {
        if (random != end) {
            int temp = nums[random];
            nums[random] = nums[end];
            nums[end] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
