package new_hot100;

import 剑指offer.ListNode;

class P21_MergeTwoSortedLists {

    
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 固定虚拟头，不动
        ListNode dummy = new ListNode(-1);
        // cur 遍历指针，用来拼接节点
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 !=  null ? list1 : list2;
        return dummy.next;
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P21_MergeTwoSortedLists().new Solution(); 
    }
}