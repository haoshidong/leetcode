package 力扣周赛;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class p2462_totalCost {
    public long totalCost(int[] costs, int k, int candidates) {
        // 维护两个小根堆 ，分别从头尾取
        long sum = 0;
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        PriorityQueue<Integer> p2 = new PriorityQueue<>();
        int N = costs.length;
        int left = 0;
        int right = N - 1;
        // 如果2 * candidates >= N 说明是从整个数组取，直接排序求前k项和即可
        if (2 * candidates >= N) {
            Arrays.sort(costs);
            int index = 0;
            while (k > 0) {
                sum += costs[index++];
                k--;
            }
            return sum;
        }
        while (k > 0) {
            // p1是从数组头开始取
            while (p1.size() < candidates && left <= right) {
                p1.add(costs[left++]);
            }
            // p2是从数组头开始取
            while (p2.size() < candidates && left <= right) {
                p2.add(costs[right--]);
            }
            // 此处非空判断
            if (p1.size() == 0 || p2.size() == 0) {
                sum += p1.size() == 0 ? p2.poll() : p1.poll();
            } else {
                // 如果p1.peek() == p2.peek()，要p1.peek()，因为p1从头取，下标一定小于p2
                if (p1.peek() <= p2.peek()) {
                    sum += p1.poll();
                } else {
                    sum += p2.poll();
                }
            }
            k--;
        }
        return sum;

        /*//单最小堆堆
        Queue<Integer> minHead = new PriorityQueue<>(Comparator.<Integer>comparingInt(i -> costs[i]).thenComparingInt(i -> i));
        int n = costs.length,l = 0,r = n-1;
        while (l <= r && l < candidates) {
            minHead.offer(l++);
        }
        while (r>=l && r >= n-candidates){
            minHead.offer(r--);
        }
        long ans = 0;
        int i = 0;
        while (i<k){
            int poll = minHead.poll();
            i++;
            ans += costs[poll];
            if (poll<l && l<=r){
                minHead.offer(l++);
            }else if (poll>r && l<=r){
                minHead.offer(r--);
            }
        }
        return ans;*/
    }
}
