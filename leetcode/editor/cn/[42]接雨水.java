/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 10⁴
 * 0 <= height[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3913 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
    }
}
//leetcode submit region end(Prohibit modification and deletion)
