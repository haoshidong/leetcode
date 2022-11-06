package Hot100.p001_p050;

import java.util.Random;

public class p42_trap {
    public int trap(int[] height) {
        /*
        假设一开始left-1大于right+1，则之后right会一直向左移动，直到right+1大于left-1。在这段时间内right所遍历的所有点都是左侧最高点maxleft大于右侧最高点maxright的，所以只需要根据原则判断maxright与当前高度的关系就行。反之left右移，所经过的点只要判断maxleft与当前高度的关系就行。
        ？？？？ 为什么 right_max 和 left 隔这么远我们还可以使用 right_max 来判断？
            前提：left_max < right_max
            right_max 虽然跟 left 离得远，但有如下两种情况：
            1、left 柱子和 right_max 柱子之间，没有比 right_max 柱子更高的柱子了，
            那么情况如下：  left 能否装水取决于 left_max 柱子是否比 left 高
                            |
                |           |
                |   |       |           left能走到这个位置，表示left左边的高度均小于right_max
                ↑   ↑       ↑
               l_m  l      r_m

            2、left 柱子和 right_max 柱子之间存在比 right_max 柱子更高的柱子
            那么情况如下：因为存在了比 right_max 更高的柱子，那么我们仍然只需要判断 left_max 是否比 left 高，因为右边已经存在比 left 高的柱子
                        |
                        |   |
                |       |   |
                |   |   |   |           left能走到这个位置，表示left左边的高度均小于right_max
                ↑   ↑   ↑   ↑
               l_m  l  mid  r_m

         */
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        //i用来计数，每个i可以求第left列or第right列的盛水量
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更，left列的左边<right列的右边，则可以确定left的最高墙的较矮值在left的左边。
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
            //从右到左更，right列的右边<=left列的左边，则可以确定right列的最高墙的较矮值在right的右边，
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;

        /*//动态规划
        int sum = 0;
        //max_left[i]表示下标 0 ~ i-1 的最高墙的高度
        int[] max_left = new int[height.length];
        //max_right[i]表示下标 i+1 ~ height.length-1 的最高墙的高度
        int[] max_right = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        //计算最大盛水量
        for (int i = 1; i < height.length - 1; i++) {
            //i两边最高墙的较矮值。
            int h = Math.min(max_left[i], max_right[i]);
            //若height[i]小于最矮值，则可盛水
            if (height[i] < h) sum += h - height[i];
        }
        return sum;*/

        /*//遍历每列
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            //当前列i左边最高墙的高度
            int max_left = 0;
            //计算左边最高墙
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) max_left = height[j];
            }
            //当前列i右边最高墙的高度
            int max_right = 0;
            //计算右边最高墙
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) max_right = height[j];
            }
            //两遍高墙相对较矮的墙为水面的高度
            int h = Math.min(max_left, max_right);
            //当前列的高度小于h，则可以盛水
            if (height[i] < h) sum += h - height[i];
        }
        return sum;*/
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int sum = new p42_trap().trap(height);
        System.out.println(sum);
    }
}
