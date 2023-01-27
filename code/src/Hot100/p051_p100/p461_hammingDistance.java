package Hot100.p051_p100;

public class p461_hammingDistance {
    public int hammingDistance(int x, int y) {
        int hanming = x ^ y;
        int ans = 0;
        while (hanming != 0) {
            ans += hanming % 2;
            hanming = hanming >> 1;
        }
        return ans;
    }
}
