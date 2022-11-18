/**
 * 给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。
 * <p>
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * <p>
 * <p>
 * 例如， “ace” 是 “abcde” 的子序列。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= s.length <= 5 * 10⁴
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s 都只由小写字母组成。
 * <p>
 * <p>
 * <p>
 * Related Topics 字典树 哈希表 字符串 排序 👍 337 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Deque<String>[] queue = new Deque[26];
        for (int i = 0; i < 26; i++) {
            queue[i] = new ArrayDeque<>();
        }
        for (String w : words) {
            queue[w.charAt(0) - 'a'].add(w);
        }
        int ans = 0;
        for (char ch : s.toCharArray()) {
            Deque<String> cur = queue[ch - 'a'];
            for (int i = cur.size(); i > 0; i--) {
                String t = cur.pollFirst();
                if (t.length() == 1) {
                    ans++;
                } else {
                    queue[t.charAt(1) - 'a'].offer(t.substring(1));
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
