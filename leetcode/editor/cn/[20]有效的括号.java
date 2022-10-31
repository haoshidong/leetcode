/**
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 

 有效字符串需满足： 

 
 左括号必须用相同类型的右括号闭合。 
 左括号必须以正确的顺序闭合。 
 每个右括号都有一个对应的相同类型的左括号。 
 

 

 示例 1： 

 
输入：s = "()"
输出：true
 

 示例 2： 

 
输入：s = "()[]{}"
输出：true
 

 示例 3： 

 
输入：s = "(]"
输出：false
 

 

 提示： 

 
 1 <= s.length <= 10⁴ 
 s 仅由括号 '()[]{}' 组成 
 

 Related Topics 栈 字符串 👍 3582 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        //若s字符串长度为0，为有效的括号。
        if (s.length() == 0) {
            return true;
        }
        //存取未消掉的括号
        Stack<Character> stack = new Stack<>();
        //字符串的下标
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i++);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch); //若为左括号，直接入栈
                    break;
                //若为右括号，如果栈为空，直接返回false；若不为空，但是栈顶括号不匹配当前右括号，也返回false
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
            }
        }
        //栈为空，表示全部括号抵消成功，否则失败。
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
