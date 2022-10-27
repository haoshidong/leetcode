package Hot100.p001_p050;

import 剑指offer.ListNode;

public class p2_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cur;
        int next = 0;
        int sum;
        ListNode node = new ListNode();
        ListNode res = node;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                sum = l2.val + next;
            } else if (l2 == null) {
                sum = l1.val + next;
            } else {
                sum = l1.val + l2.val + next;
            }
            cur = sum % 10;
            node.next = new ListNode(cur);
            node = node.next;
            next = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        node.next = next > 0 ? new ListNode(next) : null;
        return res.next;
    }
}
