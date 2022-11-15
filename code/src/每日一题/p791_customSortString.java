package 每日一题;

public class p791_customSortString {
    public String customSortString(String order, String s) {
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) {
            while (counts[ch - 'a'] != 0) {
                sb.append(ch);
                counts[ch - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (counts[i] != 0) {
                sb.append((char) ('a' + i));
                counts[i]--;
            }
        }
        return sb.toString();
    }
}
