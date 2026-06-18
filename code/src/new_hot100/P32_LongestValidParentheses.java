package new_hot100;

class P32_LongestValidParentheses {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int res = 0;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if(s.charAt(i-1) == ')'){
                if(s.charAt(i-2) == '(') {
                    dp[i] = dp[i-2] + 2;
                } else if(i-1- dp[i-1]-1 >= 0 && s.charAt(i-1- dp[i-1]-1) == '('){
                    dp[i] = dp[i-1- dp[i-1] - 1] + 2 + dp[i-1];
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P32_LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses("()(()"));
    }
}