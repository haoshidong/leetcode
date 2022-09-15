package 剑指offer;

import java.util.Arrays;

public class p003_countBits {

    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i=0;i<=n;i++){
            res[i] = res[i>>1] + (i&1);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 9;  //测试数据
        int[] res = new p003_countBits().countBits(n);
        System.out.println(Arrays.toString(res));
    }

}
