package 剑指offer.p001_p050;

import java.util.Scanner;

public class p001_divide {

    public static int divide(int dividend,int divisor){
        if (dividend == 0x80000000 && divisor == -1 ){
            return Integer.MAX_VALUE;
        }

        int negative = 2;
        if (dividend > 0){
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0){
            negative--;
            divisor = -divisor;
        }

        int result = divideCore(dividend, divisor);
        return negative==1?-result:result;

    }

    private static int divideCore(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor){
            int quotient = 1;
            int value = divisor;
            while (value < 0xc0000000 && dividend <= value + value){
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入被除数：");
        int dividend = sc.nextInt();
        System.out.println("请输入除数：");
        int divisor = sc.nextInt();
        int result = divide(dividend, divisor);
        System.out.println("商为："+result);
    }

}
