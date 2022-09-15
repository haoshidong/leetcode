/**
给定一个单链表 L 的头节点 head ，单链表 L 表示为： 

 L0 → L1 → … → Ln-1 → Ln 请将其重新排列后变为： 

 L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 

 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 

 

 示例 1: 

 

 
输入: head = [1,2,3,4]
输出: [1,4,2,3] 

 示例 2: 

 

 
输入: head = [1,2,3,4,5]
输出: [1,5,2,4,3] 

 

 提示： 

 
 链表的长度范围为 [1, 5 * 10⁴] 
 1 <= node.val <= 1000 
 

 

 
 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/ 

 Related Topics 栈 递归 链表 双指针 👍 73 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
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
    public void reorderList(ListNode head) {
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
//leetcode submit region end(Prohibit modification and deletion)
