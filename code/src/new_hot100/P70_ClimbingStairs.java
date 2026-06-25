package new_hot100;

class P70_ClimbingStairs {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P70_ClimbingStairs().new Solution(); 
    }
}