package Hot100.p001_p050;

import java.util.*;

public class p49_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //优化
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            //map的key为排序后的字符串s
            String s = new String(chars);
            //获取key对应list值，若不存在，new一个
            List<String> list = map.getOrDefault(s,new ArrayList<>());
            list.add(str);
            //将当前字符串str添加到map中
            map.put(s,list);
        }
        return new ArrayList<>(map.values());

        /*Map<String, LinkedList<Integer>> map = new HashMap<>();
        //将每个字符串中的字符排序，排序后的字符串为键，字符在strs[]的下标为值。
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            if (map.containsKey(str)) {
                map.get(str).add(i);
            } else {
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(i);
                map.put(str, linkedList);
            }
        }
        List<List<String>> res = new LinkedList<>();
        for (LinkedList<Integer> linkedList : map.values()) {
            List<String> list = new LinkedList<>();
            for (int num : linkedList) {
                list.add(strs[num]);
            }
            res.add(list);
        }
        return res;*/
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = new p49_groupAnagrams().groupAnagrams(strs);
        for (List<String> l : res) {
            for (String s : l) {
                System.out.print(s+" ");
            }
            System.out.println("");
        }
    }
}
