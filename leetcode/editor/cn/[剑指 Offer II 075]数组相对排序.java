/**
 * 给定两个数组，arr1 和 arr2，
 * <p>
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * <p>
 * <p>
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 1122 题相同：https://leetcode-cn.com/problems/relative-sort-array/
 * <p>
 * Related Topics 数组 哈希表 计数排序 排序 👍 37 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for (int num : arr1) {
            counts[num]++;
        }
        int i = 0;
        for (int sort : arr2) {
            while (counts[sort] != 0) {
                arr1[i++] = sort;
                counts[sort]--;
            }
        }
        for (int j = 0; j < counts.length; j++) {
            while (counts[j] != 0) {
                arr1[i++] = j;
                counts[j]--;
            }
        }
        return arr1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
