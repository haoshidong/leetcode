/**
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 

 你返回所有和为 0 且不重复的三元组。 

 注意：答案中不可以包含重复的三元组。 

 

 

 示例 1： 

 
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
 

 示例 2： 

 
输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
 

 示例 3： 

 
输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。
 

 

 提示： 

 
 3 <= nums.length <= 3000 
 -10⁵ <= nums[i] <= 10⁵ 
 

 
 注意：本题与主站 15 题相同：leetcode.cn/problems/3sum/ 

 Related Topics 数组 双指针 排序 👍 81 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums.length>2) {
            Arrays.sort(nums);
            int i = 0;
            while (i<nums.length-2){        //不能用for循环，否则与18行的i++导致i增加2次。
                twoSum(nums, result, i);
                int temp = nums[i];
                while (i<nums.length && nums[i]==temp){
                    ++i;
                }
            }
        }
        return result;
    }

    public void twoSum(int[] nums, List<List<Integer>> result, int i) {
        int j = i+1;
        int k = nums.length-1;
        while (j<k){
            if (nums[i]+nums[j]+nums[k]<0){
                ++j;
            } else if (nums[i]+nums[j]+nums[k]>0) {
                --k;
            }else {
                result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                int temp = nums[j];
                while (nums[j]==temp && j<k){
                    j++;
                }

            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
