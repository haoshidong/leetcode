package Hot100.p051_p100;

import java.util.*;

public class p207_canFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i,new LinkedList<>());
        }
        int[] inDegrees = new int[numCourses];
        for (int[] pre : prerequisites) {
            inDegrees[pre[0]]++;
            graph.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i]==0){
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int next : graph.get(course)) {
                inDegrees[next]--;
                if (inDegrees[next]==0){
                    queue.add(next);
                }
            }
        }
        return count==numCourses;
    }
}
