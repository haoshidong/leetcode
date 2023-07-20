package 剑指offer.p051_p100;

import 剑指offer.TreeNode;

import java.nio.charset.StandardCharsets;
import java.util.Stack;

public class p052_increasingBST {
    TreeNode prev = null;
    TreeNode first = null;
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return first;
        /*Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;
        while (cur!= null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();

            if (prev!=null){
                prev.right = cur;
            }else {
                first = cur;
            }

            prev = cur;
            cur.left = null;
            cur = cur.right;
        }
        return first;*/
    }

    private void dfs(TreeNode root) {
        if (root!=null){
            dfs(root.left);
            if (prev!=null){
                prev.right = root;
            }else {
                first = root;
            }
            prev = root;
            root.left = null;
            dfs(root.right);
        }
    }
}
