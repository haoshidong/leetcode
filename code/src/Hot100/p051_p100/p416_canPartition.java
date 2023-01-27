package Hot100.p051_p100;

public class p416_canPartition {
    public boolean canPartition(int[] nums) {
        /**
         * 「0 - 1」 背包问题的思路
         * 作为「0-1 背包问题」，它的特点是：「每个数只能用一次」。解决的基本思路是：物品一个一个选，容量也一点一点增加去考虑，这一点是「动态规划」的思想，特别重要。 在实际生活中，我们也是这样做的，一个一个地尝试把候选物品放入「背包」，通过比较得出一个物品要不要拿走。
         *
         * 具体做法是：画一个 len 行，target + 1 列的表格。这里 len 是物品的个数，target 是背包的容量。len 行表示一个一个物品考虑，target + 1多出来的那 1 列，表示背包容量从 0 开始考虑。很多时候，我们需要考虑这个容量为 0 的数值。
         */
        //动态规划
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        dp[nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j > nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
