package 前500.p1_50;

import java.util.HashMap;

public class p13_romanToInt {
    public int romanToInt(String s) {
        HashMap<String, Integer> romanToNum = new HashMap<>();
        romanToNum.put("I", 1);
        romanToNum.put("IV", 4);
        romanToNum.put("V", 5);
        romanToNum.put("IX", 9);
        romanToNum.put("X", 10);
        romanToNum.put("XL", 40);
        romanToNum.put("L", 50);
        romanToNum.put("XC", 90);
        romanToNum.put("C", 100);
        romanToNum.put("CD", 400);
        romanToNum.put("D", 500);
        romanToNum.put("CM", 900);
        romanToNum.put("M", 1000);
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            if (i + 1 < s.length()) {
                String s2 = s.substring(i, i + 2);
                if (romanToNum.containsKey(s2)) {
                    ans += romanToNum.get(s2);
                    i += 2;
                    continue;
                }
            }
            String s1 = s.substring(i, i + 1);
            romanToNum.get(s1);
            ans += romanToNum.get(s1);
            i++;
        }
        return ans;
    }
}
