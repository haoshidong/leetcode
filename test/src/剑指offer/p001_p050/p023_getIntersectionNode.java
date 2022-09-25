package 剑指offer.p001_p050;

import 剑指offer.ListNode;

public class p023_getIntersectionNode {
    /**
     * 将题目转变为求链表中环的入口节点
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null ){
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1.next!=null){
            node1 = node1.next;
        }
        while (node2.next!=null){
            node2 = node2.next;
        }
        if (node1!=node2){
            return null;
        }
        node1.next = headA;
        ListNode node = detectCycle(headB);
        node1.next = null;
        return node;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null){
            return null;
        }
        ListNode node = head;
        while (node!=inLoop){
            node = node.next;
            inLoop = inLoop.next;
        }
        return node;
    }

    /**
     * 快慢指针，确定链表中是否有环。
     * 若有环，slow的下标必是环的整数倍。
     * */
    private ListNode getNodeInLoop(ListNode head){
        if (head==null || head.next == null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (slow!= null && fast!=null){
            if (slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast!=null){
                fast = fast.next;
            }
        }
        return null;
    }
}
