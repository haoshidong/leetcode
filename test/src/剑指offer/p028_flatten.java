package 剑指offer;

public class p028_flatten {
    public Node flatten(Node head) {
        if (head == null){
            return null;
        }
        /**哨兵节点记录第一个节点的位置*/
        Node dummy = new Node();
        dummy.next = head;
        head = recursive(head);

        return dummy.next;
    }
    public Node recursive(Node head){
        /**从左往右寻找有孩子指针的节点*/
        while (head.next != null && head.child == null){
            head = head.next;
        }
        /**保存父节点的下一个节点，并将孩子节点拼接父节点在后面*/
        if (head.child!=null ) {
            //保存父节点
            Node nextNode = head.next;
            //将孩子节点拼接父节点在后面
            head.next = head.child;
            head.child = null;
            head.next.prev = head;
            //寻找子链表中带有孩子指针的节点，并返回最里层递归链表的最右边节点
            Node up = recursive(head.next);
            /**若父节点所在链表后面无节点，直接返回下一层递归最右边的节点。
             * 否则，将返回的最右边节点与父节点的next节点拼接。*/
            if (nextNode != null) {
                up.next = nextNode;
                nextNode.prev = up;
            }
            //得到此层链表最右边的节点。
            while (up.next!=null){
                up = up.next;
            }
            //返回最右边的节点
            return up;
        }else {
            //返回最里层的最右边的节点。
            return head;
        }
    }
}
