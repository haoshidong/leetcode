package Hot100.p051_p100;


import java.util.HashMap;
import java.util.Map;

public class p146_LRUCache {
    class ListNode {
        public int key;
        public int value;
        public ListNode next;
        public ListNode prev;

        public ListNode(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    private ListNode head;
    private ListNode tail;
    private Map<Integer, ListNode> map;
    int capacity;


    public p146_LRUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();

        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode ndoe = map.get(key);
        if (ndoe == null) {
            return -1;
        }
        moveToTail(ndoe, ndoe.value);
        return ndoe.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            moveToTail(map.get(key), value);
        } else {
            if (capacity == map.size()) {
                ListNode toBeDelete = head.next;
                deleteNode(toBeDelete);

                map.remove(toBeDelete.key);
            }
            ListNode node = new ListNode(key, value);
            insertToTail(node);

            map.put(key, node);
        }
    }

    private void moveToTail(ListNode node, int newValue) {
        deleteNode(node);

        node.value = newValue;
        insertToTail(node);
    }

    private void insertToTail(ListNode node) {
        tail.prev.next = node;
        node.prev = tail.next;
        node.next = tail;
        tail.prev = node;
    }

    private void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
