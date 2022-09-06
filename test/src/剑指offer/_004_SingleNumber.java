package 剑指offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _004_SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int result = -1;
        for (int i=0;i<n;i++){
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 3);
                continue;
            }
            map.put(nums[i],map.get(nums[i])-1);
        }
        for (int i:map.keySet()){
            if (map.get(i)==3){
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        int result = new _004_SingleNumber().singleNumber(nums);
        System.out.println(result);
    }

}
