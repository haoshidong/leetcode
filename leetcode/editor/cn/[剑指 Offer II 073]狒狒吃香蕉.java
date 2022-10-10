/**
狒狒喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。 

 狒狒可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一
小时内不会再吃更多的香蕉，下一个小时才会开始吃另一堆的香蕉。 

 狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。 

 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。 

 

 
 

 示例 1： 

 
输入：piles = [3,6,7,11], h = 8
输出：4
 

 示例 2： 

 
输入：piles = [30,11,23,4,20], h = 5
输出：30
 

 示例 3： 

 
输入：piles = [30,11,23,4,20], h = 6
输出：23
 

 

 提示： 

 
 1 <= piles.length <= 10⁴ 
 piles.length <= h <= 10⁹ 
 1 <= piles[i] <= 10⁹ 
 

 

 
 注意：本题与主站 875 题相同： https://leetcode-cn.com/problems/koko-eating-bananas/ 

 Related Topics 数组 二分查找 👍 42 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        int ans = -1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (getHour(mid, piles) > h) {//吃慢了
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }

    private int getHour(int speed, int[] piles) {
        int hour = 0;
        for (int pile : piles) {
            hour += (pile - 1) / speed + 1;
        }
        return hour;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
