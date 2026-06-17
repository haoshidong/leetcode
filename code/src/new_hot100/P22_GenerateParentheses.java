package new_hot100;

import java.util.ArrayList;
import java.util.List;

import static test.mt.t2.dfs;

class P22_GenerateParentheses {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public List<String> generateParenthesis(int n) {
        int l = n;
        int r = n;
        List<String> res = new ArrayList<>();
        dfs(l, r, res, new StringBuilder());
        return res;
    }

    private void dfs(int l, int r, List<String> res, StringBuilder path) {
        if(l == 0 && r == 0) {
            res.add(path.toString());
        } else {
            if(l >= r) {
                path.append('(');
                l--;
                dfs(l, r, res, path);
                l++;
                path.deleteCharAt(path.length() - 1);
            }else {
                if(l > 0) {
                    path.append('(');
                    l--;
                    dfs(l, r, res, path);
                    l++;
                    path.deleteCharAt(path.length() - 1);
                }

                if(r > 0) {
                    path.append(')');
                    r--;
                    dfs(l, r, res, path);
                    r++;
                    path.deleteCharAt(path.length() - 1);
                }
            }
        }
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P22_GenerateParentheses().new Solution(); 
    }
}