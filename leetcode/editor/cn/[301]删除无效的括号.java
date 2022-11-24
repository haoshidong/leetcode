/**
给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 

 返回所有可能的结果。答案可以按 任意顺序 返回。 

 

 示例 1： 

 
输入：s = "()())()"
输出：["(())()","()()()"]
 

 示例 2： 

 
输入：s = "(a)())()"
输出：["(a())()","(a)()()"]
 

 示例 3： 

 
输入：s = ")("
输出：[""]
 

 

 提示： 

 
 1 <= s.length <= 25 
 s 由小写英文字母以及括号 '(' 和 ')' 组成 
 s 中至多含 20 个括号 
 

 Related Topics 广度优先搜索 字符串 回溯 👍 792 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new LinkedList<>();
        helper(s, 0, 0, new StringBuilder(), list);
        int n = list.get(list.size() - 1).length();
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
        if (i == s.length() && dif == 0) {
            list.add(sb.toString());
        } else if (dif >= 0 && i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')') {
                helper(s, i + 1, dif, sb, list);

                if (ch == '(') {
                    dif++;
                } else {
                    dif--;
                }
                sb.append(ch);
                helper(s, i + 1, dif, sb, list);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
                helper(s, i + 1, dif, sb, list);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
