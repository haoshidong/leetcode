package 剑指offer;

public class p034_isAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArray = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            orderArray[order.charAt(i)-'a'] = i;
        }
        for (int i = 0; i < words.length-1; i++) {
            if(!isSorted(words[i],words[i+1],orderArray)){
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(String word1, String word2, int[] orderArray) {
        int length = Math.max(word1.length(),word2.length());
        for (int i = 0; i < length; i++) {
            int s1 = i<word1.length() ? orderArray[word1.charAt(i)-'a'] : -1;
            int s2 = i<word2.length() ? orderArray[word2.charAt(i)-'a'] : -1;
            if (s1<s2){
                return true;
            }else if (s1>s2){
                return false;
            }
        }
        return true;
    }
}
