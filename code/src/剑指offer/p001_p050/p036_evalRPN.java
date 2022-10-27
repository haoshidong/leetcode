package 剑指offer.p001_p050;

import java.util.Stack;

public class p036_evalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int num1 = stack.pop();//先取出来的数放在运算符的右边。
                    int num2 = stack.pop();
                    stack.push(calculate(num1, num2, token));
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private Integer calculate(int num1, int num2, String operator) {
        if (operator == "+") {
            return num2 + num1;
        } else if (operator == "-") {
            return num2 - num1;
        } else if (operator == "*") {
            return num2 * num1;
        } else if (operator == "/") {
            return num2 / num1;
        }
        return 0;
    }
}
