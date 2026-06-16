package new_hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class P17_LetterCombinationsOfAPhoneNumber {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {

    String[] letterMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.isEmpty()){
            return res;
        }
        dfs(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(String digits, int i, StringBuilder path, List<String> res){
        if(i == digits.length()) {
            res.add(path.toString());
        }else {
            for (char c : letterMap[digits.charAt(i) - '0'].toCharArray()){
                path.append(c);
                dfs(digits, i + 1, path, res);
                path.deleteCharAt(path.length() - 1);
            }
        }

    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P17_LetterCombinationsOfAPhoneNumber().new Solution();
    }
}