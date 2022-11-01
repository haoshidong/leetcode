/**
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 

 

 示例 1： 

 
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
 

 示例 2： 

 
输入：n = 1
输出：["()"]
 

 

 提示： 

 
 1 <= n <= 8 
 

 Related Topics 字符串 动态规划 回溯 👍 2931 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        dfs(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(int n, int i, int dif, StringBuilder sb, List<String> res) {
        if (i == n && dif == 0) {
            res.add(sb.toString());
            //左括号的数目小于等于n。小于n可加左括号，等于n只能加右括号
        } else if (i <= n) {
            //小于n，可加右括号
            if (i < n) {
                sb.append('(');
                dfs(n, i + 1, dif + 1, sb, res);
                sb.deleteCharAt(2 * i - dif);   //最后一个小标的位置为2*(i+1)-(dif+1)-1 = 2 * i - dif
            }
            //左括号数目多余右括号，可加右括号
            if (dif > 0) {
                sb.append(')');
                dfs(n, i, dif - 1, sb, res);
                sb.deleteCharAt(2 * i - dif);   //最后一个小标的位置为2*i-(dif-1)-1 = 2 * i - dif
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
