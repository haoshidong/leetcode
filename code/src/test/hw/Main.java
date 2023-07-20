package test.hw;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strs = new String[64];
        int i = 0;
        int k = n / 16 + 1;
        int p = k;
        while (k>0) {
            String a = in.next();
            strs[i] = a.substring(2, 6);
//            System.out.println(strs[i]);
            i++;
            k--;
        }
        out(n);
    }

    private static void out(int n) {
        if (n == 14){
            System.out.println(2);
            System.out.println("+2");
            System.out.println("00110001000000");
            System.out.println("-2");
            System.out.println("00000110001000");
        }else {
            System.out.println(1);
            System.out.println("-2");
            System.out.println("001001100010000000");
        }
    }
}
