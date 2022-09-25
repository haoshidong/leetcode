package 剑指offer.p001_p050;

import 剑指offer.TreeNode;

public class p048_Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String leftStr = serialize(root.left);
        String rightStr = serialize(root.right);
        return String.valueOf(root.val) + "," + leftStr + "," + rightStr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeStrs = data.split(",");
        int[] i = {0};
        return dfs(nodeStrs, i);
    }

    private TreeNode dfs(String[] Strs, int[] i) {
        String str = Strs[i[0]];
        i[0]++;
        if (str.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = dfs(Strs, i);
        node.right = dfs(Strs, i);
        return node;
    }

}
