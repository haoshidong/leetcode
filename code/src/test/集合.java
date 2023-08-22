package test;

import java.util.*;

public class 集合 {
    public static void main(String[] args) {
        //-------------List--------------
        List<String> list = new ArrayList<>();
        list.add("list");
        list.remove(0);
        list.get(0);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("linkedList");
        linkedList.addFirst("");
        linkedList.remove();
        linkedList.removeLast();
        linkedList.peek();
        //------------Set---------------
        Set<String> set = new HashSet<>();
        set.add("set");
        set.remove("set");
        //-------------Map--------------
        Map<String, String> map = new HashMap<>();
        map.put("map", "map");
        map.get("map");
        map.remove("map");
        //----------ArrayDeque-----------------
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add("queue");
        queue.remove();
        queue.poll();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        //-----------Stack----------------
        Stack<String> stack = new Stack<>();
        stack.push("stack");
        stack.pop();
        stack.peek();
    }
}
