package 每日一题;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p1704_halvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int half = s.length() / 2;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int count = 0;
        for (int i = 0; i < half; i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
            if (set.contains(s.charAt(i + half))) {
                count--;
            }
        }
        return count==0;
    }

    public static void main(String[] args) {
        String s = "book";
        boolean ans = new p1704_halvesAreAlike().halvesAreAlike(s);
        System.out.println(ans);
    }
}
