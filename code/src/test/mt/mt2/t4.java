package test.mt.mt2;

import java.util.*;

/*9*/
public class t4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        Queue<int[]> minHead = new PriorityQueue<>((e1, e2) ->
        {
            if (e1[1] != e2[1]) {
                return e1[1] - e2[1];
            } else {
                return e2[0] - e1[0];
            }
        });
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            minHead.offer(new int[]{a, b});
        }
        int[] ans = maxCt(x, y, minHead);
        System.out.print(ans[0] + " " + ans[1]);
    }

    private static int[] maxCt(int all, int y, Queue<int[]> minHead) {
        int ct = 0;
        int spend = 0;
        //券足够
        while (y > 0) {
            //钱足够,且折扣券也够
            if (minHead.peek()[1] <= all) {
                spend += minHead.peek()[1];
                ct++;
                all -= minHead.peek()[1];
                minHead.poll();
                y--;
            } else {
                //钱不够
                return new int[]{ct, spend};
            }
        }
        //钱足够，但折扣券不够
        Queue<int[]> minHead2 = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
        int n = minHead.size();
        for (int i = 0; i < n; i++) {
            minHead2.add(minHead.poll());
        }
        while (all >= minHead2.peek()[0]) {
            spend += minHead2.peek()[0];
            ct++;
            all -= minHead2.peek()[0];
            minHead2.poll();
        }
        return new int[]{ct, spend};
    }
}
