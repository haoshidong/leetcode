package 剑指offer.p101_p150;

public class p118_findRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int maxVertex = 0;
        for (int[] edge : edges) {
            maxVertex = Math.max(maxVertex, edge[0]);
            maxVertex = Math.max(maxVertex, edge[1]);
        }
        int[] fathers = new int[maxVertex + 1];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
        for (int[] edge : edges) {
            if (!union(fathers, edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[2];
    }

    private boolean union(int[] fathers, int i, int j) {
        int fatherofI = findFather(fathers, i);
        int fatherofJ = findFather(fathers, j);
        if (fatherofI != fatherofJ) {
            fathers[fatherofI] = fatherofJ;
            return true;
        }
        return false;
    }

    private int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }

}
