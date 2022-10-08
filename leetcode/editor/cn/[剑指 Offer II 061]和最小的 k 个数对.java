/**
给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。 

 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 

 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 

 

 示例 1: 

 
输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
输出: [1,2],[1,4],[1,6]
解释: 返回序列中的前 3 对数：
    [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 

 示例 2: 

 
输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
输出: [1,1],[1,1]
解释: 返回序列中的前 2 对数：
     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 

 示例 3: 

 
输入: nums1 = [1,2], nums2 = [3], k = 3 
输出: [1,3],[2,3]
解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 

 

 提示: 

 
 1 <= nums1.length, nums2.length <= 10⁴ 
 -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
 nums1, nums2 均为升序排列 
 1 <= k <= 1000 
 

 

 
 注意：本题与主站 373 题相同：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-
sums/ 

 Related Topics 数组 堆（优先队列） 👍 49 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> maxHead = new PriorityQueue<>((e1, e2) -> (e2[0] + e2[1]) - (e1[0] + e1[1]));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if (maxHead.size() < k) {
                    maxHead.offer(new int[]{nums1[i], nums2[j]});
                } else {
                    if ((nums1[i] + nums2[j]) < maxHead.peek()[0] + maxHead.peek()[1]) {
                        maxHead.poll();
                        maxHead.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        for (int[] s : maxHead) {
            /*List<Integer> list = new LinkedList<>();
            list.add(s[0]);
            list.add(s[1]);*/
            res.add(Arrays.asList(s[0], s[1]));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
