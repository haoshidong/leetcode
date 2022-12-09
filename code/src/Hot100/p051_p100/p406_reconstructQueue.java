package Hot100.p051_p100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p406_reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                //按第二个元素升序
                return p1[1] - p2[1];
            } else {
                //按第一个元素降序
                return p2[0] - p1[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            int[] p = people[i];
            //p待插入的位置下标为i，前面有i个元素
            //若高于等于p身高的人数大于i，则将p插入到ans中最后一个待插入的位置
            if (p[1] >= i) {
                ans.add(p);
            } else {
                //将p插入到指定位置，此位置前面恰有p[1]个人的身高大于等于p
                ans.add(p[1], p);
            }
        }
        return ans.toArray(new int[people.length][]);
    }
}
