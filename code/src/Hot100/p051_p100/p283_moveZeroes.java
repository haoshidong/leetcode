package Hot100.p051_p100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class p283_moveZeroes {
    private static int[] nums = {0, 1, 0};

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        for (int j = 0; j < n; i++, j++) {
            while (j < n && nums[j] == 0) {
                j++;
            }
            if (j < n) {
                nums[i] = nums[j];
            } else {
                break;
            }
        }
        while (i < n) {
            nums[i++] = 0;
        }
    }

    public static void main(String[] args) {
        new p283_moveZeroes().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
