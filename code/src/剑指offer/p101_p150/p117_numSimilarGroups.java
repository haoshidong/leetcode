package 剑指offer.p101_p150;

import java.util.HashMap;
import java.util.Map;

public class p117_numSimilarGroups {
    public int numSimilarGroups(String[] strs) {
        //创建father图
        Map<String,String> fathers = new HashMap<>();
        //初始化father图
        for (String str : strs) {
            fathers.putIfAbsent(str,str);
        }
        int count = strs.length;
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i==j) continue;
                String t = strs[i];
                String o = strs[j];
                //减去合并的字符串
                if ((isSimilar(t, o) && union(fathers, t, o))) {
                    count--;
                }
            }
        }
        //减去重复的字符串
        return count+fathers.size()-strs.length;
    }

    private boolean union(Map<String, String> fathers, String t, String o) {
        String fatherOft = findFather(fathers,t);
        String fatherOfo = findFather(fathers,o);
        if (fatherOft!=fatherOfo){
            fathers.put(fatherOft,fatherOfo);
            return true;
        }
        return false;
    }

    private String findFather(Map<String, String> fathers, String t) {
        if (fathers.get(t) != t) {
            fathers.put(t,findFather(fathers,fathers.get(t)));
        }
        return fathers.get(t);
    }

    private boolean isSimilar(String t, String o) {
        int change = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i)!=o.charAt(i)){
                change++;
            }
        }
        if (change==2){
            return true;
        }
        return false;
    }
}
