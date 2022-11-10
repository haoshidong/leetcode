package 力扣周赛;

import java.util.HashMap;
import java.util.Map;

public class p2461_maximumSubarraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0, sum = 0;
        //key为nums[i],value为nums[i]出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        //初始化
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //窗口中的key的个数等于k，则窗口中的数值没有重复值
        if (map.size() == k) {
            ans = Math.max(ans, sum);
        }
        for (int i = k; i < nums.length; i++) {
            //右指针右移
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            //左指针右移
            sum -= nums[i - k];
            //要移除的数在窗口的次数，若次数为1，删除key，否则令其value值减1。
            int cnt = map.get(nums[i - k]);
            if (cnt == 1) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], cnt - 1);
            }
            //窗口中的key的个数等于k，则窗口中的数值没有重复值
            if (map.size() == k) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
