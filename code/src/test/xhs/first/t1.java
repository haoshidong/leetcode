package test.xhs.first;

import java.util.*;

public class t1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int child = scanner.nextInt();
            int father = scanner.nextInt();
            if (tree.containsKey(father)) {
                tree.get(father).add(child);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(child);
                tree.put(father, set);
            }
        }
        int[] result = balance(tree, n);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] balance(Map<Integer, Set<Integer>> tree, int n) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Set<Integer>> entry : tree.entrySet()) {
            int[] edges = new int[entry.getValue().size()];
            int i = 0;
            for (int edge : entry.getValue()) {
                edges[i++] = edge;
            }
            for (int edge : edges) {
                int a = helper(tree, edge);
                int abs = Math.abs(n - a - a);
//                System.out.println(map.getOrDefault(abs, 0));
                map.put(abs, map.getOrDefault(abs, 0) + 1);
                min = Math.min(min, abs);
            }
        }
        return new int[]{min, map.get(min)};
    }

    private static int helper(Map<Integer, Set<Integer>> temp, int root) {
        int ct = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int cur = q.poll();
            ct++;
            if (temp.containsKey(cur)) {
                for (int child : temp.get(cur)) {
                    q.offer(child);
                }
            }
        }
        return ct;
    }
}
