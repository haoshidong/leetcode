/**
给定你一个整数数组
 nums 

 我们要将
 nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和
 B 数组不为空，并且
 average(A) == average(B) 。 

 如果可以完成则返回true ， 否则返回 false 。 

 注意：对于数组
 arr , 
 average(arr) 是
 arr 的所有元素除以
 arr 长度的和。 

 

 示例 1: 

 
输入: nums = [1,2,3,4,5,6,7,8]
输出: true
解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
 

 示例 2: 

 
输入: nums = [3,1]
输出: false
 

 

 提示: 

 
 1 <= nums.length <= 30 
 0 <= nums[i] <= 10⁴ 
 

 Related Topics 位运算 数组 数学 动态规划 状态压缩 👍 133 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return false;
        }
        int s = Arrays.stream(nums).sum();
        //nums的总和为0，只需从nums中分割出子数组和为0就算分割成功，但子数组的个数不能等于n
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - s;
        }
        int m = n >> 1;
        Set<Integer> vis = new HashSet<>();
        //子数组若只存在于前半部分，枚举前半部分的所有组合，总和为0则分割成功，否则存于set中，用来查询后半数组。
        for (int i = 1; i < 1 << m; i++) {
            int t = 0;
            for (int j = 0; j < m; j++) {
                if (((i >> j) & 1) == 1) {
                    t += nums[j];
                }
            }
            //分隔成功
            if (t == 0) {
                return true;
            }
            //分割失败，子数组可能全在后半数组，或部分前半数组+部分后半数组（总个数最多为n-1）
            vis.add(t);
        }
        //子数组不在前半部分
        for (int i = 1; i < 1 << (n - m); i++) {
            int t = 0;
            for (int j = 0; j < (n - m); j++) {
                if (((i >> j) & 1) == 1) {
                    t += nums[m + j];
                }
            }
            //若后半部分有子数组总和为0，直接返回true；若后半部分子数组的总和为t，且在前半部分数组set中有对应的-t，则查找成功
            //注意！分割出来的子数组总个数不能为n
            if (t == 0 || (i != (1 << (n - m)) - 1) && vis.contains(-t)) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
