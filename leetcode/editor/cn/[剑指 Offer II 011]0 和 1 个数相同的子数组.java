/**
给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 

 

 示例 1： 

 
输入: nums = [0,1]
输出: 2
说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 

 示例 2： 

 
输入: nums = [0,1,0]
输出: 2
说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。 

 

 提示： 

 
 1 <= nums.length <= 10⁵ 
 nums[i] 不是 0 就是 1 
 

 

 
 注意：本题与主站 525 题相同： https://leetcode-cn.com/problems/contiguous-array/ 

 Related Topics 数组 哈希表 前缀和 👍 94 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0,-1);           // 若最长子数组的起始下标是0，则需要在put(nums[0],0)之前添加这项。
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]==0 ? -1 : 1;
            if (sumToIndex.containsKey(sum)){
                maxLength = Math.max(maxLength, i-sumToIndex.get(sum));
            }else {
                sumToIndex.put(sum,i);
            }
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
