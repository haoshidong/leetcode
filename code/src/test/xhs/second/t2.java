package test.xhs.second;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
* 27%
* */
public class t2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String color = in.next();
        boolean[][] g = new boolean[n + 1][n + 1];
        for (int i = 0; i < n - 1; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x][y] = true;
            g[y][x] = true;
        }
        int ans = KstCT(g, color, k);
        System.out.println(ans);
    }

    private static int KstCT(boolean[][] g, String color, int k) {
        int n = g.length;
        int[] allCT = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 1; i < n; i++) {
            if (!visited[i] && color.charAt(i - 1) == 'R') {
                visited[i] = true;
                int subCT = lianTong(i, g, color,visited);
                allCT[subCT]++;
            }
        }
        for (int i = n-1; i >= 0 ; i--) {
            if (allCT[i] >= k){
                return i;
            }else {
                k -= allCT[i];
            }
        }
        return -1;
    }

    private static int lianTong(int root, boolean[][] g, String color, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        int ct = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            ct++;
            for (int i = 1; i < g.length; i++) {
                if (!visited[i] && g[cur][i] && color.charAt(i - 1) == 'R'){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
        return ct;
    }
}
