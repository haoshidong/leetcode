package test;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        String s = in.next();
        in.nextLine();
        String s1 = in.nextLine();
        System.out.println(i);
        System.out.println(s);
        System.out.println(s1);
        System.out.println("Hello World!");
//        a test = new a();

    }
    public static int[] charu(int[] nums,int i){
        if(i < nums.length){
            int pre = i-1;
            while(pre >= 0 && nums[i] < nums[pre]){
                pre--;
            }
            if (pre != i+1){
                int temp = nums[i];
                int a = i;
                int b = i-1;
                while(b > pre){
                    nums[a] = nums[b];
                    a--;
                    b--;
                }
                nums[++pre] = temp;
            }
            charu(nums, i+1);
        }
        return nums;

    }
}
