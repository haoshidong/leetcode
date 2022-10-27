package 剑指offer.p001_p050;

import java.util.LinkedList;
import java.util.Queue;

public class p041_MovingAverage {
    private Queue<Integer> nums;
    private int capacity;
    private int sum;

    /**
     * Initialize your data structure here.
     */
    public p041_MovingAverage(int size) {
        nums = new LinkedList<>();
        capacity = size;
    }

    public double next(int val) {
        nums.offer(val);
        sum += val;
        if (nums.size() > capacity) {
            sum -= nums.poll();
        }
        return (double) sum / nums.size();
    }
}
