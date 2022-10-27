package 剑指offer.p101_p150;

import java.util.*;

public class p108_ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //双向广度优先搜索
        Set<String> notVisited = new HashSet<>(wordList);
        if (!notVisited.contains(endWord)) {
            return 0;
        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        int length = 2;
        set1.add(beginWord);
        set2.add(endWord);
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
                    if (set2.contains(neighbor)) {
                        return length;
                    }
                    if (notVisited.contains(neighbor)) {
                        set3.add(neighbor);
                        notVisited.remove(neighbor);
                    }
                }
            }
            length++;
            set1 = set3;
        }
        return 0;

        /*单向广度优先搜索
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        Set<String> notVisited = new HashSet<>(wordList);
        int length = 1;
        q1.offer(beginWord);
        while (!q1.isEmpty()) {
            String word = q1.poll();
            if (word.equals(endWord)) {
                return length;
            }
            List<String> neighbors = getNeighbors(word);
            for (String neighbor : neighbors) {
                if (notVisited.contains(neighbor)) {
                    q2.offer(neighbor);
                    notVisited.remove(neighbor);
                }
            }
            if (q1.isEmpty()) {
                length++;
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }
        return 0;*/
    }

    private List<String> getNeighbors(String word) {
        LinkedList<String> neighbors = new LinkedList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != old) {
                    chars[i] = ch;
                    neighbors.add(new String(chars));
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }
}
