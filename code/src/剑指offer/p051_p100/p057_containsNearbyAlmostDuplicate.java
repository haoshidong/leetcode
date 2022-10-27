package 剑指offer.p051_p100;

import java.util.TreeSet;

public class p057_containsNearbyAlmostDuplicate {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long lower = treeSet.floor((long) nums[i]);
            if (lower != null && lower >= (long) nums[i] - t) {
                return true;
            }
            Long upper = treeSet.ceiling((long) nums[i]);
            if (upper != null && upper <= (long) nums[i] + t){
                return true;
            }
            treeSet.add((long) nums[i]);
            if (i>=k){
                treeSet.remove((long)nums[i-k]);
            }
        }
        return false;
        /*int start = 0;
        int end = 1;
        Long val;
        for (; end <= k && end < nums.length; end++) {
            treeSet.add((long)nums[end]);
        }
        while (start < nums.length - 1) {
            Long x = (long)nums[start] + t;
            val = treeSet.floor((long)nums[start] + t);
            if (val != null && val >= nums[start] - t) {
                return true;
            }
            start++;
            treeSet.remove(nums[start]);
            if (end < nums.length) {
                treeSet.add((long)nums[end]);
                end++;
            }
        }
        return false;*/
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        boolean flag = containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(flag);
    }
}
