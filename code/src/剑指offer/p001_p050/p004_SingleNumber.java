package 剑指offer.p001_p050;

public class p004_SingleNumber {

    public int singleNumber(int[] nums) {
        int[] cnt = new int[32];
        int result = 0;
        for (int s:nums){
            for (int i=0;i<32;i++){
                if (((s>>i)&1)==1){
                    cnt[i]++;
                }
            }
        }
        for (int i=0;i<32;i++){
            if (cnt[i]%3==1){
                result += (1<<i);
            }
        }
        return result;
        /*int n = nums.length;
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
        return result;*/
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        int result = new p004_SingleNumber().singleNumber(nums);
        System.out.println(result);
    }

}
