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
 

 Related Topics 数组 双指针 排序 👍 5351 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //定义一个结果集
        List<List<Integer>> res = new LinkedList<>();
        int len = nums.length;
        //当前数组的长度为空，或者长度小于3，直接退出
        if (nums == null || len < 3) return res;
        Arrays.sort(nums);
        //遍历数组中的每一个元素
        for (int i = 0; i < len; i++) {
            //若遍历的起始元素大于0，直接退出
            if (nums[0] > 0) break;
            //去重，若当前遍历元素等于前一个元素，跳过这次循环
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;  //不能从下标0开始，不然结果会重复。
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;    //去重
                    while (l < r && nums[r] == nums[r - 1]) r--;    //去重
                    l++;    //继续搜索下一组满足答案的值
                    r--;    //继续搜索下一组满足答案的值
                } else if (sum < 0) l++;    //sum太小，将l值增大
                else r--;   //sum值太大，将r值减小
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
