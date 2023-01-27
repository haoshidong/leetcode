package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class p2287_rearrangeCharacters {
    public int rearrangeCharacters(String s, String target) {
        //map存储target中每个字符出现的次数
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        //结果
        int res = Integer.MAX_VALUE;
        //初始化map
        for (char ch : target.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            char key = entry.getKey();
            int fenmu = entry.getValue();
            if (!map2.containsKey(key)) {
                return 0;
            }
            int fenzi = map2.get(key);
            if (fenzi < fenmu) {
                return 0;
            }
            res = Math.min(res, fenzi / fenmu);
        }

        return res;
    }
}
