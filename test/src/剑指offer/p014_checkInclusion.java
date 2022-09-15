package 剑指offer;

public class p014_checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length()<s1.length()){
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i)-'a']++;
            counts[s2.charAt(i)-'a']--;
        }
        if (areAllZero(counts)){
            return true;
        }
        for (int right = s1.length(); right <  s2.length(); right++) {  //滑动窗口
            counts[s2.charAt(right)-'a']--;
            counts[s2.charAt(right-s1.length())-'a']++;
            if (areAllZero(counts)){
                return true;
            }
        }
        return false;
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
