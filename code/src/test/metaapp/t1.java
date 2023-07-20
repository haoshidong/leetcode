package test.metaapp;

import java.util.ArrayList;

public class t1 {
    public static void main(String[] args) {
        int num = sulotion1(new int[]{3, 6, 9, 1, 2, 6});
        int[] nums = solution2(num);
        for (int a : nums) {
            System.out.println(a);
        }
    }
//    public static int answer(int[] x) {
//        int num = sulotion1(x);
//        int[] nums = solution2(num);
//        return nums;
//    }

    public static int sulotion1(int[] nums){
        int len = nums.length;
        if(len < 1){
            return 0;
        }
        int[] flag = new int[len];
        int ct = len;
        int i = 0;
        int k = 0;
        while(ct > 1){
            if( i == len){
                i = 0;
            }
            for(; i < len; i++){
                if(flag[i] == 0){
                    k++;
                    if(k == 3){
                        flag[i] = 1;
                        k = 0;
                        ct--;
                    }
                }
            }
        }
        for(int j = 0; j< len; j++){
            if(flag[j] == 0){
                return nums[j];
            }
        }
        return 0;
    }

    public static int[] solution2(int num){
        ArrayList<Integer> list = new ArrayList<>();
        while(num > 0){
            int a = num % 10;
            num = num / 10;
            list.add(a);
        }
        int len = list.size() * 8;
        int l = list.size();
        int[] ans = new int[len];
        for(int i = 0; i < len; i++){
            ans[i] = list.get(l- (i % l) - 1);
        }
        return ans;
    }

    public static int solution3(int[] nums){
        int len = nums.length;
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < len;) {
            int[] temp = new int[]{-1,-1};
            temp[0] = nums[i];
            while (i < len){
                i++;
                if (nums[i] > temp[1]){
                    temp[1] = nums[i];
                }else if (nums[i] < temp[0] && temp[1] == -1){
                    temp[0] = nums[i];
                }else if (nums[i] < temp[1]){
                    break;
                }
            }
        }
        int ans = 0;
        for (int[] a : list) {
            int lirun = a[1] - a[0] - 5;
            if (lirun > 0){
                ans += lirun;
            }
        }
        return ans;
    }
}
