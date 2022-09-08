package test;

public class t1 {

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ret= new int[2];
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {

//        int i = 9;
//        int[] res = countBits(i);
//        for (int a:res){
//            System.out.println(a);
//        }
//        System.out.println(Arrays.toString(res));

//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入数字1：");
//        String a = sc.nextLine();
//        System.out.println("请输入数字12：");
//        StringBuilder b = new StringBuilder(sc.nextLine());
//        b.append(999);
//        System.out.println(b);
//        String result = test(a, String.valueOf(b));
//        System.out.println("商为："+result);
    }
}

