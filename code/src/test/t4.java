package test;

import java.util.Scanner;

public class t4 {
    public int[] peopleToDest(char[] counts, char[] peoples) {
        int[] ans = new int[peoples.length];
        for (int i = 0; i < peoples.length; i++) {
            char people = peoples[i];
            int desk = -1;
            boolean flag = true;
            //男生
            if ('M'==people) {
                for (int j = 0; j < counts.length; j++) {
                    if ('0' == counts[j] && flag) {
                        desk = j;
                        flag = false;
                    } else if ('1' == counts[j]) {
                        desk = j;
                        break;
                    }
                }
            } else { //女生
                for (int j = 0; j < counts.length; j++) {
                    if ("1".equals(counts[j]) && flag) {
                        desk = j;
                        flag = false;
                    } else if ("0".equals(counts[j])) {
                        desk = j;
                        break;
                    }
                }
            }
            counts[desk] = "0".equals(counts[desk]) ? '1' : '2';
            ans[i] = desk + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            // int T = in.nextInt();
            int N = in.nextInt();
            String counts = in.next();

            int M = in.nextInt();
            String peoples = in.next();

            int[] ans = new t4().peopleToDest(counts.toCharArray(), peoples.toCharArray());
            for (int num : ans) {
                System.out.println(num);
            }
        }
    }
}
