package Hot100.p051_p100;

import 剑指offer.ListNode;

public class p234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;

        ListNode pre = null;
        ListNode cur = second;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        second = pre;
        while (second!=null){
            if (second.val != first.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }
}
