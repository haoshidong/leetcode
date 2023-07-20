package test.bd;

import java.util.*;

public class t3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        System.out.println(n);
        String colors = in.next();
//        System.out.println(colors);
        List<Set<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            graph.add(new HashSet<>());
        }
//        System.out.println(graph.size());
        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
//            System.out.println("a:" + a);
            int b = in.nextInt();
//            System.out.println("b:" + b);
            graph.get(a).add(b);
            graph.get(b).add(a);
            edges[i][0] = a;
            edges[i][1] = b;
        }
        int weight = weight(colors, graph, edges);

        System.out.println(weight);
    }

    private static int weight(String colors, List<Set<Integer>> graph, int[][] edges) {
        int ans = 0;
        int n = colors.length();
        //每次移除一条边
        for (int[] edge : edges) {
            List<Set<Integer>> g = new ArrayList<>(graph);
            g.get(edge[0]).remove(edge[1]);
            g.get(edge[1]).remove(edge[0]);
            int x = weightDiffer(g, edge[0], colors);
            int y = weightDiffer(g, edge[1], colors);
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
            ans += Math.abs(x - y);
        }
        return ans;
    }

    private static int weightDiffer(List<Set<Integer>> g, int a, String colors) {
        int subSameColor = 0;
        char color = colors.charAt(a-1);
        boolean[] isVisited = new boolean[colors.length()+1];
        isVisited[a] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(a);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            subSameColor++;
            //如果node节点有孩子
            if (g.get(node).size() > 0) {
                for (int child : g.get(node)) {
                    //如果孩子颜色相同，且之前没去过
                    if (colors.charAt(child - 1) == color && !isVisited[child]) {
                        isVisited[child] = true;
                        queue.offer(child);
                    }
                }
            }
        }
        return subSameColor;
    }
}
