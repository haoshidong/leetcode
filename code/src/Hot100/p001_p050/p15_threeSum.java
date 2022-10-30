package Hot100.p001_p050;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class p15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //定义一个结果集
        List<List<Integer>> res = new LinkedList<>();
        int len = nums.length;
        //当前数组的长度为空，或者长度小于3，直接退出
        if (nums == null || len < 3) return res;
        Arrays.sort(nums);
        //遍历数组中的每一个元素
        for (int i = 0; i < len; i++) {
            //若遍历的起始元素大于0，直接退出
            if (nums[0] > 0) break;
            //去重，若当前遍历元素等于前一个元素，跳过这次循环
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;  //不能从下标0开始，不然结果会重复。
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;    //去重
                    while (l < r && nums[r] == nums[r - 1]) r--;    //去重
                    l++;    //继续搜索下一组满足答案的值
                    r--;    //继续搜索下一组满足答案的值
                } else if (sum < 0) l++;    //sum太小，将l值增大
                else r--;   //sum值太大，将r值减小
            }
        }
        return res;
    }
}
