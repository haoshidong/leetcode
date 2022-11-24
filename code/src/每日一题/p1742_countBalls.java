package 每日一题;

import java.util.HashMap;

public class p1742_countBalls {
    public int countBalls(int lowLimit, int highLimit) {
        //找规律
        //highLimit最大值为99999，对应45，数组长度取46
        int[] resultMap = new int[46];
        int firstIndex = 0, ans = 0;
        //lowLimit所在的盒子位置
        for (int i = lowLimit; i > 0; i /= 10) {
            firstIndex += i % 10;
        }
        //初始化lowLimit所在盒子的球数量
        resultMap[firstIndex]++;
        for (int i = lowLimit; i < highLimit; i++) {
            //若当前i的低位数有9，则更新i+1所在盒子firstIndex的初始位置
            for (int j = i; j % 10 == 9; j /= 10) {
                firstIndex -= 9;
            }
            resultMap[++firstIndex]++;
        }
        //遍历盒子所放球的最大值
        for (int count : resultMap) {
            ans = Math.max(ans, count);
        }
        return ans;

        /*HashMap<Integer, Integer> sumToCount = new HashMap<>();
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int key = 0;
            int cur = i;
            while (cur > 0) {
                key += cur % 10;
                cur /= 10;
            }
            sumToCount.put(key, sumToCount.getOrDefault(key, 0) + 1);
            max = Math.max(max, sumToCount.get(key));
        }
        return max;*/
    }
}
