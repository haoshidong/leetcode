/**
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 

 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
。 

 示例 1： 

 
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 

 示例 2： 

 
输入：nums = [0,1,0,3,2,3]
输出：4
 

 示例 3： 

 
输入：nums = [7,7,7,7,7,7,7]
输出：1
 

 

 提示： 

 
 1 <= nums.length <= 2500 
 -10⁴ <= nums[i] <= 10⁴ 
 

 

 进阶： 

 
 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
 

 Related Topics 数组 二分查找 动态规划 👍 2878 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        //动态规划+二分查找
        int[] tails = new int[nums.length];
        //res表示tails中下一个待插入元素的空位置
        int res = 0;
        //遍历nums数组
        for (int num : nums) {
            //i,j分别指向tails的首和尾
            int i = 0, j = res;
            //寻找当前num在tails数组中将要插入的下标（二分法）
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            //将下标i的元素替换为num，num肯定小于原来的tails[i]，大于tails[i-1]
            tails[i] = num;
            //j一直没变化过，说明待插入下标i变化为j，num插入到tails中最后一个元素，长度加1，即res+1
            if (res == j) {
                res++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
