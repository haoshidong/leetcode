/**
给定一个包含红色、白色和蓝色、共 n 个元素的数组
 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 

 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 

 
 

 必须在不使用库的sort函数的情况下解决这个问题。 

 

 示例 1： 

 
输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
 

 示例 2： 

 
输入：nums = [2,0,1]
输出：[0,1,2]
 

 

 提示： 

 
 n == nums.length 
 1 <= n <= 300 
 nums[i] 为 0、1 或 2 
 

 

 进阶： 

 
 你可以不使用代码库中的排序函数来解决这道题吗？ 
 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
 

 Related Topics 数组 双指针 排序 👍 1455 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        //l用来存放0的下标，r用来存放1的下标
        int n = nums.length, l = 0, r = n - 1;
        //i用来遍历数组
        int i = 0;
        //[0,l-1]和[r+1,n-1]两个子数组已经正确存放0和2
        while (i <= r) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                if (i == l) {   //当前数字已经在正确的位置，遍历数组的下一个位置，i+1
                    i++;
                }else {
                    swap(nums, l, i);   //0不在正确位置，与下标l的数字交换，i不变
                }
                l++;//l指向下一个需要存放0的下标
            } else {    //将2放到正确位置，与下标r的数字交换
                swap(nums,r,i);
                r--;//r指向下一个需要存放2的下标
            }
        }
    }

    private void swap(int[] nums, int l, int i) {
        int temp = nums[i];
        nums[i] = nums[l];
        nums[l] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
