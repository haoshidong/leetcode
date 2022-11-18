package Hot100.p051_p100;

import java.util.concurrent.ForkJoinPool;

public class p238_productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int l = 1, r = 1;
        //计算下三角的积
        for (int i = 0; i < nums.length; i++) {
            ans[i] = l;
            l *= nums[i];
        }
        //计算上三角的积
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= r;
            r *= nums[i];
        }
        return ans;

        /*//超时
        int zero_count = 0,zero_index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                zero_count++;
                zero_index = i;
            }
        }
        int[] ans = new int[nums.length];
        if (zero_count>0){
            if (zero_count==1){
                int product = 1;
                for (int i = 0; i < nums.length; i++) {
                    if (i==zero_index) continue;
                    product *= nums[i];
                }
                ans[zero_index] = product;
            }
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j==i) continue;
                product *= nums[j];
            }
            ans[i] = product;
        }
        return ans;*/
    }
}
