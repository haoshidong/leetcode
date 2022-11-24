package Hot100.p051_p100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class p347_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        //最小堆创建
        Queue<Map.Entry<Integer, Integer>> minHead = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        //map用来计数，记录每个nun出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //结果
        int[] ans = new int[k];
        //如果数组中不重复num的个数小于等于k，则将不重复数字num全部输出
        if (map.size() <= k) {
            int i = 0;
            for (int num : map.keySet()) {
                ans[i++] = num;
            }
            return ans;
        }
        //若不重复数字的个数大于k，则将其按频率从高到低排序，保存前k个数到小顶堆中
        int ct = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //堆中不足k个数，直接存入
            if (ct < k) {
                ct++;
                minHead.offer(entry);
            } else {
                //堆中num个数等于k，则只将频率高于堆顶元素频率的num存入小顶堆中
                if (entry.getValue() > minHead.peek().getValue()) {
                    minHead.poll();
                    minHead.offer(entry);
                }
            }
        }
        //更新结果数组
        for (int i = 0; i < k; i++) {
            ans[i] = minHead.poll().getKey();
        }
        return ans;
    }
}
