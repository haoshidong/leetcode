package Hot100.p051_p100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p438_findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        //map存取字符串p中每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        //存取结果
        List<Integer> ans = new ArrayList<>();
        //初始化map
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //滑动窗口对ct进行操作
        Map<Character, Integer> ct = new HashMap<>(map);
        //滑动窗口双指针
        int i = 0, j = 0;
        for (; j - i < p.length() && j < s.length(); j++) {
            char ch = s.charAt(j);
            //右指针不在p内，修改左指针，并给ct重新赋值
            if (!ct.containsKey(ch)) {
                i = j + 1;
                ct = new HashMap<>(map);
                //右指针在p内，但窗口内已经有足够的ch满足
            } else if (ct.get(ch) == 0) {
                //重新寻找左指针位置，并修改ct
                while (s.charAt(i) != s.charAt(j) && i < j) {
                    ct.put(s.charAt(i), ct.get(s.charAt(i)) + 1);
                    i++;
                }
                i++;
            } else {
                //右指针满足要求，将窗口增大
                ct.put(ch, ct.get(ch) - 1);
                //若字符ch的计数到0，则判断是否满足题目条件
                if (ct.get(ch) == 0) {
                    //若满足题目条件，则将左指针加入到ans中
                    if (isFind(ct)) {
                        ans.add(i);
                        //循环：窗口外的右边第一个字符==左指针字符，则将i+1添加到结果中
                        while (j < s.length() - 1 && s.charAt(i) == s.charAt(++j)) {
                            ans.add(++i);
                        }
                        //跳出上面while循环，此时指针j所在字符若在ct的key中，则改变左指针位置并修改ct
                        if (ct.containsKey(s.charAt(j))) {
                            while (s.charAt(i) != s.charAt(j) && i < j) {
                                ct.put(s.charAt(i), ct.get(s.charAt(i)) + 1);
                                i++;
                            }
                            i++;
                            //指针j所在字符不在ct的key中，改变左指针位置，并给ct重新赋值
                        } else {
                            i = j + 1;
                            ct = new HashMap<>(map);
                        }
                    }
                }
            }
        }
        return ans;
    }

    private boolean isFind(Map<Character, Integer> ct) {
        for (int c : ct.values()) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abacbabc";
        String p = "abc";
        List<Integer> anagrams = new p438_findAnagrams().findAnagrams(s, p);
        for (int a : anagrams) {
            System.out.println(a + " ");
        }
    }
}
