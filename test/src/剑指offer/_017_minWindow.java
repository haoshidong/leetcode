package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class _017_minWindow {
    public String minWindow(String s, String t) {
        if (s.length()<t.length()){
            return "";
        }
        Map<Character,Integer> charToCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            charToCount.put(t.charAt(i),charToCount.getOrDefault(t.charAt(i),0)+1);
        }
        int minLength = Integer.MAX_VALUE;


        return "";
    }
}
