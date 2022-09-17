package 剑指offer;

/*字符串中只有小写英文字母*/
public class p032_isAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)){
            return false;
        }
        int[] charToCount = new int[26];
        for (char ch:s.toCharArray()){
            charToCount[ch-'a']++;
        }
        for (char ch:t.toCharArray()){
            charToCount[ch-'a']--;
        }
        int sum = 0;
        for (int x:charToCount ){
            sum += x;
        }
        return sum==0 ? true : false;
    }
}
