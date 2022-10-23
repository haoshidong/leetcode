package 剑指offer.p101_p150;

import java.util.LinkedList;
import java.util.List;

public class p110_allPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(graph,res,0,path);
        return res;
    }

    private void dfs(int[][] graph, List<List<Integer>> res, int i, LinkedList<Integer> path) {
        if (i==graph.length-1){
            res.add(new LinkedList<>(path));
        }
        for (int next: graph[i]) {
            path.add(next);
            dfs(graph,res,next,path);
            path.removeLast();
        }
    }

}
