package 剑指offer;

import java.util.*;

public class p033_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groups = new HashMap<>();
        for (String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            groups.putIfAbsent(sorted,new LinkedList<>());
            groups.get(sorted).add(str);
        }
        return new LinkedList<>(groups.values());
    }
}
