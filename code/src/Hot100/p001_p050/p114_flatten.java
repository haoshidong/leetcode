package Hot100.p001_p050;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class p114_flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        while (!stack.isEmpty()) {
            while (cur != null) {
                nodes.add(cur);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).right = nodes.get(i + 1);
            nodes.get(i).left = null;
        }
    }
}
