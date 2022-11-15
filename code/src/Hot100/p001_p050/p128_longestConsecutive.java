package Hot100.p001_p050;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class p128_longestConsecutive {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        Arrays.sort(nums);
        int count = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            //跳过重复的数
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i - 1] + 1 == nums[i]) {
                count++;
                //若不连续，则更新ans值，count重置为1
            } else {
                ans = Math.max(ans, count);
                count = 1;
            }
        }
        return Math.max(ans, count);

        /*//哈希表
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + 1)) {
                    count++;
                    num++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;*/
    }
}
