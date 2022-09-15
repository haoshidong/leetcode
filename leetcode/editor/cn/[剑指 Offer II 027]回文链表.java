/**
给定一个链表的 头节点 head ，请判断其是否为回文链表。 

 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 

 

 示例 1： 

 

 
输入: head = [1,2,3,3,2,1]
输出: true 

 示例 2： 

 

 
输入: head = [1,2]
输出: false
 

 

 提示： 

 
 链表 L 的长度范围为 [1, 10⁵] 
 0 <= node.val <= 9 
 

 

 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 

 

 
 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 

 Related Topics 栈 递归 链表 双指针 👍 71 👎 0

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
//leetcode submit region end(Prohibit modification and deletion)
