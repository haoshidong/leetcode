package 前500.p1_50;

import java.util.Arrays;

public class p179_largestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = "" + nums[i];
        }
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b;
            String sb = b + a;
            return sb.compareTo(sa);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ss[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        p179_largestNumber t = new p179_largestNumber();
        String s = t.largestNumber(nums);
        System.out.println(s);
    }
}
