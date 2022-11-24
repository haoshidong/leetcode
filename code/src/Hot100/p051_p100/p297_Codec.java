package Hot100.p051_p100;

import 剑指offer.TreeNode;

import java.util.Stack;

public class p297_Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                sb.append(cur.val+',');
                stack.push(cur);
                cur = cur.left;
            }
            sb.append("#,");
            cur = stack.pop();
            cur = cur.right;
        }
        sb.append('#');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] i = {0};
        return dfs(nodes, i);
    }

    private TreeNode dfs(String[] nodes, int[] i) {
        String str = nodes[i[0]];
        i[0]++;
        if (str.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(str));
        root.left = dfs(nodes, i);
        root.right = dfs(nodes, i);
        return root;
        /*if (nodes[i[0]] == "#") {
            return null;
        } else {
            int val = Integer.valueOf(nodes[i[0]]);
            TreeNode root = new TreeNode(val);
            i[0]++;
            root.left = dfs(nodes, i);
            i[0]++;
            root.right = dfs(nodes, i);
            return root;
        }*/
    }

}
