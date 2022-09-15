/**
给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。 

 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。 

 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。 

 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。 

 

 示例 1： 

 

 
输入：head = [3,4,1], insertVal = 2
输出：[3,4,1,2]
解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后，整
个列表如上图所示，最后返回节点 3 。


 

 示例 2： 

 
输入：head = [], insertVal = 1
输出：[1]
解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。
 

 示例 3： 

 
输入：head = [1], insertVal = 0
输出：[1,0]
 

 

 提示： 

 
 0 <= Number of Nodes <= 5 * 10^4 
 -10^6 <= Node.val <= 10^6 
 -10^6 <= insertVal <= 10^6 
 

 

 
 注意：本题与主站 708 题相同： https://leetcode-cn.com/problems/insert-into-a-sorted-
circular-linked-list/ 

 Related Topics 链表 👍 123 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null){
            head = newNode;
            newNode.next = head;
            return head;
        }
        if (head == head.next){
            head.next = newNode;
            newNode.next = head;
            return head;
        }
        Node node = head;
        int min = head.val;
        int max = head.val;
        Node minNode = head;
        Node maxNode = head;
        while (node.next != head){
            if (min > node.next.val){
                min = node.next.val;
                minNode = node;
            }
            node = node.next;
            if (max < node.val){
                max = node.val;
                maxNode = node;
            }
        }
        if (insertVal < min){
            newNode.next = minNode.next;
            minNode.next = newNode;
            return head;
        }else if (insertVal > max){
            newNode.next = maxNode.next;
            maxNode.next = newNode;
            return head;
        }
            //flag为0，表示循环链表中所有节点的值相等
        boolean flag = true;
        while (node.val == node.next.val){
            node = node.next;
            if (node == head){
                flag = false;
                break;
            }
        }
        //寻找循环链表中值与插入值相等的第一个节点位置,并将新节点插入地相等节点的前一个位置。
        while (insertVal!=node.val){
            if (node.next.val == insertVal){
                newNode.next = node.next;
                node.next = newNode;
            }
            node = node.next;
            if (node == head){
                break;
            }
        }

        while ((node.val > insertVal || node.next.val < insertVal) && flag){
            node = node.next;
        }
        newNode.next = node.next;
        node.next = newNode;
        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
