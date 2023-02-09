package Hot100.p051_p100;

public class p581_findUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        //begin和end初始值随便定，若原数组是有序的，要保证end - begin + 1=0
        int begin = 0, end = -1;
        //初始化max和min
        int max = nums[0], min = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            //从左到右寻找中间无序数组的右边界
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
            //从右到左寻找中间无序数组的左边界
            if (nums[nums.length - 1 - i] > min) {
                begin = nums.length - 1 - i;
            } else {
                min = nums[nums.length - 1 - i];
            }
        }
        return end - begin + 1;
    }
}
