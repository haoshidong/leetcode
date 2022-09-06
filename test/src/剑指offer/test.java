package 剑指offer;

import java.util.Arrays;
import java.util.Scanner;

public class test {

    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i=0;i<=n;i++){
            int k = 0;
            int value = i;
            while (value>0){
                k += (value%2);
                value /= 2;
            }
            res[i] = k;
        }
        return res;
    }

    public static void main(String[] args) {

        int i = 9;
        int[] res = countBits(i);
        for (int a:res){
            System.out.println(a);
        }
        System.out.println(Arrays.toString(res));

//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入数字1：");
//        String a = sc.nextLine();
//        System.out.println("请输入数字12：");
//        StringBuilder b = new StringBuilder(sc.nextLine());
//        b.append(999);
//        System.out.println(b);
//        String result = test(a, String.valueOf(b));
//        System.out.println("商为："+result);
    }

}
