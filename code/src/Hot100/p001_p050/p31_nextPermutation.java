package Hot100.p001_p050;

import com.sun.org.apache.bcel.internal.generic.INEG;
import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.*;

public class p31_nextPermutation {
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

    private void swap(int[] nums, int i) {
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
