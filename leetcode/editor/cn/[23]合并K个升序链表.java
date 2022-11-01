/**
给你一个链表数组，每个链表都已经按升序排列。 

 请你将所有链表合并到一个升序链表中，返回合并后的链表。 

 

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
 

 Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2231 👎 0

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
        /*ListNode res = null;
        for (int i = 1; i < lists.length; i++) {
            res = mergeTwoLists(lists[i],res);
        }
        return res;*/

        //分治法
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*//递归
        if (list1==null) return list2;
        if (list2==null) return list1;
        if (list1.val<list2.val) {
            list1.next = mergeTwoLists(list1.next,list2);   //list1指向下一层两个链表(list1.next,list2)中值最小的节点
            return list1;   // 返回当前层的最小节点
        }else {
            list2.next = mergeTwoLists(list1,list2.next);   //list2指向下一层两个链表(list1,list2.next)中值最小的节点
            return list2;   // 返回当前层的最小节点
        }*/

        //迭代
        //创建头结点
        ListNode prevhead = new ListNode();
        ListNode prev = prevhead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return prevhead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
