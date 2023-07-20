package test;

import java.util.*;

public class t7 {
    static class Node{
        String id;
        String parentId;

        public Node(String _id, String _parentId){
            id = _id;
            parentId = _parentId;
        }

        public Node(){}
    }

    static class TreeNode{
        String id;
        List<TreeNode> children;

        public TreeNode(){};
        public TreeNode(String _id, List<TreeNode> _children){
            id = _id;
            children = _children;
        }
    }

    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        list.add(new Node("s1", "s2"));
        list.add(new Node("s2", "s3"));
        list.add(new Node("s4", "s3"));
        list.add(new Node("s5", "s6"));
        list.add(new Node("s3", "null"));
        list.add(new Node("s6", "s7"));
        list.add(new Node("s7", "null"));
        t7 test = new t7();
        List<TreeNode> tree = test.convertListToTree(list);
        for (TreeNode root : tree) {
            test.shuchu(root);
            System.out.println("");
        }
    }

    private void shuchu(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ct = 1;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            ct--;

            System.out.print(cur.id + " ");

            if (!cur.children.isEmpty()){
                for (TreeNode ndoe : cur.children) {
                    queue.add(ndoe);
                }
            }
            if (ct == 0){
                ct = queue.size();
                System.out.println("");
            }
        }

    }

    private  List<TreeNode> convertListToTree(List<Node> list) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, TreeNode> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            String id = node.id;
            String parentId = node.parentId;
            if (!map.containsKey(id)){
                TreeNode cur = new TreeNode(id, new ArrayList<TreeNode>());
                map.put(id, cur);
            }
            if (parentId.equals("null")){
                res.add(map.get(id));
                continue;
            }else if (!map.containsKey(parentId)){
                TreeNode prev = new TreeNode(parentId, new ArrayList<TreeNode>());
                map.put(parentId, prev);
            }
            TreeNode cur = map.get(id);
            TreeNode prev = map.get(parentId);
            prev.children.add(cur);
        }
        return res;
    }
}
