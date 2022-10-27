package 剑指offer.p001_p050;

import 剑指offer.TreeNode;

public class p047_pruneTree {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left==null && root.right==null&&root.val==0){
            return null;
        }
        return root;
    }

}
