package new_hot100;

import 剑指offer.ListNode;

import java.util.List;

class P19_RemoveNthNodeFromEndOfList {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        ListNode nextN = head;
        for(int i = 1; i < n; i++){
            nextN = nextN.next;
        }
        while (nextN.next != null) {
            cur = cur.next;
            nextN = nextN.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution(); 
    }
}