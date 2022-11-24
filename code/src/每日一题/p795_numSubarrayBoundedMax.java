package 每日一题;

public class p795_numSubarrayBoundedMax {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        //i0表示大于right的数组下标，i1表示数组在[left,right]的数组下标
        int ans = 0, i0 = -1, i1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                i0 = i;
            }
            //i0更新了,i1也要更新，不然i1-i0为负数
            if (nums[i] >= left) {
                i1 = i;
            }
            ans += i1 - i0;
        }
        return ans;
        /*
        //  43 / 46 个通过的测试用例
        int start = 0, end = -1;
        int n = nums.length;
        int ans = 0;
        while (end < n) {
            start = end + 1;
            int max = -1;
            while (start < n && nums[start] > right) {
                start++;
            }
            end = start;
            while (end < n && nums[end] <= right) {
                if (nums[end] >= left) {
                    max = Math.max(max, nums[end]);
                }
                end++;
            }
            if (max >= left) {
                ans += (1 + end - start) * (end - start) / 2;
                int i = start, j = start - 1;
                while (j < end) {
                    i = j + 1;
                    while (i < end && nums[i] >= left) {
                        i++;
                    }
                    j = i;
                    while (j < end && nums[j] < left) {
                        j++;
                    }
                    ans -= (1 + j - i) * (j - i) / 2;
                }
            }
        }
        return ans;*/
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3};
        int left = 2, right = 3;
        int ans = new p795_numSubarrayBoundedMax().numSubarrayBoundedMax(nums, left, right);
        System.out.println(ans);
    }
}
