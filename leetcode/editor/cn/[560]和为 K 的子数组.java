/**
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。 

 

 示例 1： 

 
输入：nums = [1,1,1], k = 2
输出：2
 

 示例 2： 

 
输入：nums = [1,2,3], k = 3
输出：2
 

 

 提示： 

 
 1 <= nums.length <= 2 * 10⁴ 
 -1000 <= nums[i] <= 1000 
 -10⁷ <= k <= 10⁷ 
 

 Related Topics 数组 哈希表 前缀和 👍 1787 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> sumToCount = new HashMap<>();
        int pathSum = 0;
        sumToCount.put(0, 1);
        for (int num : nums) {
            pathSum += num;
            if (sumToCount.containsKey(pathSum - k)) {
                ans += sumToCount.get(pathSum - k);
            }
            sumToCount.put(pathSum, sumToCount.getOrDefault(pathSum, 0) + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
