package test.metaapp;

import java.util.ArrayList;

public class t13 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 9, 1, 2, 6};
        int res = solution3(nums);
        System.out.println(res);
    }

    public static int solution3(int[] nums) {
        int len = nums.length;
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < len; ) {
            int[] temp = new int[]{-1, -1};
            temp[0] = nums[i];
            while (i < len) {
                i++;
                if (i < len) {
                    if (nums[i] > temp[1]) {
                        temp[1] = nums[i];
                    } else if (nums[i] < temp[0] && temp[1] == -1) {
                        temp[0] = nums[i];
                    } else if (nums[i] < temp[1]) {
                        break;
                    }
                }
            }
            list.add(temp);
        }
        int ans = 0;
        for (int[] a : list) {
            int lirun = a[1] - a[0] - 5;
            if (lirun > 0) {
                ans += lirun;
            }
        }
        return ans;
    }

}
