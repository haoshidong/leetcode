package 剑指offer.p001_p050;

import 剑指offer.ListNode;

public class p025_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = reverseList(l1);
        ListNode node2 = reverseList(l2);
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;
        while (node1!=null || node2!=null){
            int sum = (node1 == null ? 0 : node1.val)
                    + (node2 == null ? 0 : node2.val) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum-10 : sum;
            ListNode newNode = new ListNode(sum);
            sumNode.next = newNode;
            sumNode = newNode;
            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }
        if (carry > 0){
            sumNode.next = new ListNode(1);
        }
        return reverseList(dummy.next);
    }
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
