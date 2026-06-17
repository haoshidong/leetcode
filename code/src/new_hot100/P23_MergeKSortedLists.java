package new_hot100;

import 剑指offer.ListNode;

import java.util.PriorityQueue;

class P23_MergeKSortedLists {

    
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minPQ = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode node :  lists){
            if(node != null){
                minPQ.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!minPQ.isEmpty()) {
            ListNode head = minPQ.poll();
            cur.next = head;
            cur = cur.next;
            if(head.next != null){
                minPQ.add(head.next);
            }
        }
        return dummy.next;
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P23_MergeKSortedLists().new Solution(); 
    }
}