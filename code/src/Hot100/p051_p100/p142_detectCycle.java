package Hot100.p051_p100;

import 剑指offer.ListNode;

public class p142_detectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        if (fast == null) {
            return null;
        }
        int count = 1;
        fast = fast.next;
        while (slow != fast) {
            fast = fast.next;
            count++;
        }
        slow = head;
        fast = head;
        for (; count > 0; count--) {
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
