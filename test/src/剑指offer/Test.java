package 剑指offer;

public class Test {
    public static void main(String[] args) {
        String x = "";
        System.out.println(x=="");
    }

    public int[] sortArray(int[] nums) {
        int length = nums.length;
        int[] src = nums;
        int[] dst = new int[length];
        for (int seg = 1; seg < length; seg += seg) {
            for (int start = 0; start < length; start += seg * 2) {
                int mid = Math.min(start + seg, length);
                int end = Math.min(start + seg * 2, length);
                int i = start, j = mid, k = start;
                while (i < mid || j < end){
                    if (j==end || (i<mid && src[i]<src[j])){
                        dst[k++] = src[i++];
                    }else {
                        dst[k++] = src[j++];
                    }
                }
            }
            int[] tmp = src;
            src = dst;
            dst = src;
        }
        return src;
    }

}
