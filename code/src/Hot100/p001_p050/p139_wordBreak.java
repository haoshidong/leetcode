package Hot100.p001_p050;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class p139_wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                String subStr = s.substring(j,i+1);
                if (set.contains(subStr) && dp[j]){
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        boolean ans = new p139_wordBreak().wordBreak(s, wordDict);
        System.out.println(ans);
    }
}
