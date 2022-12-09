package test;

import 剑指offer.ListNode;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        char s = '5';
        int a = s-'0';
        System.out.println(s);
        System.out.println(a);

        /*StringBuilder sb = new StringBuilder("abc");
        System.out.println(sb);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);*/

        /*char a = 'a'+1;
        StringBuilder sb = new StringBuilder();
        sb.append((char) ('a'+1));
        System.out.println(sb.toString());
        String s = "aaa";
        s.toCharArray();
        boolean b = true;*/
        /*int[] nums = {1,2,3,4,5};
        Integer newNums[] = Arrays.stream(nums).boxed().toArray(Integer[]::new);
//        Integer[] preorder = {1,2,3,4,5};
        List<Integer> pre = Arrays.asList(newNums);
        List<Integer> n_s = pre.subList(0,2);
        for (int num : n_s) {
            System.out.println(num);
        }*/
        /*Map<String, Integer> map = new HashMap<>();
        String str = "abc";
        map.put(str, 1);
        char[] chars = {'a', 'b', 'c'};
        String str2 = new String(chars);
        chars.toString();
        if (map.containsKey(str2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }*/

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

        /*int[] nums = {1, 1, 1, 7, 8, 9};
        int k = 3;
        double ans = maximumSubarraySum(nums, k);
        System.out.println(ans);*/

/*        String s = "00011";
//        String ans = s.replaceFirst("0","02");
        String a = s.substring(1);
        System.out.println(a);*/
        /*StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        String n = s.replaceFirst(sb.toString(),sb.append('.').toString());
        System.out.println(sb);
        System.out.println(s);
        System.out.println(n);*/
//        System.out.println(s.replaceFirst("0","0."));

    }

}
