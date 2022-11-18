package Hot100.p051_p100;

import java.util.*;

public class p239_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //双端队列 存取单调递减的数
        Deque<Integer> monoQ = new ArrayDeque<>();
        //先存取k-1个数
        for (int i = 0; i < k - 1; i++) {
            //当前数大于队尾元素，出队列
            while (!monoQ.isEmpty() && nums[i] > monoQ.peekLast()) {
                monoQ.pollLast();
            }
            //当前数入队
            monoQ.offer(nums[i]);
        }
        int[] ans = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            while (!monoQ.isEmpty() && nums[i] > monoQ.getLast()) {
                monoQ.pollLast();
            }
            monoQ.offer(nums[i]);
            //ans的下标
            int index = i - k + 1;
            //存取当前窗口的最大数，最大数在队列头
            ans[index] = monoQ.peek();
            //移除窗口最左端元素，若队列头等于窗口最左端元素，则移除队列头；
            //            ！！！若不等于，则表示窗口最左端元素不在队列中。
            if (monoQ.peek() == nums[index]) {
                monoQ.poll();
            }
        }
        return ans;

        /*//最大堆  超时
        Queue<Integer> maxHead = new PriorityQueue<>((a, b) -> b - a);
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k - 1; i++) {
            maxHead.offer(nums[i]);
        }
        for (int i = 0; i < ans.length; i++) {
            maxHead.offer(nums[i + k - 1]);
            ans[i] = maxHead.peek();
            maxHead.remove(nums[i]);
        }
        return ans;*/
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        int[] ans = new p239_maxSlidingWindow().maxSlidingWindow(nums,k);
        for (int a : ans) {
            System.out.print(a+" ");
        }
    }
}
