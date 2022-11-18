package Hot100.p051_p100;

import java.util.PriorityQueue;
import java.util.Queue;

public class p215_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHead = new PriorityQueue<>();
        int i = 0;
        for (; i < k; i++) {
            minHead.offer(nums[i]);
        }
        for (; i < nums.length; i++) {
            if (nums[i] > minHead.peek()) {
                minHead.poll();
                minHead.offer(nums[i]);
            }
        }
        return minHead.peek();
    }
}
