package 剑指offer.p051_p100;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class p059_KthLargest {
    int size;
    PriorityQueue<Integer> minHead;

    public p059_KthLargest(int k, int[] nums) {
        size = k;
        minHead = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHead.size() < size) {
            minHead.offer(val);
        } else if (val > minHead.peek()) {
            minHead.poll();
            minHead.offer(val);
        }
        return minHead.peek();
    }
}
