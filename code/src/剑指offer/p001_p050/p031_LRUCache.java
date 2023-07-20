package 剑指offer.p001_p050;

import java.util.HashMap;

public class p031_LRUCache {

    public class Node {
        public int val;
        public Node prev;
        public Node next;
        public int key;

        public Node() {
        }

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }

        public Node(int insertVal) {
            this.val = insertVal;
        }
    }

    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;
    int capacity;

    public p031_LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();

        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node location = map.get(key);
            moveToTail(location, location.val);
            return location.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            moveToTail(map.get(key), value);
        } else {
            if (map.size() == capacity) {
                Node toBeDelete = head.next;
                delete(toBeDelete);
                map.remove(toBeDelete.key);
            }
            Node newNode = new Node(key, value);
            insetToTail(newNode);
            map.put(key, tail.prev);
        }
    }

    private void moveToTail(Node location, int val) {
        delete(location);
        location.val = val;
        insetToTail(location);
    }

    private void insetToTail(Node location) {
        tail.prev.next = location;
        location.prev = tail.prev;
        location.next = tail;
        tail.prev = location;
    }

    private void delete(Node location) {
        location.prev.next = location.next;
        location.next.prev = location.prev;
    }

}
