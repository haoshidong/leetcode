package new_hot100;

class P55_JumpGame {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums[0] == 0 && nums.length > 1) {
            return false;
        }
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(dp[i-1] - 1 < 0){
                return false;
            }
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
        }
        return true;
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P55_JumpGame().new Solution(); 
    }
}