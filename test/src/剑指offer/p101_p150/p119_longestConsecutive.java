package 剑指offer.p101_p150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p119_longestConsecutive {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> fathers = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        Set<Integer> all = new HashSet<>();
        //初始化图和集合
        for (int num : nums) {
            fathers.put(num, num);
            counts.put(num, 1);
            all.add(num);
        }
        //更新fathers图和counts图
        for (int num : nums) {
            if (all.contains(num + 1)) {
                union(fathers, num, num + 1, counts);
            }
            if (all.contains(num - 1)) {
                union(fathers, num, num - 1, counts);
            }
        }

        int maxLen = 0;
        for (int length : counts.values()) {
            maxLen = Math.max(maxLen, length);
        }
        return maxLen;
    }

    private void union(Map<Integer, Integer> fathers, int i, int j, Map<Integer, Integer> counts) {
        int fatherOfi = findFather(fathers, i);
        int fatherOfj = findFather(fathers, j);
        if (fatherOfi != fatherOfj) {
            //合并子图
            fathers.put(fatherOfi, fatherOfj);
            //更新根节点所在子图的节点数量
            int countOfi = counts.get(fatherOfi);
            int countOfj = counts.get(fatherOfj);
            counts.put(fatherOfj, countOfi + countOfj);
        }
    }

    private int findFather(Map<Integer, Integer> fathers, int i) {
        if (fathers.get(i) != i) {
            fathers.put(i, findFather(fathers, fathers.get(i)));
        }
        return fathers.get(i);
    }
}
