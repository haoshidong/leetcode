package 剑指offer;

public class p009_numSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int count = 0;
        int product = 1;
        for (int right=0;right<nums.length;right++){
            product *= nums[right];
            while (right>=left && product >= k){
                product /= nums[left++];
            }
            count += right >= left ? right-left+1 : 0;  //右指针固定，加上新的子数组个数
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int ans = new p009_numSubarrayProductLessThanK().numSubarrayProductLessThanK(nums,100);
        System.out.println(ans);
    }

}
