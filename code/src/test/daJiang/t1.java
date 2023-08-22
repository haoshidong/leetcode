package test.daJiang;

import java.util.*;

public class t1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int selectedDigits_size = 0;
        selectedDigits_size = in.nextInt();
        int[] selectedDigits = new int[selectedDigits_size];
        for(int selectedDigits_i = 0; selectedDigits_i < selectedDigits_size; selectedDigits_i++) {
            selectedDigits[selectedDigits_i] = in.nextInt();
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        List<Integer> res = new Solution().ThreeDigitNumbers (selectedDigits);
        for(int num : res){
            System.out.print(num + " ");
        }
        Map<Character, int[]> map = new HashMap<>();
        map.put('R', new int[]{1, 0});

    }


}

class Solution {

    /* Write Code Here */
    public List<Integer> ThreeDigitNumbers (int[] selectedDigits) {
        List<Integer> res = new ArrayList<>();
        dfs(selectedDigits, res, new StringBuilder(), new HashSet<Integer>());
        return res;
    }

    public void dfs(int[] selectedDigits, List<Integer> res, StringBuilder path, Set<Integer> set){
        if(path.length() == 3){
            res.add(Integer.parseInt(path.toString()));
        }else if(path.length() < 3){
            for(int num : selectedDigits){

                if(!set.contains(num)){
                    set.add(num);
                    path.append(num);
                    dfs(selectedDigits, res, path, set);
                    set.remove(num);
                    path.deleteCharAt(path.length() - 1);
                }
            }
        }
    }

}
