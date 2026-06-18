package new_hot100;

class P33_SearchInRotatedSortedArray {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int res = findTarget(l, r, nums, target);
        return res;
    }

    private int findTarget(int l, int r, int[] nums, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) { // target 大于中间数
                // 右边有序
                if(nums[mid] < nums[r]) {
                    if(target <=  nums[r]) {
                        return findTarget(mid + 1, r, nums, target);
                    } else {
                        return findTarget(l, mid -1, nums, target);
                    }
                }else { //左边有序
                    return findTarget(mid + 1, r, nums, target);
                }
            } else { // target 小于中间数
                if(nums[mid] < nums[r]) {// 右边有序
                    return findTarget(l, mid - 1, nums, target);
                } else { //左边有序
                    if(target >= nums[l]) {
                        return findTarget(l, mid - 1, nums, target);
                    } else {
                        return findTarget(mid + 1, r, nums, target);
                    }
                }
            }
        }

        return -1;
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P33_SearchInRotatedSortedArray().new Solution();
        System.out.println(3/2);
    }
}