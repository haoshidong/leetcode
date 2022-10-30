/**
给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 

 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 

 

 示例 1： 

 
输入：s = "a1b2"
输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 

 示例 2: 

 
输入: s = "3z4"
输出: ["3z4","3Z4"]
 

 

 提示: 

 
 1 <= s.length <= 12 
 s 由小写英文字母、大写英文字母和数字组成 
 

 Related Topics 位运算 字符串 回溯 👍 445 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        List<String> res = new LinkedList<>();
        helper(chars, 0, res);
        return res;
    }

    private void helper(char[] chars, int i, List<String> res) {
        if (i == chars.length) {
            res.add(new String(chars));
        } else {
            helper(chars,i+1,res);
            //若当前位置的字符为字母，改变大小写。
            if (Character.isLetter(chars[i])){
                chars[i] ^= 1<<5;   //位运算符：异或。相同为0，不同为1. 作用：大写字母转小写，小写字母转大写。
                helper(chars,i+1,res);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
