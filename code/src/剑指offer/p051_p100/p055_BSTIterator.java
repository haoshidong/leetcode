package 剑指offer.p051_p100;

import 剑指offer.TreeNode;

public class p055_BSTIterator {
    TreeNode root;
    TreeNode cur;

    public p055_BSTIterator(TreeNode root) {
        this.root = root;
        cur = new TreeNode(Integer.MIN_VALUE);
    }

    public int next() {
        cur = inorderSuccessor(root);
        return cur.val;
    }

    public boolean hasnext() {
        TreeNode node = inorderSuccessor(root);
        if (node == null) {
            return false;
        }
        return true;
    }

    private TreeNode inorderSuccessor(TreeNode root) {
        TreeNode node = root;
        TreeNode res = null;
        while (node != null) {
            if (node.val > cur.val) {
                res = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return res;
    }
}
