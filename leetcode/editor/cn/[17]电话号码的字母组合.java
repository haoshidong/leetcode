/**
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 

 

 

 示例 1： 

 
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 

 示例 2： 

 
输入：digits = ""
输出：[]
 

 示例 3： 

 
输入：digits = "2"
输出：["a","b","c"]
 

 

 提示： 

 
 0 <= digits.length <= 4 
 digits[i] 是范围 ['2', '9'] 的一个数字。 
 

 Related Topics 哈希表 字符串 回溯 👍 2169 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
