package 每日一题;

public class p1732_largestAltitude {
    public int largestAltitude(int[] gain) {
        int h = 0;
        int ans = 0;
        for (int g : gain) {
            h += g;
            ans = Math.max(ans, h);
        }
        return ans;
    }
}
