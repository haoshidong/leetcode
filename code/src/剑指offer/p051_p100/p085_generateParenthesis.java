package 剑指offer.p051_p100;

import java.util.LinkedList;
import java.util.List;

public class p085_generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        helper(n, 0, str, res);

        return res;
    }

    private void helper(int n, int count, StringBuilder str, List<String> res) {
        if (str.length() == n * 2 && count == 0) {
            res.add(new String(str));
        } else {
            if (count >= 0 && count <= n && str.length() < n * 2) {
                count++;
                str.append('(');
                helper(n, count, str, res);
                str.deleteCharAt(str.length() - 1);
                count--;

                if (count > 0) {
                    count--;
                    str.append(')');
                    helper(n, count, str, res);
                    str.deleteCharAt(str.length() - 1);
                    count++;
                }
            }
        }
    }
}
