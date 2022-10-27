package 剑指offer.p101_p150;

import java.util.*;

public class p114_alienOrder {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegrees = new HashMap<>();
        //初始化图和入度表
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<Character>());
                inDegrees.putIfAbsent(ch, 0);
            }
        }
        //给图和入度表赋值
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            if (w1.startsWith(w2) && !w1.equals(w2)) {
                return "";
            }
            for (int j = 0; j < w1.length() && j < w2.length(); j++) {
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                if (ch1 != ch2) {
                    if (!graph.get(ch1).contains(ch2)) {
                        graph.get(ch1).add(ch2);
                        inDegrees.put(ch2, inDegrees.get(ch2) + 1);
                    }
                    break;
                }
            }
        }
        //创建队列，存取入度为0的字符
        Queue<Character> queue = new LinkedList<>();
        //初始化队列
        for (char ch : inDegrees.keySet()) {
            if (inDegrees.get(ch)==0) {
                queue.offer(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);
            for (char next : graph.get(ch)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return sb.length() == graph.size() ? sb.toString() : "";
    }
}
