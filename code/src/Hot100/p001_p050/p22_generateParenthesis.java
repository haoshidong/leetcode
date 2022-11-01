package Hot100.p001_p050;

import java.util.LinkedList;
import java.util.List;

public class p22_generateParenthesis {
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

    public static void main(String[] args) {
        int n = 3;
        List<String> res = new p22_generateParenthesis().generateParenthesis(n);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
