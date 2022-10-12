/**
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 

 

 示例 1: 

 
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
] 

 示例 2: 

 
输入: n = 1, k = 1
输出: [[1]] 

 

 提示: 

 
 1 <= n <= 20 
 1 <= k <= n 
 

 

 
 注意：本题与主站 77 题相同： https://leetcode-cn.com/problems/combinations/ 

 Related Topics 数组 回溯 👍 33 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
//        LinkedList<Integer> combination = new LinkedList<>();
        helper(n, 1, k, new LinkedList<>(), res);
        return res;
    }

    private void helper(int n,int i, int k, LinkedList<Integer> combination, List<List<Integer>> res) {
        if (combination.size() == k) {
            res.add(new LinkedList<>(combination));
        } else if (i<=n){
            helper(n,i+1,k,combination,res);

            combination.add(i);
            helper(n,i+1,k,combination,res);
            combination.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
