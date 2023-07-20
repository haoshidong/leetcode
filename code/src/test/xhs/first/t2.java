package test.xhs.first;

import java.util.PriorityQueue;
import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int c = in.nextInt();
        PriorityQueue<int[]> maxHead = new PriorityQueue<>((a, b) -> {
            double a1 = a[1] / a[0];
            double b1 = b[1] / a[0];
            if (a1 != b1) {
                return (int) (b1 - a1);
            } else {
                return a[0] - b[0];
            }
        });
        int[][] nums = new int[2][n];
        for (int i = 0; i < n; i++) {
            nums[0][i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums[1][i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            maxHead.offer(new int[]{nums[0][i], nums[1][i]});
        }
        int result = peiZhiRongYe(maxHead, x, c);
        System.out.println(result);
    }

    private static int peiZhiRongYe(PriorityQueue<int[]> maxHead, int x, int target) {
        int ans = 0;
        int[] flag = {-1, -1};

        while (target != 0) {
            int cur = maxHead.peek()[0];
            if (cur * 2 <= target) {
                if (flag[0] == cur * 2) {
                    target -= flag[0];
                    ans += flag[1] + x;
                    flag[0] = flag[0] * 2;
                    flag[1] = flag[1] * 2 + x;
                    continue;
                }
                target -= cur * 2;
                ans += maxHead.peek()[1] * 2 + x;
                flag[0] = cur * 2;
                flag[1] = maxHead.peek()[1] * 2;
            } else if (cur <= target) {
                target -= cur;
                flag[0] = cur;
                flag[1] = maxHead.peek()[1];
            } else {
                maxHead.poll();
            }
        }
        return ans;
    }
}
