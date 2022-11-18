package Hot100.p051_p100;

import 剑指offer.TreeNode;

public class p236_lowestCommonAncestor {

    /*
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        T reeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }*/

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
        //找到了一个，count--
        if (root == p || root == q) {
            count--;
        }
        //全部找到，返回祖先节点
        if (count == 0) {
            return Ancestor;
        }
        //去左子树寻找
        TreeNode left = dfs(root.left, p, q, Ancestor);
        if (left != null) {
            return left;
        }
        //去右子树寻找
        TreeNode right = dfs(root.right, p, q, Ancestor);
        if (right != null) {
            return right;
        }
        //左右子树都没找到，并且当前节点也没找到p和q，返回null；
        return null;
    }
}
