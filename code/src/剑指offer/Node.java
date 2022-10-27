package 剑指offer;

/**28题中数据结构*/
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public int key;

    public Node() {
    }

    public Node(int val, int key) {
        this.val = val;
        this.key = key;
    }

    public Node(int insertVal) {
        this.val = insertVal;
    }
}
