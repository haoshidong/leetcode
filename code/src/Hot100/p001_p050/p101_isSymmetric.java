package Hot100.p001_p050;

import 剑指offer.TreeNode;

import java.util.*;

public class p101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root==null || (root.left==null && root.right == null)){
            return true;
        } else if (root.left==null || root.right == null) {
            return false;
        }
        //用队列保存节点
        Queue<TreeNode> queue = new LinkedList<>();
        //将根节点的左右孩子放到队列中
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            //从队列中取出两个节点，再比较这两个节点
            TreeNode l = queue.poll();
            TreeNode r = queue.poll();
            //如果两个节点都为空就继续循环，两者有一个为空就返回false
            if (l==null && r==null){
                continue;
            } else if (l==null || r==null) {
                return false;
            }
            //若值相等，将左节点的左孩子、右节点的右孩子，左节点的右孩子、右节点的左孩子分别入队；
            // 不相等接返回false
            if (l.val==r.val){
                queue.offer(l.left);
                queue.offer(r.right);
                queue.offer(l.right);
                queue.offer(r.left);
            }else {
                return false;
            }
        }
        return true;
    }
}
