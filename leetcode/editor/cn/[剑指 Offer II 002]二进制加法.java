/**
给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 

 输入为 非空 字符串且只包含数字 1 和 0。 

 

 示例 1: 

 
输入: a = "11", b = "10"
输出: "101" 

 示例 2: 

 
输入: a = "1010", b = "1011"
输出: "10101" 

 

 提示： 

 
 每个字符串仅由字符 '0' 或 '1' 组成。 
 1 <= a.length, b.length <= 10^4 
 字符串如果不是 "0" ，就都不含前导零。 
 

 

 
 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 

 Related Topics 位运算 数学 字符串 模拟 👍 47 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            int digitA = i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            int digitB = i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            int sum = carry + digitA + digitB;
            carry = sum >= 2 ? 1 : 0;
            sum = sum%2;
            ans.append(sum);
        }

        if (carry > 0) {
            ans.append(1);
        }

        return ans.reverse().toString();
    }
}

//leetcode submit region end(Prohibit modification and deletion)
