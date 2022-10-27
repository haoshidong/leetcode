package 剑指offer.p001_p050;

import java.util.HashMap;
import java.util.Map;

public class p010_subarraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0,1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += sumToCount.getOrDefault(sum-k,0);      //加上以i结尾的连续数组之和为k的个数
            sumToCount.put(sum,sumToCount.getOrDefault(sum,0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        int ans = new p010_subarraySum().subarraySum(nums,k);
        System.out.println(ans);
    }
}
