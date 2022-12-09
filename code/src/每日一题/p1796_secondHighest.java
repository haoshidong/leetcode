package 每日一题;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class p1796_secondHighest {
    public int secondHighest(String s) {
        //a是最大数，b是第二大的数
        int a = -1, b = -1;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                int v = ch - '0';
                if (v > a) {
                    b = a;
                    a = v;
                } else if (v > b && v < a) {
                    b = v;
                }
            }
        }
        return b;

        /*
        //HashSet + 最小堆
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (!Character.isLowerCase(ch)) {
                set.add(ch);
            }
        }
        if (set.size() < 2) {
            return -1;
        }
        Queue<Integer> minHead = new PriorityQueue<>();
        for (char ch : set) {
            int cur = Integer.parseInt(String.valueOf(ch));
            if (minHead.size() < 2) {
                minHead.offer(cur);
            } else {
                if (cur > minHead.peek()) {
                    minHead.poll();
                    minHead.offer(cur);
                }
            }
        }
        return minHead.peek();*/
    }
}
