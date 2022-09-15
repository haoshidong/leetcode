package 剑指offer;

public class p027_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        /**快慢指针，寻找中间节点*/
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode temp = slow.next;
        ListNode half = reverseList(temp);
        /**比较前后半节点的值是否相等（后半节点的数量=前半部分节点数量or前半部分节点数量-1）*/
        while (half != null && half.val == head.val) {
            half = half.next;
            head = head.next;
        }

        return half == null ? true : false;

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode node = head;
        while (cur != null) {
            node = node.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        return pre;
    }
}
