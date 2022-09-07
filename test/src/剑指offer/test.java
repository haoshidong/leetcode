/*
package 剑指offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test {

    public int ssingleNumber(int[] nums) {
        int[] cnt = new int[32];
        int result = 0;
        for (int s:nums){
            for (int i=0;i<32;i++){
                if (((s>>i)&1)==1){
                    cnt[i] += 1;
                }
            }
        }
        for (int i=0;i<32;i++){
            if (cnt[i]%3==1){
                result += 1>>i;
            }
        }
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
*/
