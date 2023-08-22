package test.yongYou;

import 剑指offer.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class t1 {
    public ListNode groupSort(ListNode head, int n) {
        // write code here
        head = head.next;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        int circle = len / n;
        int i = 0;
        while (circle > 0) {
            i = sortPerN(list, i, n);
            circle--;
        }
        System.out.println(list);
        ListNode dump = new ListNode(1);
        ListNode cur = dump;
        for (int h : list) {
            ListNode node = new ListNode(h);
            cur.next = node;
            cur = cur.next;
        }
        ListNode pre = dump.next;
        while (pre != null){
            System.out.println(pre.val);
            pre = pre.next;
        }
        return dump.next;
    }

    public int sortPerN(List<Integer> list, int i, int n) {
        List<Integer> temp = list.subList(i, i + n);
        temp.sort((a, b) -> b - a);
        int k = 0;
        while (k < n) {
            list.set(i + k, temp.get(k));
            k++;
        }
        return i + n;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode node = head;
        node.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(6);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        t1 t1 = new t1();
        ListNode listNode = t1.groupSort(head, 2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
