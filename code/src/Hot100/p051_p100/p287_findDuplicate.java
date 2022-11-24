package Hot100.p051_p100;

public class p287_findDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = nums[0];
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = nums[slow];
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
