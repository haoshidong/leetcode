package 每日一题;

import java.util.List;

public class p1773_countMatches {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = ruleKey.charAt(0) == 't' ? 0 : ruleKey.charAt(0) == 'c' ? 1 : 2;
        int count = 0;
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) count++;
        }
        return count;
    }
}
