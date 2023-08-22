package test;

import 剑指offer.ListNode;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> integers = new ArrayList<>(list);
        Integer remove = integers.remove(1);
//        return positive ? temp : 1 / temp;

//        int[][] people = {};
//        Arrays.sort(people, (a,b) -> {
//            if(a[0] == b[0]){
//                return a[1] - b[1];
//            }
//            return b[0] - a[0];
//        });
//        LinkedList<int[]> res = new LinkedList<>();
//
//        String p = " ";
//        for(int[] p : people){
//            res.add(p[1], p);
//        }
//        int[][] array = res.toArray(new int[people.length][]);
//        Map<Character, Integer> pToCt = new HashMap<>();
//        for(char ch : p.toCharArray()){
//            pToCt.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        int l = 0;
//        int r = 0;
//        Map<Character, Integer> window = new HashMap<>(pToCt);
//        for(;r < p.length(); r++){
//
//        }

//        byte a = 'A';
//        System.out.println(a);
//
//        int[] nums = {1,2,8,4,9,3};
//        Arrays.sort(nums);
//        List<String> res = new ArrayList<>();
//        String.join(" ", res);
//        Deque<Integer> q = new ArrayDeque<>();
//
//        int[][] matrix = new int[4][2];
//        matrix[0] = new int[]{0, 0};
//        for (int[] m : matrix) {
//            Arrays.fill(m, -1);
//        }
//        for (int[] num : matrix) {
//            for (int nu : num) {
//                System.out.print(nu + " ,");
//            }
//            System.out.println("");
//        }
//        int[][] nums = new int[][]{{0,1}};

//        ArrayList<Integer> list = new ArrayList<>();
//        list.
//
//        OOMObject oomObject = null;
//        System.out.println(oomObject);

        /*String s = "";
        System.out.println("".equals(s));*/

//        String s = "11100111011111";
//        String[] split1 = s.split("0");
//        System.out.println(split1.length);
//        int ct1 = 0;
//        int ct0 = 0;
//
//        for (String s1 : split1) {
//            System.out.println(s1);
//        }
//        String[] split0 = s.split("1");
//        System.out.println(split0.length);
//        for (String s0 : split0) {
//            System.out.println(s0);
//        }
//        for (String s1 : split1) {
//            if (s1.length()>0){
//                ct1++;
//            }
//        }
//        for (String s0 : split0) {
//            if (s0.length()>0){
//                ct0++;
//            }
//        }
//        System.out.println(ct0);
//        System.out.println(ct1);
//
//        System.out.println(2);

//        Scanner in = new Scanner(System.in);
//        int x = in.nextInt();
//        in.next();
//        String s = in.next();
//        System.out.println(s);
//        String[] strs = s.split(" ");

//        float n = 0L;
//        for(String str : strs){
//            n += str.length();
//            System.out.println(str);
//        }
//        if (strs.length == 1) {
//            System.out.println(s.length());
//        } else {
//            System.out.printf("%.2f",n / (float) (strs.length));
//        }

        /*List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }*/
//
//        String s = "RWRR";
////        char c = s.charAt(0);
//        System.out.println(s.charAt(0) == 'R');

//        ConcurrentHashMap
//        Hashtable
//        int i = null;
//        String
//        Map<Integer,Integer> map = new HashMap<>();
//        map.put(null,1);
//        map.put(null,null);
//        System.out.println(map.get(1));
//        Set<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        Object[] objects = set.toArray();
//        for (int i = 0; i < 2; i++) {
//            System.out.println(objects[i]);
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append('a');
//        sb.append('b');
//        sb.deleteCharAt(sb.length()-1);
//        System.out.println(sb.toString());

//        ArrayList<Integer> list = new ArrayList<>();
//        list.remove(list.size()-1);
//        // 字符串常量池中已存在字符串对象“abc”的引用
//        String s1 = "abc";
//
//        // 下面这段代码只会在堆中创建 1 个字符串对象“abc”
//        String s2 = new String("abc");
//        String s3 = new String("abc");
//        String s4 = "abc";
//        System.out.println(s3==s2);
//        System.out.println(s1==s3);
//        System.out.println(s1==s4);

//        char s = '5';
//        int a = s - '0';
//        System.out.println(s);
//        System.out.println(a);

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
