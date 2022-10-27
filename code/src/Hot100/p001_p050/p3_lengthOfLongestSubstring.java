package Hot100.p001_p050;

import javafx.scene.effect.SepiaTone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int start = 0;
        int maxLen = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))){
                start = Math.max(start, map.get(s.charAt(end))+1);  // 其实位置必须在重复字符的右边。ex:"abcba"
            }
            map.put(s.charAt(end),end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
