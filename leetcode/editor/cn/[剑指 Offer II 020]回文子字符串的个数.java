/**
给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。 

 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 

 

 示例 1： 

 
输入：s = "abc"
输出：3
解释：三个回文子串: "a", "b", "c"
 

 示例 2： 

 
输入：s = "aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 

 

 提示： 

 
 1 <= s.length <= 1000 
 s 由小写英文字母组成 
 

 

 
 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/ 

 Related Topics 字符串 动态规划 👍 67 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        if (s==null || s.length() ==0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //奇数字符串
            count += isPalindrome(s,i,i);
            //偶数字符串
            count += isPalindrome(s,i,i+1);
        }
        return count;
    }

    private int isPalindrome(String s, int start, int end){
        int count = 0;
        while (start>=0 && end<s.length()){
            if (s.charAt(start)==s.charAt(end)){
                start--;
                end++;
                count++;
            }else {
                break;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
