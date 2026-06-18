package new_hot100;

import java.util.Arrays;

class P42_TrappingRainWater {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] lmax = new int[len];
        int[] rmax = new int[len];
        lmax[0] = height[0];
        rmax[len - 1] = height[len-1];
        for (int i = 1; i < len; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = res + Math.min(lmax[i], rmax[i]) - height[i];
        }
        System.out.println(Arrays.toString(lmax));
        System.out.println(Arrays.toString(rmax));
        return res;
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P42_TrappingRainWater().new Solution();
        System.out.println(solution.trap(new int[]{4,2,0,3,2,5}));
    }
}