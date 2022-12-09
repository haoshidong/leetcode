package 力扣周赛;

public class p6245_pivotInteger {
    public int pivotInteger(int n) {
        int i = 1, j = n;
        int l = i, r = j;
        int ans = i;
        while (i < j) {
            if (l < r) {
                i++;
                l += i;
                ans = i;
            } else {
                j--;
                r += j;
                ans = j;
            }
        }
        if (l == r){
            return ans;
        }
        return -1;
    }

    public static void main(String[] args) {
        int ans = new p6245_pivotInteger().pivotInteger(8);
        System.out.println(ans);
    }
}
