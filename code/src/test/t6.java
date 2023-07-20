package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class t6 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word : wordDict){
            set.add(word);
        }
        boolean[] dp = new boolean[s.length() + 1];
        for(int i = 0; i < s.length(); i++){
            for(int j = i-1; j >= 0; j--){
                if(set.contains(s.substring(j, i)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
