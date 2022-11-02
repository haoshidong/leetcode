package Hot100.p001_p050;

public class p34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        //target在给定数组范围之外，或数组不存在
        if (len==0 || target < nums[0] || target > nums[len - 1]) return new int[]{-1, -1};
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            //找到target
            if (nums[mid] == target) {
                l = r = mid;
                while (l > 0 && nums[l - 1] == target) l--;
                while (r < len - 1 && nums[r + 1] == target) r++;
                return new int[]{l, r};
            }
            //target在左半部分
            if (target < nums[mid]) r = mid - 1;
            //target在右半部分
            else l = mid + 1;
        }
        //未找到target
        return new int[]{-1,-1};
    }
}
