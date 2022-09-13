/**
给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。 

 图示两个链表在节点 c1 开始相交： 

 

 题目数据 保证 整个链式结构中不存在环。 

 注意，函数返回结果后，链表必须 保持其原始结构 。 

 

 示例 1： 

 

 
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, 
skipB = 3
输出：Intersected at '8'
解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 

 示例 2： 

 

 
输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Intersected at '2'
解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 

 示例 3： 

 

 
输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
这两个链表不相交，因此返回 null 。
 

 

 提示： 

 
 listA 中节点数目为 m 
 listB 中节点数目为 n 
 0 <= m, n <= 3 * 10⁴ 
 1 <= Node.val <= 10⁵ 
 0 <= skipA <= m 
 0 <= skipB <= n 
 如果 listA 和 listB 没有交点，intersectVal 为 0 
 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1] 
 

 

 进阶：能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？ 

 

 
 注意：本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-
lists/ 

 Related Topics 哈希表 链表 双指针 👍 46 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * 将题目转变为求链表中环的入口节点
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null ){
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1!=node2){
            /**
             * 若两链表不相交：
             * 1）两链表长度相等，则同时到达链表末尾，同时指向null。
             * 2）两链表长度不相等，node1走过链表A后，再走链表B；node2走过链表B后，再走链表A,最后同时
             *      到达末尾，同时指向null。
             * */
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
