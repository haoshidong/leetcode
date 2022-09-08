package 剑指offer;

public class _010_subarraySum {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] s = new int[length+1];
        int count = 0;
        s[0] = 0;
        for (int i = 0; i < length; i++) {
            s[i+1] = s[i]+nums[i];
        }
        for (int size = 1; size <= length; size++) {
            for (int i=0;i<length && i+size<=length;i++){
                int sum = 0;
                sum = s[i+size]-s[i];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        int ans = new _010_subarraySum().subarraySum(nums,k);
        System.out.println(ans);
    }
}
