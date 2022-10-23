package 剑指offer.p101_p150;

import java.util.*;

public class p109_openLock {
    public int openLock(String[] deadends, String target) {
        Set<String> death = new HashSet<>(Arrays.asList(deadends));

        if(target.equals("0000")) return 0;
        if(death.contains("0000") || death.contains(target)) return -1;

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        set1.add("0000");
        set2.add(target);
        visited.add("0000");
        int length = 1;
        while (!set1.isEmpty() && !set2.isEmpty()) {
            if (set1.size() > set2.size()) {
                Set<String> temp = set1;
                set1 = set2;
                set2 = temp;
            }
            Set<String> set3 = new HashSet<>();
            for (String word : set1) {
                List<String> neighbors = getNeighbors(word);
                for (String neighbor : neighbors) {
                    if (death.contains(neighbor)) continue; //如果死锁，换另一个状态
                    if (set2.contains(neighbor)) return length; //下一个状态跟target的状态相同，成功找到路径
                    if (!visited.contains(neighbor)) {
                        set3.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            set1 = set3;
            length++;
        }
        return -1;
    }

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            char old = word.charAt(i);

            char ch = old == '0' ? '9' : (char) (old - 1); //往上拨
            StringBuilder sb = new StringBuilder(word);
            sb.setCharAt(i, ch);
            neighbors.add(sb.toString());

            ch = old == '9' ? '0' : (char) (old + 1);   //往下拨
            sb.setCharAt(i, ch);
            neighbors.add(sb.toString());
        }
        return neighbors;
    }
}
