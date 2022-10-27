package 剑指offer.p051_p100;

public class p073_minEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        int ans = -1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (getHour(mid, piles) > h) {//吃慢了
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }

    private int getHour(int speed, int[] piles) {
        int hour = 0;
        for (int pile : piles) {
            hour += (pile - 1) / speed + 1;
        }
        return hour;
    }
}
