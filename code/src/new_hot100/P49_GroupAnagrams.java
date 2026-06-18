package new_hot100;

import java.util.*;
import java.util.stream.Collectors;

class P49_GroupAnagrams {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (!map.containsKey(sorted)){
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted,list);
            } else {
                map.get(sorted).add(s);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P49_GroupAnagrams().new Solution(); 
    }
}