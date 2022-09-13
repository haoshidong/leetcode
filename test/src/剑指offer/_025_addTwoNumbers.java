package 剑指offer;

public class _025_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = reverseList(l1);
        ListNode node2 = reverseList(l2);
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;
        while (node1!=null || node2!=null){
            if (node1.val+node2.val>=10){
                ListNode node = new ListNode(node1.val+node2.val-10+carry);
                sumNode.next = node;
                carry = 1;
            }else {
                ListNode node = new ListNode(node1.val+node2.val+carry);
                sumNode.next = node;
                carry = 0;
            }
            dummy =
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
