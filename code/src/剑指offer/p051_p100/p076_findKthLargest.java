package 剑指offer.p051_p100;

import java.util.Random;

public class p076_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != target) {
            if (index < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(nums, start, end);
        }
        return nums[target];
    }

    private int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, end);
        int small = start - 1;
        while (start < end) {
            if (nums[start] < nums[end]) {
                small++;
                swap(nums, small, start);
            }
            start++;
        }
        swap(nums, ++small, end);
        return small;
    }

    private void swap(int[] nums, int random, int end) {
        if (random != end) {
            int temp = nums[random];
            nums[random] = nums[end];
            nums[end] = temp;
        }
    }
}
