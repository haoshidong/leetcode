package 剑指offer.p001_p050;

/*字符串中只有小写英文字母*/
public class p032_isAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return false;
        }
        int[] charToCount = new int[26];
        for (char ch : s.toCharArray()) {
            charToCount[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            charToCount[ch - 'a']--;
        }
        for (int x : charToCount) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
}
