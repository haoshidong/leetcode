package 剑指offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _007_threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums.length>2) {
            Arrays.sort(nums);
            int i = 0;
            while (i<nums.length-2){        //不能用for循环，否则与18行的i++导致i增加2次。
                twoSum(nums, result, i);
                int temp = nums[i];
                while (i<nums.length && nums[i]==temp){
                    ++i;
                }
            }
        }
        return result;
    }

    public void twoSum(int[] nums, List<List<Integer>> result, int i) {
        int j = i+1;
        int k = nums.length-1;
        while (j<k){
            if (nums[i]+nums[j]+nums[k]<0){
                ++j;
            } else if (nums[i]+nums[j]+nums[k]>0) {
                --k;
            }else {
                result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                int temp = nums[j];
                while (nums[j]==temp && j<k){
                    j++;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = new _007_threeSum().threeSum(nums);
        for (List<Integer> list:result){
            System.out.println("");
            for (int x:list){
                System.out.print(x);
            }
        }
    }

}
