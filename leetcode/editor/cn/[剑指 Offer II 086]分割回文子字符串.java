/**
给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。 

 
 回文串 是正着读和反着读都一样的字符串。 

 

 示例 1： 

 
输入：s = "google"
输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
 

 示例 2： 

 
输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
 

 示例 3： 

 
输入：s = "a"
输出：[["a"]] 

 

 提示： 

 
 1 <= s.length <= 16 
 s 仅由小写英文字母组成 
 

 

 
 注意：本题与主站 131 题相同： https://leetcode-cn.com/problems/palindrome-partitioning/ 

 Related Topics 深度优先搜索 广度优先搜索 图 哈希表 👍 41 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[][] partition(String s) {
        List<List<String>> res = new LinkedList<>();
        LinkedList<String> subStrings = new LinkedList<>();
        helper(s, 0, subStrings, res);
        String[][] result = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i).toArray(new String[0]);
        }
        return result;
    }

    private void helper(String str, int start, LinkedList<String> subStrings, List<List<String>> res) {
        if (start == str.length()) {
            res.add(new LinkedList<>(subStrings));
        }
        for (int i = start; i < str.length(); i++) {
            if (isPalindrome(str, start, i)) {
                subStrings.add(str.substring(start,i+1));
                helper(str,i+1,subStrings,res);
                subStrings.removeLast();
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
