package 每日一题;

public class p1769_minOperations {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        char[] chars = boxes.toCharArray();
        int rc = 0;
        int lc = chars[0] == '1' ? 1 : 0;
        int ans[] = new int[n];
        for (int i = 1; i < n; i++) {
            if (chars[i] == '1') {
                ans[0] += i;
                rc++;
            }
        }
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + lc - rc;
            if (chars[i] == '1') {
                lc++;
                rc--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String boxes = "001011";
        int[] ans = new p1769_minOperations().minOperations(boxes);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }
}
