package 剑指offer.p051_p100;

import java.util.*;

public class p061_kSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> maxHead = new PriorityQueue<>((e1, e2) -> (e2[0] + e2[1]) - (e1[0] + e1[1]));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if (maxHead.size() < k) {
                    maxHead.offer(new int[]{nums1[i], nums2[j]});
                } else {
                    if ((nums1[i] + nums2[j]) < maxHead.peek()[0] + maxHead.peek()[1]) {
                        maxHead.poll();
                        maxHead.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        for (int[] s : maxHead) {
            /*List<Integer> list = new LinkedList<>();0
            list.add(s[0]);
            list.add(s[1]);*/
            res.add(Arrays.asList(s[0], s[1]));
        }
        return res;
    }
}
