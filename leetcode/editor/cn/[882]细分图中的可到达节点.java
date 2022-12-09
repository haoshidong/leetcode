/**
给你一个无向图（原始图），图中有 n 个节点，编号从 0 到 n - 1 。你决定将图中的每条边 细分 为一条节点链，每条边之间的新节点数各不相同。 

 图用由边组成的二维数组 edges 表示，其中 edges[i] = [ui, vi, cnti] 表示原始图中节点 ui 和 vi 之间存在一条边，
cnti 是将边 细分 后的新节点总数。注意，cnti == 0 表示边不可细分。 

 要 细分 边 [ui, vi] ，需要将其替换为 (cnti + 1) 条新边，和 cnti 个新节点。新节点为 x1, x2, ..., xcnti ，新边
为 [ui, x1], [x1, x2], [x2, x3], ..., [xcnti+1, xcnti], [xcnti, vi] 。 

 现在得到一个 新的细分图 ，请你计算从节点 0 出发，可以到达多少个节点？如果节点间距离是 maxMoves 或更少，则视为 可以到达 。 

 给你原始图和 maxMoves ，返回 新的细分图中从节点 0 出发 可到达的节点数 。 

 

 示例 1： 
 
 
输入：edges = [[0,1,10],[0,2,1],[1,2,2]], maxMoves = 6, n = 3
输出：13
解释：边的细分情况如上图所示。
可以到达的节点已经用黄色标注出来。
 

 示例 2： 

 
输入：edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], maxMoves = 10, n = 4
输出：23
 

 示例 3： 

 
输入：edges = [[1,2,4],[1,4,5],[1,3,1],[2,3,4],[3,4,5]], maxMoves = 17, n = 5
输出：1
解释：节点 0 与图的其余部分没有连通，所以只有节点 0 可以到达。
 

 

 提示： 

 
 0 <= edges.length <= min(n * (n - 1) / 2, 10⁴) 
 edges[i].length == 3 
 0 <= ui < vi < n 
 图中 不存在平行边 
 0 <= cnti <= 10⁴ 
 0 <= maxMoves <= 10⁹ 
 1 <= n <= 3000 
 

 Related Topics 图 最短路 堆（优先队列） 👍 114 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
