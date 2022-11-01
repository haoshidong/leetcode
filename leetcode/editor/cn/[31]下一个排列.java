/**
整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 

 
 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
 

 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在
这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 

 
 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
 

 给你一个整数数组 nums ，找出 nums 的下一个排列。 

 必须 原地 修改，只允许使用额外常数空间。 

 

 示例 1： 

 
输入：nums = [1,2,3]
输出：[1,3,2]
 

 示例 2： 

 
输入：nums = [3,2,1]
输出：[1,2,3]
 

 示例 3： 

 
输入：nums = [1,1,5]
输出：[1,5,1]
 

 

 提示： 

 
 1 <= nums.length <= 100 
 0 <= nums[i] <= 100 
 

 Related Topics 数组 双指针 👍 1958 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //从个位到高位开始遍历，找到第一个高位小于低位的位置。
        while (i>=0 && nums[i] >= nums[i+1]) i--;
        //将低位重新排列
        int j = nums.length - 1;
        if (i>=0) {
            //寻找i之后大于nums[i]且最小的下标j
            while (j > i && nums[j] <= nums[i]) j--;
            //交换i和j的位置
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        //对i+1 到 num.lenth-1之间的数字升序排列
        int[] a = new int[nums.length-i-1];
        for (int k = 0; k < a.length; k++) {
            a[k] = nums[k+i+1];
        }
        //升序后替换原数组的后面
        Arrays.sort(a);
        for (int k = 0; k < a.length; k++) {
            nums[k+i+1] = a[k];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
