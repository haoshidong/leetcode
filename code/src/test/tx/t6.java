package test.tx;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class t6 {

    static int[][] ans;


    public static void main(String[] args) {
        int[][] nums = new int[9][9];
        int[][] ans = tianchong(nums);
    }

    private static int[][] tianchong(int[][] nums) {

        fills(nums, 0);



        return null;
    }

    private static void fills(int[][] nums, int row) {
        if (row < 9) {
            Set<Integer> set = acquireSet(nums, row);
            //lists存放3*3可以填充的所有排列
            LinkedList<LinkedList<Integer>> lists = pailie(set);
            for (List<Integer> list : lists) {
                //取出一种排列
                for (int num : list) {
                    //对window进行填充
                    for (int j = 0; j < 9; j++) {
                        if (nums[row][j] == 0) {
                            nums[row][j] = num;
                        }
                    }
                    fills(nums, row + 1);
                }
            }
        }else {
            //检查是否符合
            int[] checks = new int[9];
            //按列检查
            int check = 9;
            boolean flag = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    checks[nums[j][i]]++;
                }
                for (int j = 0; j < 9; j++) {
                    if (checks[0]==2){
                        flag = false;
                    }
                }
            }
            if (flag){
                ans = nums;
            }
            //3*3检查

        }
    }

    private static Set<Integer> acquireSet(int[][] nums, int row) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 9; i++) {
            set.add(i);
        }
        for (int j = 0; j < 9; j++) {
            if (nums[row][j] != 0) {
                set.remove(nums[row][j]);
            }
        }
        return set;
    }

    private static LinkedList<LinkedList<Integer>> pailie(Set<Integer> set) {
        int[] nums = new int[set.size()];
        int i = 0;
        for (int num : set) {
            nums[i++] = num;
        }
        LinkedList<LinkedList<Integer>> ans = new LinkedList<>();
        helper(nums, ans, 0, 0);
        return ans;
    }

    private static void helper(int[] nums, LinkedList<LinkedList<Integer>> ans, int i, int path) {
        if (path == nums.length) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int num : nums) {
                list.add(num);
            }
            ans.add(list);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                helper(nums, ans, i + 1, path + 1);
                swap(nums, i, j);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
