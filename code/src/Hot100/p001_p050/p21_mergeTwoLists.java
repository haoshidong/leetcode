package Hot100.p001_p050;

import 剑指offer.ListNode;

public class p21_mergeTwoLists {
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
