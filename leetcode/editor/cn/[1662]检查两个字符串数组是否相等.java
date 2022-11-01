/**
给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。 

 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。 

 

 示例 1： 

 
输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
输出：true
解释：
word1 表示的字符串为 "ab" + "c" -> "abc"
word2 表示的字符串为 "a" + "bc" -> "abc"
两个字符串相同，返回 true 

 示例 2： 

 
输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
输出：false
 

 示例 3： 

 
输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
输出：true
 

 

 提示： 

 
 1 <= word1.length, word2.length <= 10³ 
 1 <= word1[i].length, word2[i].length <= 10³ 
 1 <= sum(word1[i].length), sum(word2[i].length) <= 10³ 
 word1[i] 和 word2[i] 由小写字母组成 
 

 Related Topics 数组 字符串 👍 43 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        //遍历
        //p1和p2:数组中字符串的下标，i和j：字符串中字符的下标
        int i = 0, j = 0, p1 = 0, p2 = 0;
        while (p1 < word1.length && p2 < word2.length) {
            //字符不相等返回false
            if (word1[p1].charAt(i) != word2[p2].charAt(j)) {
                return false;
            }
            //字符相等，对i和j加1
            i++;
            if (i == word1[p1].length()) {  //若i到达当前字符串的末尾，字符串下标加1，i从新字符串的下标0开始扫描
                p1++;
                i = 0;
            }
            j++;
            if (j == word2[p2].length()) {  //若j到达当前字符串的末尾，字符串下标加1，j从新字符串的下标0开始扫描
                p2++;
                j = 0;
            }
        }
        return p1 == word1.length && p2 == word2.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
