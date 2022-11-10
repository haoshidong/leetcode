/**
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 

 

 注意： 

 
 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
 

 

 示例 1： 

 
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
 

 示例 2： 

 
输入：s = "a", t = "a"
输出："a"
 

 示例 3: 

 
输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。 

 

 提示： 

 
 1 <= s.length, t.length <= 10⁵ 
 s 和 t 由英文字母组成 
 

 
进阶：你能设计一个在 
o(n) 时间内解决此问题的算法吗？

 Related Topics 哈希表 字符串 滑动窗口 👍 2234 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        //滑动窗口+Map
        //若s长度小于t，则直接返回失败
        if (s.length() < t.length()) {
            return "";
        }
        //map存放目标t的字符和字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //滑动窗口的左右指针
        int l = 0, r = 0;
        //用数组存取结果
        int[] ans = new int[]{0, s.length()};
        //true表示s中有覆盖的子串
        boolean flag = false;
        while (r < s.length()) {
            char ch = s.charAt(r);
            //若s的当前字符在t中，则次数减1，否则遍历s的下一个字符
            if (map.containsKey(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) - 1);
            }
            r++;
            //当前窗口内的子字符串是否是覆盖子串
            if (isSub(map)) {
                //存在覆盖子串
                flag = true;
                //缩短滑动窗口，直到最小的覆盖子串
                while (isSub(map)) {
                    char l_ch = s.charAt(l);
                    if (map.containsKey(l_ch)) {
                        map.put(l_ch, map.get(l_ch) + 1);
                    }
                    l++;
                }
                //此时[l-1,r)为当前滑动窗口的最短覆盖子串
                if ((r - l) < (ans[1] - ans[0])) {
                    ans = new int[]{l - 1, r};
                }
            }
        }
        return flag ? s.substring(ans[0], ans[1]) : "";
    }

    private boolean isSub(Map<Character, Integer> map) {
        for (int count : map.values()) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
