package 每日一题;

import com.sun.xml.internal.messaging.saaj.util.CharReader;

import java.util.Stack;

public class p1106_parseBoolExpr {
    public boolean parseBoolExpr(String expression) {
        //存取操作符 ’&‘、’|‘、’！‘
        Stack<Character> operators = new Stack<>();
        //存取操作数 ’(‘、’t‘、’f‘
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ',') continue;
            //当前字符为操作符
            if (ch == '&' || ch == '|' || ch == '!') operators.add(ch);
            //当前字符为操作数
            else if (ch != ')') stack2.add(ch);
            //当前字符为 ’)‘，则取出操作数，直到遇到’(‘，并取出操作符进行运算，然后将运算结果存到stack2中
            else {
                StringBuilder sb = new StringBuilder();
                //保存操作数
                while (stack2.peek() != '(') sb.append(stack2.pop());
                //弹出左括号 ’(‘
                stack2.pop();
                char operator = operators.pop();
                if (operator == '!') stack2.add(sb.charAt(0) == 't' ? 'f' : 't');
                else if (operator == '&') {
                    int j = 0;
                    for (; j < sb.length(); j++) {
                        if (sb.charAt(j) == 'f') break;
                    }
                    stack2.add(j == sb.length() ? 't' : 'f');
                } else if (operator == '|') {
                    int j = 0;
                    for (; j < sb.length(); j++) {
                        if (sb.charAt(j) == 't') break;
                    }
                    stack2.add(j == sb.length() ? 'f' : 't');
                }
            }
        }
        return stack2.pop() == 't' ? true : false;
    }

    public static void main(String[] args) {
        String s = "!(&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))))";
        boolean ans = new p1106_parseBoolExpr().parseBoolExpr(s);
        System.out.println(ans);
    }
}
