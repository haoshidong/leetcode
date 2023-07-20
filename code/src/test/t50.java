package test;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class t50 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(10,new TreeNode(9, new TreeNode(5), null), new TreeNode(6));
        node.right = new TreeNode(4,new TreeNode(7, new TreeNode(13), null), new TreeNode(6));
        List<List<Integer>> allPath = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        getPath(node, 29, path, allPath);
        for (List<Integer> p : allPath){
            System.out.print("[");
            for (int num : p){
                System.out.print(num + ",");
            }
            System.out.print("]");
        }
    }

    private static void getPath(TreeNode root, int target, List<Integer> path, List<List<Integer>> allPath) {
        if (target >= 0){
            if (root != null){
                target -= root.val;
                path.add(root.val);
                if (target == 0){
                    allPath.add(new ArrayList<>(path));
                }
                getPath(root.left, target, path, allPath);
                getPath(root.right, target, path, allPath);
                path.remove(path.size() - 1);
                target += root.val;
            }
        }
    }
}
