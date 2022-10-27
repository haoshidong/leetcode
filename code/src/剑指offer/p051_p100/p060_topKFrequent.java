package 剑指offer.p051_p100;

import java.util.*;

public class p060_topKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int num : nums) {
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }
        //最小堆的创建，比较器指示实体的排序规则
        Queue<Map.Entry<Integer, Integer>> minHead = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        for (Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
            if (minHead.size() < k) {
                minHead.offer(entry);
            } else {
                if (entry.getValue() > minHead.peek().getValue()) {
                    minHead.poll();
                    minHead.offer(entry);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHead.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] res = topKFrequent(nums,k);
        for (int i = 0; i < k; i++) {
            System.out.println(res[i]);
        }
    }
}
