package 力扣周赛;

public class p6248_countSubarrays {
    public int countSubarrays(int[] nums, int k) {
        int index = k;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                index = i;
                break;
            }
        }
        int l = index - 1, r = index + 1;
        int total_l = 0, total_r = 0;
        int[] res = {0};
        helper(nums, k, l, r, total_l, total_r, res);
        return res[0];
    }

    private void helper(int[] nums, int k, int l, int r, int total_l, int total_r, int[] res) {
        if (l >= 0 || r < nums.length) {
            if (total_l == total_r || total_l == total_r - 1) {
                res[0]++;
            }
            if (nums[l] > k) {
                total_r++;
                l--;
                helper(nums, k, l, r, total_l, total_r, res);
                l++;
                total_r--;
            } else {
                total_l++;
                l--;
                helper(nums, k, l, r, total_l, total_r, res);
                l++;
                total_l--;
            }
            if (nums[r] > k) {
                total_r++;
                r++;
                helper(nums, k, l, r, total_l, total_r, res);
                r--;
                total_r--;
            } else {
                total_l++;
                r++;
                helper(nums, k, l, r, total_l, total_r, res);
                r--;
                total_l--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 5};
        int k = 4;
        int ans = new p6248_countSubarrays().countSubarrays(nums, k);
        System.out.println(ans);
    }
}
