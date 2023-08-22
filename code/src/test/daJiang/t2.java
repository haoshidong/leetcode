package test.daJiang;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String instructions = in.next();

        int[] res = new Solution2().calculateFinalPositi(instructions);
        System.out.println(res[0] + " " + res[1]);
    }
}

class Solution2 {

    /* Write Code Here */
    public int[] calculateFinalPositi(String instructions) {
        Map<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{0, 1});  //上
        map.put('D', new int[]{0, -1}); //下
        map.put('L', new int[]{-1, 0}); //左
        map.put('R', new int[]{1, 0});  //右
        int[] res = {0, 0};
        char[] charArray = instructions.toCharArray();
        for (char ch : charArray) {
            ch = Character.toUpperCase(ch);
            int[] dir = map.get(ch);
            res[0] += dir[0];
            res[1] += dir[1];
        }
        return res;
    }
}
