package 每日一题;

public class p1668_maxRepeating {
    public int maxRepeating(String sequence, String word) {
        int maxLen = 0;
        int n = word.length();
        //动态规划
        int[] dp = new int[sequence.length() + 1];
        int i = n;
        while (i <= sequence.length()) {
            int index = i - 1;  //dp[i]对应的sequence下标
            int j = n - 1;  //word最后字母的下标，从后往前匹配sequence
            //若sequence当前下标[i-n,i-1]与word相等，则j值为-1；
            while (j >= 0) {
                if (word.charAt(j) == sequence.charAt(index)) index--;
                else break;
                j--;
            }
            //状态转移方程
            if (j==-1) dp[i] = dp[i - n] + 1;
            //计算dp[i+1]
            i++;
        }
        //遍历dp数组的最大值
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word = "aaaba";
        int maxLen = new p1668_maxRepeating().maxRepeating(sequence, word);
        System.out.println(maxLen);
    }
}
