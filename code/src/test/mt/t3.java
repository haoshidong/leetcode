package test.mt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class t3 {
    public static int[] best(int[] start, int[] end) {
        int n = start.length;
        int max = 0, index = 0;
        int[] ct = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    ct[i]++;
                    continue;
                }
                if ((start[j] <= start[i] && end[j] >= start[i]) || start[j] < end[i]) {
                    ct[i]++;
                    if (max < ct[i]) {
                        max = ct[i];
                        index = i;
                    }
                }
            }
        }

        max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int j = start[index]; j <= end[index]; j++) {
            int cur = 0;
            for (int i = 0; i < n; i++) {
                if (j >= start[i] && j <= end[i]) {
                    cur++;
                }
            }
            max = Math.max(max, cur);
            map.put(cur,map.getOrDefault(cur,0)+1);
        }


        return new int[]{max, map.get(max)};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                end[i] = in.nextInt();
            }
            int[] ans = best(start, end);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
