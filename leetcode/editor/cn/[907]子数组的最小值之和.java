/**
给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。 

 由于答案可能很大，因此 返回答案模 10^9 + 7 。 

 

 示例 1： 

 
输入：arr = [3,1,2,4]
输出：17
解释：
子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 

 示例 2： 

 
输入：arr = [11,81,94,43,3]
输出：444
 

 

 提示： 

 
 1 <= arr.length <= 3 * 10⁴ 
 1 <= arr[i] <= 3 * 10⁴ 
 

 

 Related Topics 栈 数组 动态规划 单调栈 👍 476 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return 0;
        }
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> monoStack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!monoStack.isEmpty() && arr[monoStack.peek()] > arr[i]) {
                monoStack.pop();
            }
            if (monoStack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = monoStack.peek();
            }
            monoStack.push(i);
        }
        monoStack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!monoStack.isEmpty() && arr[monoStack.peek()] >= arr[i]) {
                monoStack.pop();
            }
            if (monoStack.isEmpty()) {
                right[i] = len;
            } else {
                right[i] = monoStack.peek();
            }
            monoStack.push(i);
        }
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum = (sum + (long)(i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int)sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
