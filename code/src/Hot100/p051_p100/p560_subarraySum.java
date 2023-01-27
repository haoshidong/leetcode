package Hot100.p051_p100;

import java.util.HashMap;
import java.util.Map;

public class p560_subarraySum {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> sumToCount = new HashMap<>();
        int pathSum = 0;
        sumToCount.put(0, 1);
        for (int num : nums) {
            pathSum += num;
            if (sumToCount.containsKey(pathSum - k)) {
                ans += sumToCount.get(pathSum - k);
            }
            sumToCount.put(pathSum, sumToCount.getOrDefault(pathSum, 0) + 1);
        }
        return ans;
    }
}
