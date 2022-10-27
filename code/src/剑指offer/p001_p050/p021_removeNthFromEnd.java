package 剑指offer.p001_p050;

import 剑指offer.ListNode;

public class p021_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        int i = 0;
        int k = 0;
        ListNode node = dummy;
        while (node.next!=null && i<k+n){
            node=node.next;
            i++;
        }
        ListNode node1 = dummy;
        while (node.next!=null){
            node=node.next;
            node1 = node1.next;
        }
        node1.next = node1.next.next;
        return dummy.next;
    }
}
