package Hot100.p001_p050;

import 剑指offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class p104_maxDepth {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        int layer = 0;
        queue1.offer(root);
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
            if (queue1.isEmpty()){
                layer++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return layer;
    }
}
