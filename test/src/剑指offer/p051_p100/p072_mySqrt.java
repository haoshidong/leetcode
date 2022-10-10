package 剑指offer.p051_p100;

public class p072_mySqrt {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
//            if ((long)mid * mid <= x && (long)((mid + 1) * (mid + 1)) > x) {
//                ans = mid;
//            }
            if ((long)mid * mid > x) {
                right = mid-1;
            } else {
                ans = mid;
                left = mid+1;
            }
        }
        return ans;
    }
}
