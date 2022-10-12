/**
给定一个链表数组，每个链表都已经按升序排列。 

 请将所有链表合并到一个升序链表中，返回合并后的链表。 

 

 示例 1： 

 
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
 

 示例 2： 

 
输入：lists = []
输出：[]
 

 示例 3： 

 
输入：lists = [[]]
输出：[]
 

 

 提示： 

 
 k == lists.length 
 0 <= k <= 10^4 
 0 <= lists[i].length <= 500 
 -10^4 <= lists[i][j] <= 10^4 
 lists[i] 按 升序 排列 
 lists[i].length 的总和不超过 10^4 
 

 

 
 注意：本题与主站 23 题相同： https://leetcode-cn.com/problems/merge-k-sorted-lists/ 

 Related Topics 链表 分治 堆（优先队列） 归并排序 👍 58 👎 0

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start + 1 == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode head1 = mergeLists(lists, start, mid);
        ListNode head2 = mergeLists(lists, mid, end);
        return merge(head1, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
