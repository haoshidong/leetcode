package Hot100.p001_p050;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.List;
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

    public boolean isValidBST2(TreeNode root) {
        return dfs(root, new ArrayList<Integer>());
    }

    public boolean dfs(TreeNode root, List<Integer> list){
        if(root != null){
            boolean left =  dfs(root.left, list);
            if( list.size() > 0 && root.val <= list.get(list.size() - 1)){
                return false;
            }
            list.add(root.val);
            boolean right =  dfs(root.right, list);
            return left && right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        p98_isValidBST p98IsValidBST = new p98_isValidBST();
        boolean validBST2 = p98IsValidBST.isValidBST2(root);
        System.out.println(validBST2);
    }
}
