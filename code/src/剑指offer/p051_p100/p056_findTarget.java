package 剑指offer.p051_p100;

import 剑指offer.TreeNode;

import java.util.HashSet;
import java.util.Stack;

public class p056_findTarget {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        HashSet<Integer> set = new HashSet<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (set.contains(k - cur.val)) {
                return true;
            }
            set.add(cur.val);
            cur = cur.right;
        }
        return false;
    }
}
