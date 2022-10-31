package Hot100.p001_p050;

import 剑指offer.ListNode;

public class p19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        //fast节点提前走一步，让slow指向待删节点的前置节点
        while (n > 0 && fast.next != null) {
            fast = fast.next;
            n--;
        }
        //head的长度为len，若删除倒数第len的节点，表示删除第一个节点，n为1，返回头结点的下一个节点。
        if (n == 1) {
            return head.next;
            //若删除倒数第len+1的节点，则n>1，表示不用删除节点，直接返回。
        } else if (n > 1) {
            return head;
        }
        //0<n<len，slow指向待删节点的前置节点
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //删除slow的后置节点
        slow.next = slow.next.next;
        return head;
    }
}
