package test;

import 剑指offer.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        String str = "abc";
        map.put(str,1);
        char[] chars = {'a','b','c'};
        String str2 = new String(chars);
        chars.toString();
        if (map.containsKey(str2)){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

        /*ListNode res = new ListNode();
        System.out.println(res.val);*/
        /*System.out.println(3*0.1 == 0.3);
        System.out.println(3*0.1);*/
        /*Integer x = new Integer(123);
        Integer y = new Integer(123);
        Integer b = new Integer(29);
        Integer a = 29;
        System.out.println(a == b);    // false*/
        /*char c = '1';
        char[] s = new char[5];
        s[0] = 1;
        s[1] = s[2] = 2;
        System.out.println((int)s[0]);*/
        /*String[] s = {"a","bc"};
        StringBuilder s1 = new StringBuilder();
        for (String a : s) {
            s1.append(a);
        }
        System.out.println(s1);*/
    }
}