package 剑指offer.p001_p050;

import java.util.LinkedList;
import java.util.Queue;

public class p042_RecentCounter {
    int windowSize;
    Queue<Integer> queue;
    public p042_RecentCounter() {
        queue = new LinkedList<>();
        windowSize = 3000;
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek()+3000>t){
            queue.poll();
        }
        return queue.size();
    }
}
