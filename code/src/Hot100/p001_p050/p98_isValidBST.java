package Hot100.p001_p050;

import 剑指offer.TreeNode;

import java.util.Stack;

public class p98_isValidBST {
    public boolean isValidBST(TreeNode root) {
        TreeNode first = root;
        while (first.left!=null){
            first = first.left;
        }
        int pre = first.val;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.val <= pre) {
                return false;
            }
            pre = cur.val;
            cur = cur.right;
        }
        return true;
    }
}
