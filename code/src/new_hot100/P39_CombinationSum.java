package new_hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P39_CombinationSum {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, candidates, target, 0, new ArrayList<Integer>(), 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int target, int pathSum, List<Integer> path, int index) {
        if(pathSum == target) {
            res.add(List.copyOf(path));
        } else if(pathSum < target) {
            for(int i = index ; i < candidates.length; i++) {
                int num = candidates[i];
                path.add(num);
                pathSum += num;
                dfs(res, candidates, target, pathSum, path, i);
                path.remove(path.size() - 1);
                pathSum -= num;
            }
        }
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P39_CombinationSum().new Solution(); 
    }
}