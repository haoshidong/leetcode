package Hot100.p001_p050;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        ans.add(new ArrayList<>(list));
        while (!queue1.isEmpty()) {
            TreeNode ndoe = queue1.poll();
            if (ndoe.left != null) {
                queue2.offer(ndoe.left);
            }
            if (ndoe.right != null) {
                queue2.offer(ndoe.right);
            }
            if (queue1.isEmpty() && !queue2.isEmpty()) {
                queue1 = queue2;
                list = new ArrayList<>();
                for (TreeNode tn : queue1) {
                    list.add(tn.val);
                }
                ans.add(new ArrayList<>(list));
                queue2 = new LinkedList<>();
            }
        }
        return ans;
    }
}
