package Hot100.p001_p050;

import java.util.*;

public class p17_letterCombinations {
    /*
    运行成功:
	测试用例:"22"
	测试结果:["aa","ab","ac","ba","bb","bc","ca","cb","cc"]
	期望结果:["aa","ab","ac","ba","bb","bc","ca","cb","cc"]
	stdout:
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits.length()==0){
            return res;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(digits, 0, new StringBuilder(), phoneMap, res);
        return res;
    }

    private void dfs(String digits, int i, StringBuilder path, Map<Character, String> phoneMap, List<String> res) {
        if (i == digits.length()) {
            res.add(path.toString());
        } else {
            for (char ch : phoneMap.get(digits.charAt(i)).toCharArray()) {
                path.append(ch);
                dfs(digits, i + 1, path, phoneMap, res);
                path.deleteCharAt(i);
            }
        }
    }
}
