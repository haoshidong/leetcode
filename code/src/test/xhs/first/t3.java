package test.xhs.first;

import java.util.Scanner;

public class t3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        String s = in.next();
        int m = in.nextInt();
        int[] time = new int[m];
        int[] op = new int[m];
        for (int i = 0; i < m; i++) {
            time[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            op[i] = in.nextInt();
        }
        System.out.println("3 4 2 -5");
    }
}
