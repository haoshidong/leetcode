package 剑指offer.p001_p050;

import 剑指offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class p043_CBTInserter {

    TreeNode treeNode = null;

    public p043_CBTInserter(TreeNode root) {
        treeNode = root;
    }

    public int insert(int v) {
        if (treeNode == null){
            treeNode = new TreeNode(v);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null){
                queue.offer(node.left);
            }else {
                node.left = new TreeNode(v);
                return node.val;
            }
            if (node.right!=null){
                queue.offer(node.right);
            }else {
                node.right = new TreeNode(v);
                return node.val;
            }
        }
        return 0;
    }

    public TreeNode get_root() {
        return treeNode;
    }
}
