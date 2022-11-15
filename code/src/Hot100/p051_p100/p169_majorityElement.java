package Hot100.p051_p100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class p169_majorityElement {
    public int majorityElement(int[] nums) {
        //摩尔投票法
        int cand_num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cand_num == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    cand_num = nums[i];
                    count = 1;
                }
            }
        }
        return cand_num;

        /*//排序方法
        //排序后，因为多数元素长度大于n/2，nums[]的中间元素必为多数元素
        Arrays.sort(nums);
        return nums[nums.length >> 1];*/

        /*//HashMap方法
        Map<Integer, Integer> valToCount = new HashMap<>();
        int half = nums.length / 2;
        for (int num : nums) {
            valToCount.put(num, valToCount.getOrDefault(num, 0) + 1);
            if (valToCount.get(num) > half) {
                return num;
            }
        }
        return -1;*/
    }
}
