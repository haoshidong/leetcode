package test.threadPoolDemo;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Random;

public class Quicksort {
    public int[] quicksort(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortArray(int[] nums, int start, int end) {
        if (end > start) {
            int pivot = partiton(nums, start, end);
            sortArray(nums, start, pivot - 1);
            sortArray(nums, pivot + 1, end);
        }
    }

    private int partiton(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, end);
        int small = start;
        while (start < end) {
            if (nums[start] < nums[end]) {
                swap(nums, small++, start);
            }
            start++;
        }
        swap(nums, small, end);
        return small;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 9, 17, 58, 8, 6, 21};
        Quicksort sort = new Quicksort();
        int[] sortNums = sort.quicksort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
