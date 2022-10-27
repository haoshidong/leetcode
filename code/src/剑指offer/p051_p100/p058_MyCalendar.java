package 剑指offer.p051_p100;

import java.util.Map;
import java.util.TreeMap;

public class p058_MyCalendar {
    TreeMap<Integer, Integer> treeMap;

    public p058_MyCalendar() {
        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> lower = treeMap.floorEntry(start);
        if (lower != null && start < lower.getValue()) {
            return false;
        }
        Map.Entry<Integer,Integer> upper = treeMap.ceilingEntry(start);
        if (upper != null && end > upper.getKey()){
            return false;
        }
        treeMap.put(start,end);
        return true;
    }
}
