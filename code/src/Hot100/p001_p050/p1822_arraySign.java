package Hot100.p001_p050;

public class p1822_arraySign {
    public int arraySign(int[] nums) {
        int negative = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                negative++;
            }
        }
        return negative % 2 == 0 ? 1 : -1;
    }
}
