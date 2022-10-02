package 剑指offer.p051_p100;

import 剑指offer.TreeNode;

public class p053_inorderSuccessor {
    /*TreeNode prev = null;
    TreeNode res = null;*/
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode cur = root;
        TreeNode res = null;
        while (cur!=null){
            if (cur.val> p.val){
                res = cur;
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return res;

        /*dfs(root,p);
        return res;*/
    }

    /*private void dfs(TreeNode root, TreeNode p) {
        if (root==null){
            return;
        }
        dfs(root.left,p);
        if (prev!=null && prev.val == p.val){
            res = root;
        }
        prev = root;
        dfs(root.right,p);
    }*/

}
