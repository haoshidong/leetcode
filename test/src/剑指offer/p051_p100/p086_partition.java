package 剑指offer.p051_p100;

import java.util.LinkedList;
import java.util.List;

public class p086_partition {
    public String[][] partition(String s) {
        List<List<String>> res = new LinkedList<>();
        LinkedList<String> subStrings = new LinkedList<>();
        helper(s, 0, subStrings, res);
        String[][] result = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i).toArray(new String[0]);
        }
        return result;
    }

    private void helper(String str, int start, LinkedList<String> subStrings, List<List<String>> res) {
        if (start == str.length()) {
            res.add(new LinkedList<>(subStrings));
        }
        for (int i = start; i < str.length(); i++) {
            if (isPalindrome(str, start, i)) {
                subStrings.add(str.substring(start,i+1));
                helper(str,i+1,subStrings,res);
                subStrings.removeLast();
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
