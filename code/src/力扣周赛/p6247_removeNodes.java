package 力扣周赛;

import 剑指offer.ListNode;

import java.util.Stack;

public class p6247_removeNodes {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> down = new Stack<>();
        ListNode node = head;
        ListNode newhead = head;
        while (node!=null){
            if (down.isEmpty()){
                newhead = node;
                down.push(node);
                node = node.next;
            }
            if (down.peek().val>=node.val){
                down.peek().next = node;
                down.push(node);
                node = node.next;
            }else {
                while (!down.isEmpty() && down.peek().val<node.val){
                    down.pop();
                }
                if (down.isEmpty()){
                    newhead = node;
                }else {
                    down.peek().next=node;
                }
                down.push(node);
                node = node.next;
            }
            // down.push(node);
            // node = node.next;
        }
        return newhead;
    }
}
