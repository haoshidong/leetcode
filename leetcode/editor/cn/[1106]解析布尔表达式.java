/**
给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。 

 有效的表达式需遵循以下约定： 

 
 "t"，运算结果为 True 
 "f"，运算结果为 False 
 "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT） 
 "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND） 
 "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR） 
 

 

 示例 1： 

 输入：expression = "!(f)"
输出：true
 

 示例 2： 

 输入：expression = "|(f,t)"
输出：true
 

 示例 3： 

 输入：expression = "&(t,f)"
输出：false
 

 示例 4： 

 输入：expression = "|(&(t,f,t),!(t))"
输出：false
 

 

 提示： 

 
 1 <= expression.length <= 20000 
 expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。 
 expression 是以上述形式给出的有效表达式，表示一个布尔值。 
 

 Related Topics 栈 递归 字符串 👍 126 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
}
//leetcode submit region end(Prohibit modification and deletion)
