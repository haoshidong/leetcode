package 每日一题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p481_magicalString {
    public int magicalString(int n) {
        char[] magic = new char[n + 2];
        magic[0] = 1;
        magic[1] = magic[2] = 2;
        char c = 2;
        for (int i = 2, j = 3; j < n; i++) {    //i为组号，j为待添加值的第一个下标
            c ^= 3;     //2^3=1,1^3=2
            magic[j++] = c;
            if (magic[i] == 2) magic[j++] = c;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += 2 - magic[i];  //若magic[i]为2，count不变，若magic[i]为1，count值加1。
        }
        return count;
    }
}
