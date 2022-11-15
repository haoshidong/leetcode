package Hot100.p051_p100;

import 剑指offer.ListNode;

public class p148_sortList {
    //归并排序，每次递归的将list一分为二，从最底层开始合并。
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h1 = head;
        ListNode h2 = split(head);

        h1 = sortList(h1);
        h2 = sortList(h2);

        return merge(h1, h2);
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        cur.next = h1 == null ? h2 : h1;
        return dummy.next;
    }

    private ListNode split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        return second;
    }
}
