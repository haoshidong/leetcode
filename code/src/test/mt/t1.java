package test.mt;

import java.util.Scanner;

public class t1 {
    public static int minChange(String s){
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1)==s.charAt(i)){
                ans++;
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.next();
            System.out.println(minChange(s));
        }
    }
}
