package Hot100.p001_p050;

import 剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class p94_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;

        /*List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;*/
    }

    //中序遍历 递归
    private void dfs(TreeNode root, List<Integer> ans) {
        if (root != null) {
            dfs(root.left, ans);
            ans.add(root.val);
            dfs(root.right, ans);
        }
    }
}
