package 每日一题;

import java.util.*;

public class p882_reachableNodes {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        //graph[i]表示与节点i所连接的其他节点和两节点间的距离
        List<int[]>[] graph = new ArrayList[n];
        //初始化graph
        Arrays.setAll(graph, e -> new ArrayList<int[]>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            graph[u].add(new int[]{v, cnt + 1});
            graph[v].add(new int[]{u, cnt + 1});
        }

        //迪杰斯特拉算法,得到的是节点start到其他所有节点的最短路径数组dist[]
        int[] dist = dijkstra(graph, 0);

        int ans = 0;
        for (int d : dist) {
            if (d <= maxMoves) {// 这个点可以在 maxMoves 步内到达
                ans++;
            }
        }
        //遍历每条边上的节点
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            //若 maxMoves 大于dist[u]，则经过节点u后，剩余的步数为a；不能到达u，则为0
            int a = Math.max(maxMoves - dist[u], 0);
            //若 maxMoves 大于dist[v]，则经过节点v后，剩余的步数为a；不能到达v，则为0
            int b = Math.max(maxMoves - dist[v], 0);
            ans += Math.min(a + b, cnt);
        }

        return ans;
    }

    // Dijkstra 算法模板
    // 返回从 start 到每个点的最短路
    private int[] dijkstra(List<int[]>[] graph, int start) {
        int[] dist = new int[graph.length];
        //初始化所有距离为无穷大
        Arrays.fill(dist, Integer.MAX_VALUE);
        //start 到 start 的距离为0
        dist[start] = 0;
        //最小堆，每次返回距离 start 最小的顶点
        Queue<int[]> minHead = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHead.offer(new int[]{start, 0});
        while (!minHead.isEmpty()) {
            int[] p = minHead.poll();
            int node = p[0], d = p[1];
            //遍历与节点node直接相连的next节点链表
            for (int[] e : graph[node]) {
                int next = e[0];
                //newDist为 node->next + start->node 两者距离相加
                int newDist = d + e[1];
                //若newDist小于旧的距离，则更新dist数组
                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    minHead.offer(new int[]{next, newDist});
                }
            }
        }
        return dist;
    }
}
