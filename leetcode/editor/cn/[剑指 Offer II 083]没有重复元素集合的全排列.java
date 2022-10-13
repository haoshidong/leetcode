/**
给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 

 

 示例 1： 

 
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

 示例 2： 

 
输入：nums = [0,1]
输出：[[0,1],[1,0]]
 

 示例 3： 

 
输入：nums = [1]
输出：[[1]]
 

 

 提示： 

 
 1 <= nums.length <= 6 
 -10 <= nums[i] <= 10 
 nums 中的所有整数 互不相同 
 

 

 
 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 

 Related Topics 数组 回溯 👍 38 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(nums,0,res);

        return res;
    }

    private void helper(int[] nums, int i, List<List<Integer>> res) {
        if(i==nums.length){
            LinkedList<Integer> permutation = new LinkedList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            res.add(permutation);
        }else {
            for (int j = i; j < nums.length; j++) {
                swap(nums,i,j);
                helper(nums,i+1,res);
                swap(nums,i,j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i!=j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
