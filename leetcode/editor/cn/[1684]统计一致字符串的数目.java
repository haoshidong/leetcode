/**
给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串
 。 

 请你返回 words 数组中 一致字符串 的数目。 

 

 示例 1： 

 
输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
输出：2
解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 

 示例 2： 

 
输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
输出：7
解释：所有字符串都是一致的。
 

 示例 3： 

 
输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
输出：4
解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 

 

 提示： 

 
 1 <= words.length <= 10⁴ 
 1 <= allowed.length <= 26 
 1 <= words[i].length <= 10 
 allowed 中的字符 互不相同 。 
 words[i] 和 allowed 只包含小写英文字母。 
 

 Related Topics 位运算 数组 哈希表 字符串 👍 62 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        //位运算
        int ans = 0;
        //用32位的int前26位表示allowed中的字符，若出现，对应位置为1。
        int mask = 0;
        for (char ch : allowed.toCharArray()) {
            mask |= 1 << (ch - 'a');
        }
        for (String word : words) {
            int mask_i = 0;
            for (char ch : word.toCharArray()) {
                mask_i |= 1 << (ch - 'a');
            }
            //若word是allowed的一致字符串，则mask_i和mask的与运算结果为mask
            if ((mask_i | mask) == mask) {
                ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
