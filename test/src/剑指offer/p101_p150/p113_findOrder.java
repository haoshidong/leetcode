package 剑指offer.p101_p150;

import java.util.*;

public class p113_findOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //键为图的节点，值为节点指向的节点列表
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
        }
        //入度表
        int[] inDegrees = new int[numCourses];
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            inDegrees[prereq[0]]++;
        }
        //集合中存取所有入度为0的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> order = new LinkedList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order.add(course);
            for (int next : graph.get(course)) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return order.size() == numCourses ? order.stream().mapToInt(i -> i).toArray() : new int[0];
    }
}
