package 剑指offer.p051_p100;

import java.util.Random;

public class p071_Solution {
    private int[] sums;
    private int total;

    public p071_Solution(int[] w) {
        sums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sums[i] = total;
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int p = random.nextInt(total) + 1;
        int left = 0;
        int right = sums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (sums[mid] < p) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
