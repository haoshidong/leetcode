package 剑指offer.p101_p150;

import java.util.LinkedList;
import java.util.Queue;

public class p106_isBipartite {
    /*给每个节点染色（1或者2），相邻节点颜色不一样，
    * 若所有节点能正常染色，则返回true    */
    public boolean isBipartite(int[][] graph) {
        int[] gNode = new int[graph.length];

        //若图中有互不连通的子图，则需要循环遍历每个图节点
        for (int i = 0; i < graph.length; i++) {
            //0表示未染色，未染色的先染成1
            if (gNode[i] == 0) {
                gNode[i] = 1;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int col = queue.poll();
                int val = gNode[col];
                for (int j = 0; j < graph[col].length; j++) {
                    int cur = graph[col][j];
                    //不能成功染色，返回false
                    if (gNode[cur] == val) {
                        return false;
                    } else if (gNode[cur] == 0) {
                        queue.offer(cur);
                        if (val == 1) {
                            gNode[cur] = 2;
                        } else if (val == 2) {
                            gNode[cur] = 1;
                        }
                    }
                }
            }
        }

        return true;
    }
}
