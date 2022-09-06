package test;

public class t1 {

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ret= new int[2];
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 10, 15};
        int target = 26;
        int[] res = twoSum(nums, target);
        System.out.println("["+res[0]+","+res[1]+"]");

    }
}

