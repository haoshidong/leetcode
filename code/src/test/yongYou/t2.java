package test.yongYou;

import java.util.*;

public class t2 {

    public ArrayList<ArrayList<String>> buildTreeWithLevel(String[] source) {
        // write code here
        Map<Character, List<Character>> g = new HashMap<>();
        for (String s : source) {
            char father = s.charAt(0);
            char child = s.charAt(2);
            if (g.containsKey(father)) {
                g.get(father).add(child);
            } else {
                List<Character> list = new ArrayList<>();
                list.add(child);
                g.put(father, list);
            }
        }
        Queue<Character> queue = new ArrayDeque<>();
        queue.add(source[0].charAt(0));
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            List<String> level = new ArrayList<>();
            int n = queue.size();
            while (n > 0) {
                Character fa = queue.poll();
                level.add(String.valueOf(fa));
                if(g.containsKey(fa)) {
                    for (char ch : g.get(fa)) {
                        queue.add(ch);
                    }
                }
                n--;
            }
            res.add(new ArrayList<>(level));
        }

        return res;
    }

    public static void main(String[] args) {
        t2 t2 = new t2();
        String[] s = {"a,b","a,c","c,d","c,e","e,f"};
        ArrayList<ArrayList<String>> arrayLists = t2.buildTreeWithLevel(s);
        for(ArrayList<String> list : arrayLists){
            System.out.println(list);
        }
    }
}
