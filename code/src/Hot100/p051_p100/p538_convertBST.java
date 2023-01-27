package Hot100.p051_p100;

import 剑指offer.TreeNode;

public class p538_convertBST {
    private int path = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    /**
     * 右中左的顺序更改节点值
     * 对于每个节点，想要获取的数据：右节点的路径和
     *            想要传给上一层的数据：当前节点的路径和+所有左孩子的和
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root != null) {
            //想要获取的数据
            path = dfs(root.right);
            //更新当前节点的值
            root.val = path + root.val;
            //更新路径和
            path = root.val;
            //递归左孩子
            dfs(root.left);
        }
        //返回给上层想要的数据，若节点不存在，则path值不变
        return path;
    }
}
