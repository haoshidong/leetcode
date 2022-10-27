package 剑指offer.p001_p050;

import 剑指offer.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p044_largestValues {

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root!= null){
            queue1.offer(root);
        }
        List<Integer> result = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while (!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            max = Math.max(max,node.val);
            if (node.left!=null){
                queue2.offer(node.left);
            }
            if (node.right!=null){
                queue2.offer(node.right);
            }
            if (queue1.isEmpty()){
                result.add(max);
                max = Integer.MIN_VALUE;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return result;
    }

    /*public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int current = 0;
        int next = 0;
        if (root != null) {
            queue.offer(root);
            current++;
        }
        List<Integer> result = new LinkedList<>();

        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            while (current != 0) {
                TreeNode currentNode = queue.poll();
                current--;
                max = Math.max(max, currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                    next++;
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                    next++;
                }
            }
            result.add(max);
            current = next;
            next = 0;
        }
        return result;
    }*/
}
