package 剑指offer.p001_p050;

import 剑指offer.Node;

/*为了方便，我们记 insertVal 为 x，记 head 为 he。

起始我们先将待插入的节点创建出来，记为 t，当 he 为空时，直接返回 t 即可。

由于我们需要返回原本的头结点，因此我们先使用变量 ans 对原始的 he 进行转存，随后复用 he 来充当游标进行遍历。

我们先对链表进行一次完成遍历，遍历过程中维护节点最值 max 和 min，由于链表是循环的，我们需要使用 he.next != ans 作为我们循环的结束条件，含义为回到链表开头。

此时根据最大值和最小值是否相等（即整段链表值是否一致）来进行分情况讨论：

若满足 max = min，此时目标节点 t 插入在哪个位置都满足条件，我们直接将其与 ans 关联即可；
若不满足 max = min，此时我们先对链表进行一次遍历，找到有序列表的结束点（结束点的定义为：当前节点值为最大值，下一节点值为最小值。即为有序链表分割位置的左端点），在根据「插入值 x 是否为新链表的最值」进行分情况讨论：
若满足 x >= maxx>=max 或 x <= minx<=min ，说明目标节点 t 插入分割位置即可；
若不满足上述两条件，需要从分割位置出发，找到目标插入位置，即满足 he.val <= x && x <= he.next.val 的位置。
*/
public class p029_insert {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            return head;
        }
        int min = head.val;
        int max = head.val;
        Node node = head;
        while (node.next != head) {
            node = node.next;
            min = Math.min(min, node.val);
            max = Math.max(max, node.val);
        }
        if (min == max) {
            newNode.next = head.next;
            head.next = newNode;
        } else {
            while (!(node.val == max && node.next.val == min)) {
                node = node.next;
            }
            while (!(insertVal >= max || insertVal <= min)
                    && !(node.val <= insertVal && node.next.val >= insertVal)) {
                node = node.next;
            }
            newNode.next = node.next;
            node.next = newNode;
        }
        return head;
    }
}
