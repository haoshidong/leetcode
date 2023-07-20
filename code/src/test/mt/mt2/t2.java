package test.mt.mt2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*100*/
public class t2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int ans = maxLength(nums, k);
        System.out.println(ans);
    }

    private static int maxLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.size() < k) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            } else {
                if (!map.containsKey(nums[i])) {
                    maxLen = Math.max(maxLen, i - start);
                    map.put(nums[i],1);
                    while (map.size() > k) {
                        if (map.get(nums[start]) > 1){
                            map.put(nums[start], map.get(nums[start]) - 1);
                        }else {
                            map.remove(nums[start]);
                        }
                        start++;
                    }
                }else {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                }
            }
        }
        maxLen = Math.max(maxLen, nums.length - start);
        return maxLen;
    }
}
