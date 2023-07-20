package test.sort;

public class InsertSort{
    public int[] insertSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int temp = nums[i];
            int j = i - 1;
            for(; j >= 0; j--){
                if(nums[j] > temp){
                    nums[j+1] = nums[j];
                }else {
                    break;
                }
            }
            nums[j+1] = temp;
        }
        return nums;
    }

    public static void main(String[] args){
        int[] nums = {8, 5, 19, 4, 1};
        InsertSort test = new InsertSort();
        int[] res = test.insertSort(nums);
        for(int num : res){
            System.out.print(num + " ");
        }
    }
}
