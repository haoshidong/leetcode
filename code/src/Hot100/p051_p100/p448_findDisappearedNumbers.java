package Hot100.p051_p100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p448_findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /*int len = nums.length;
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int j = 0;
        for (int i = 1; i <= len && j < len; i++) {
            //去掉重复元素
            while (j + 1 < len && nums[j] == nums[j + 1]) {
                j++;
            }
            //相等则查看数组的下一个元素，若数组走到末尾，则下标不变
            if (nums[j] == i && j + 1 < len) {
                j++;
                //不相等，则保存元素i的值
            } else if (nums[j] != i) {
                res.add(i);
            }
        }
        return res;*/

        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> ans = new p448_findDisappearedNumbers().findDisappearedNumbers(nums);
        for (int an : ans) {
            System.out.print(an + " ");
        }

    }
}
