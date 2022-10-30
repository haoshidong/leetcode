package Hot100.p001_p050;

public class p11_maxArea {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            max = Math.max(max, h * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else j--;
        }
        return max;
    }
}
