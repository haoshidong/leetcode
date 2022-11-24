package Hot100.p051_p100;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class p301_removeInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        //回溯法
        //list找到s中所有合法的字符串
        List<String> list = new LinkedList<>();
        helper(s, 0, 0, new StringBuilder(), list);
        //n保存最长有效字符串的长度
        int n = list.get(list.size() - 1).length();
        //set避免结果有重复字符串
        Set<String> set = new HashSet<>();
        List<String> ans = new LinkedList<>();
        for (String x : list) {
            if (x.length() == n && !set.contains(x)) {
                set.add(x);
                ans.add(x);
            }
        }
        return ans;
    }

    private void helper(String s, int i, int dif, StringBuilder sb, List<String> list) {
        //如果字符串合法，并且已经遍历到s的末尾
        if (i == s.length() && dif == 0) {
            list.add(sb.toString());
            //左括号数量多余右括号数量，可继续遍历s中后面的字符
        } else if (dif >= 0 && i < s.length()) {
            char ch = s.charAt(i);
            //左括号或者右括号可以选择入或者不入
            if (ch == '(' || ch == ')') {
                //不入
                helper(s, i + 1, dif, sb, list);

                if (ch == '(') {
                    dif++;
                } else {
                    dif--;
                }
                //入
                sb.append(ch);
                helper(s, i + 1, dif, sb, list);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                //非左右括号，入
                sb.append(ch);
                helper(s, i + 1, dif, sb, list);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "(a)())";
        List<String> ans = new p301_removeInvalidParentheses().removeInvalidParentheses(s);
        for (String a : ans) {
            System.out.println(a);
        }
    }
}
