package test.bd;

import java.util.*;

public class t1 {

    public static boolean isBaidu(String s) {
        if (s.length() != 5) {
            return false;
        }
        Map<Character, Integer> map = new HashMap();
        map.put('B', 1);
        map.put('a', 1);
        map.put('i', 1);
        map.put('d', 1);
        map.put('u', 1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) == 1) {
                map.put(c, 0);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.next();
            System.out.println(isBaidu(s) ? "Yes" : "No");
        }
    }

}
