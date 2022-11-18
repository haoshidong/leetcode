/**
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 


 返回 滑动窗口中的最大值 。 

 

 示例 1： 

 
输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 

 示例 2： 

 
输入：nums = [1], k = 1
输出：[1]
 

 

 提示： 

 
 1 <= nums.length <= 10⁵ 
 -10⁴ <= nums[i] <= 10⁴ 
 1 <= k <= nums.length 
 

 Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1981 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //双端队列 存取单调递减的数
        Deque<Integer> monoQ = new ArrayDeque<>();
        //先存取k-1个数
        for (int i = 0; i < k - 1; i++) {
            //当前数大于队尾元素，出队列
            while (!monoQ.isEmpty() && nums[i] > monoQ.peekLast()) {
                monoQ.pollLast();
            }
            //当前数入队
            monoQ.offer(nums[i]);
        }
        int[] ans = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            while (!monoQ.isEmpty() && nums[i] > monoQ.getLast()) {
                monoQ.pollLast();
            }
            monoQ.offer(nums[i]);
            //ans的下标
            int index = i - k + 1;
            //存取当前窗口的最大数，最大数在队列头
            ans[index] = monoQ.peek();
            //移除窗口最左端元素，若队列头等于窗口最左端元素，则移除队列头；
            //            ！！！若不等于，则表示窗口最左端元素不在队列中。
            if (monoQ.peek() == nums[index]) {
                monoQ.poll();
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
