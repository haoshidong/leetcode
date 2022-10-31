package Hot100.p001_p050;

import java.util.Stack;

public class p20_isValid {
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
