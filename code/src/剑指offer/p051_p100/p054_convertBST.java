package 剑指offer.p051_p100;

import 剑指offer.TreeNode;

import java.util.Stack;

public class p054_convertBST {
    public TreeNode convertBST(TreeNode root) {
        int path = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            path += cur.val;
            cur.val = path;
            cur = cur.left;
        }
        return root;
    }
}
