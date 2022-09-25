package 剑指offer.p001_p050;

import 剑指offer.ListNode;

public class p026_reorderList {
    public void reorderList(ListNode head) {
//        int length = 0;
//        ListNode node = head;
//        while (head!=null){
//            length++;
//            node = node.next;
//        }
//        length = length/2;
//        node = head;
//        while (length>0){
//            node = node.next;
//            length--;
//        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next;
            if (fast.next!=null){
                fast = fast.next;
            }
        }
        /**slow指向中偏右的位置*/
        ListNode temp = slow.next;
        /**使slow指向null*/
        slow.next = null;
        ListNode half = reverseList(temp);
        ListNode nextNode;
        ListNode pre = head;
        while (half!=null){
            nextNode = half.next;
            half.next = pre.next;
            pre.next = half;
            pre = half.next;
            half = nextNode;
        }

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
