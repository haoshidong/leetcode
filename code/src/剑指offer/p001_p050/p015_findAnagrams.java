package 剑指offer.p001_p050;

import java.util.ArrayList;
import java.util.List;

public class p015_findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length()<p.length()){
            return result;
        }
        int[] counts = new int[26];
        for (int i = 0; i < p.length(); i++) {
            counts[p.charAt(i)-'a']++;
            counts[s.charAt(i)-'a']--;
        }
        if (areAllZero(counts)){
            result.add(0);
        }
        for (int right = p.length(); right < s.length(); right++) {
            counts[s.charAt(right)-'a']--;
            counts[s.charAt(right-p.length())-'a']++;
            if (areAllZero(counts)){
                result.add(right-p.length()+1);
            }
        }
        return result;
    }
    private boolean areAllZero(int[] counts){
        for (int count:counts){
            if (count!=0){
                return false;
            }
        }
        return true;
    }
}
