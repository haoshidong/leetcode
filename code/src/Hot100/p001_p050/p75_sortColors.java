package Hot100.p001_p050;

public class p75_sortColors {
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
