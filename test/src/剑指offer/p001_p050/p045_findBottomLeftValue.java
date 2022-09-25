package 剑指offer.p001_p050;

import 剑指offer.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p045_findBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root != null) {
            queue1.offer(root);
        }
        int result = root.val;
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                if (!queue1.isEmpty()){
                    result = queue1.peek().val;
                }
            }
        }
        return result;
    }
}
