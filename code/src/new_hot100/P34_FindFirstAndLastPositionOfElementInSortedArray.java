package new_hot100;

class P34_FindFirstAndLastPositionOfElementInSortedArray {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int min = -1;
        int max = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if(nums[mid] == target && ((mid == 0) || nums[mid - 1] < target)){
                min = mid;
                break;
            }else if (nums[mid] < target) {
                l = mid + 1;
            }else {
                r = mid -1;
            }
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r){
            int mid = (l + r) >> 1;
            if(nums[mid] == target && ((mid +1 == nums.length) || nums[mid + 1] > target)){
                max = mid;
                break;
            }else if (nums[mid] > target) {
                r = mid -1;
            }else {
                l = mid + 1;
            }
        }
        return new int[]{min, max};
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution(); 
    }
}