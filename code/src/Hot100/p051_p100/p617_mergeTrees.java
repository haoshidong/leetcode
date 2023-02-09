package Hot100.p051_p100;

import 剑指offer.Node;
import 剑指offer.TreeNode;

public class p617_mergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 != null || root2 != null) {
            //当前层要做的事：合并节点val值
            if (root1 != null && root2 != null) {
                root1.val += root2.val;
            } else if (root1 == null) {
                TreeNode node = new TreeNode(root2.val);
                root1 = node;
            } else {
                root2 = new TreeNode();
            }
            //需要下层提供合并好的节点作为孩子
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            //返回给上一层，此层合并好的节点
            return root1;
        }
        return null;
//        return dfs(root1, root2);
    }

    /*private TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 != null || root2 != null) {
            if (root1 != null && root2 != null) {
                root1.val += root2.val;
            } else if (root1 == null) {
                TreeNode node = new TreeNode(root2.val);
                root1 = node;
            } else {
                root2 = new TreeNode();
            }
            root1.left = dfs(root1.left, root2.left);
            root1.right = dfs(root1.right, root2.right);
            return root1;
        }
        return null;
    }*/
}
