package Hot100.p001_p050;

public class p33_search {
    public int search(int[] nums, int target) {
        int[] find = findIcrease(nums, target, 0, nums.length - 1);
        //不存在target
        if (find[0] == -1) return -1;
        //target的值在find区间内，寻找此区间是否存在num值为target的值。
        int ans = findTarget(nums, find[0], find[1], target);
        return ans;
    }

    private int findTarget(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        //未找到target值，返回-1
        return -1;
    }

    private int[] findIcrease(int[] nums, int target, int start, int end) {
        if (nums[start] <= nums[end] && target >= nums[start]) {
            //得到二分查找的区间段，target在此区间中
            return new int[]{start, end};
        }
        if (nums[start] > nums[end]) {
            int mid = (start + end) >> 1;
            //判定左半部分
            if (target >= nums[start]) {
                //如果左半部分递增，且值均小于target,目标数组在右半部分。例如[2,4,5,6,7,0,1]查找7。
                if (nums[start] <= nums[mid] && target > nums[mid]) return findIcrease(nums, target, mid + 1, end);
                return findIcrease(nums, target, start, mid);
                //判定右半部分
            } else {
                //如果右半部分递增，且值均大于target，目标数组在左半部分。例如[6,7,0,1,2,4,5]查找0。
                if (nums[mid + 1] <= nums[end] && target < nums[mid + 1]) return findIcrease(nums, target, start, mid);
                return findIcrease(nums, target, mid + 1, end);
            }
        }
        //没找到target所在区间
        return new int[]{-1, -1};
    }
}
