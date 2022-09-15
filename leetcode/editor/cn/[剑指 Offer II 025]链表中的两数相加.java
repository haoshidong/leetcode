/**
给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 

 可以假设除了数字 0 之外，这两个数字都不会以零开头。 

 

 示例1： 

 

 
输入：l1 = [7,2,4,3], l2 = [5,6,4]
输出：[7,8,0,7]
 

 示例2： 

 
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[8,0,7]
 

 示例3： 

 
输入：l1 = [0], l2 = [0]
输出：[0]
 

 

 提示： 

 
 链表的长度范围为 [1, 100] 
 0 <= node.val <= 9 
 输入数据保证链表代表的数字无前导 0 
 

 

 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。 

 

 
 注意：本题与主站 445 题相同：https://leetcode-cn.com/problems/add-two-numbers-ii/ 

 Related Topics 栈 链表 数学 👍 66 👎 0

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = reverseList(l1);
        ListNode node2 = reverseList(l2);
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;
        while (node1!=null || node2!=null){
            int sum = (node1 == null ? 0 : node1.val)
                    + (node2 == null ? 0 : node2.val) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum-10 : sum;
            ListNode newNode = new ListNode(sum);
            sumNode.next = newNode;
            sumNode = newNode;
            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }
        if (carry > 0){
            sumNode.next = new ListNode(1);
        }
        return reverseList(dummy.next);
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
