package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class _011_findMaxLength {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0,-1);           // 若最长子数组的起始下标是0，则需要在put(nums[0],0)之前添加这项。
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]==0 ? -1 : 1;
            if (sumToIndex.containsKey(sum)){
                maxLength = Math.max(maxLength, i-sumToIndex.get(sum));
            }else {
                sumToIndex.put(sum,i);
            }
        }
        return maxLength;
    }

}
