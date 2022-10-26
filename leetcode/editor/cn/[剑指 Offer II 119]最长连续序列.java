/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 128 题相同： https://leetcode-cn.com/problems/longest-consecutive-
 * sequence/
 * <p>
 * Related Topics 并查集 数组 哈希表 👍 53 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> fathers = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        Set<Integer> all = new HashSet<>();
        //初始化图和集合
        for (int num : nums) {
            fathers.put(num, num);
            counts.put(num, 1);
            all.add(num);
        }
        //更新fathers图和counts图
        for (int num : nums) {
            if (all.contains(num + 1)) {
                union(fathers, num, num + 1, counts);
            }
            if (all.contains(num - 1)) {
                union(fathers, num, num - 1, counts);
            }
        }

        int maxLen = 0;
        for (int length : counts.values()) {
            maxLen = Math.max(maxLen, length);
        }
        return maxLen;
    }

    private void union(Map<Integer, Integer> fathers, int i, int j, Map<Integer, Integer> counts) {
        int fatherOfi = findFather(fathers, i);
        int fatherOfj = findFather(fathers, j);
        if (fatherOfi != fatherOfj) {
            //合并子图
            fathers.put(fatherOfi, fatherOfj);
            //更新根节点所在子图的节点数量
            int countOfi = counts.get(fatherOfi);
            int countOfj = counts.get(fatherOfj);
            counts.put(fatherOfj, countOfi + countOfj);
        }
    }

    private int findFather(Map<Integer, Integer> fathers, int i) {
        if (fathers.get(i) != i) {
            fathers.put(i, findFather(fathers, fathers.get(i)));
        }
        return fathers.get(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
