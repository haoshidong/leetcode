package Hot100.p001_p050;

import java.util.HashMap;
import java.util.Map;

public class p76_minWindow {
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

    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        String ans = new p76_minWindow().minWindow(s,t);
        System.out.println(ans);
    }
}
