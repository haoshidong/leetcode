package 剑指offer.p001_p050;

public class p006_twoSum {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while (numbers[i]+numbers[j] != target){
            if (numbers[i]+numbers[j]<target){
                i++;
            } else if (numbers[i]+numbers[j]>target) {
                j--;
            }
        }
        return new int[]{i,j};
    }

}
