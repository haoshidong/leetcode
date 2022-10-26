package 剑指offer.p101_p150;

import java.util.*;

public class p115_sequenceReconstruction {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        Map<Integer, Integer> inDegrees = new HashMap<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] sequence : sequences) {
            for (int num : sequence) {
                graph.putIfAbsent(num,new HashSet<>());
                inDegrees.putIfAbsent(num, 0);
            }
        }
        //长度不同，直接返回false
        if (inDegrees.size()!=nums.length){
            return false;
        }
        //初始化 图和入度表
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                int num1 = sequence[i - 1];
                int num2 = sequence[i];
                if (!graph.get(num1).contains(num2)) {
                    graph.get(num1).add(num2);

                    inDegrees.put(num2, inDegrees.get(num2) + 1);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        //初始化队列 存取入度为0的值
        for (int num : inDegrees.keySet()) {
            if (inDegrees.get(num)==0){
                queue.offer(num);
            }
        }
        //创建重建队列
        List<Integer> out = new LinkedList<>();
        //对重建队列赋值并判断
        int i = 0;
        while (!queue.isEmpty()){
            //队列中每次只能有一个入度为0的节点，不然重建序列不唯一
            if(queue.size()!=1){
                return false;
            }
            int num = queue.poll();
            if (nums[i]!=num){
                return false;
            }
            for (int next : graph.get(num)) {
                inDegrees.put(next,inDegrees.get(next)-1);
                if (inDegrees.get(next)==0){
                    queue.offer(next);
                }
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[][] sequences = {{1,2},{1,3}};
        boolean res = new p115_sequenceReconstruction().sequenceReconstruction(nums,sequences);
        System.out.println(res);
    }

}
