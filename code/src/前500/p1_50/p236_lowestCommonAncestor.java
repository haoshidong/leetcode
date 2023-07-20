package 前500.p1_50;

import 剑指offer.TreeNode;

public class p236_lowestCommonAncestor {
    private int count = 2;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q, root);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q, TreeNode Ancestor) {
        if (root == null) {
            return null;
        }
        if (count == 2) {
            Ancestor = root;
        }
        if (root == p || root == q) {
            count--;
        }
        if (count == 0) {
            return Ancestor;
        }
        TreeNode left = dfs(root.left, p, q, Ancestor);
        if (left != null) {
            return left;
        }
        TreeNode right = dfs(root.right, p, q, Ancestor);
        if (right != null) {
            return right;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        node.left = p;
        TreeNode q = new TreeNode(1);
        node.right = q;
        p236_lowestCommonAncestor solution = new p236_lowestCommonAncestor();
        TreeNode node1 = solution.lowestCommonAncestor(node, p, q);
        System.out.println(node1.val);
    }
}
