package 剑指offer.p001_p050;

import 剑指offer.ListNode;

public class p024_reverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode node = head;
        while (cur!=null){
            node=node.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        return pre;
    }
}
