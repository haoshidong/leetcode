package 每日一题;

public class p1832_checkIfPangram {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }
        int[] a = new int[26];
        int ct = 0;
        for (char ch : sentence.toCharArray()) {
            if (a[ch - 'a'] == 0) {
                ct++;
                if (ct == 26) {
                    return true;
                }
                a[ch - 'a']++;
            }
        }
        return false;
    }
}
