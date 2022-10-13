/**
给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。 

 

 示例 1： 

 
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
 

 示例 2： 

 
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

 

 提示： 

 
 1 <= nums.length <= 8 
 -10 <= nums[i] <= 10 
 

 

 
 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 

 Related Topics 数组 回溯 👍 30 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(nums, 0, res);

        return res;
    }

    private void helper(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            LinkedList<Integer> permutation = new LinkedList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            res.add(permutation);
        } else {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);

                    swap(nums, i, j);
                    helper(nums, i + 1, res);
                    swap(nums, i, j);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
