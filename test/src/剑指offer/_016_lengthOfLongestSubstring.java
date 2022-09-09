package 剑指offer;

public class _016_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        int[] counts = new int[256];        //ASCⅡ表中有256个字符
        int length = 1;
        int left = -1;
        for (int right = 0;right<s.length();right++){
            counts[s.charAt(right)]++;
            if (counts[s.charAt(right)]==1){
                length = Math.max(length,right-left);
            }else {
                while (!areAllOne(counts)){
                    left++;
                    counts[s.charAt(left)]--;
                }
            }
        }
        return length;
    }

    private boolean areAllOne(int[] counts){
        for (int count:counts){
            if (count==2){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "";
        int result = new _016_lengthOfLongestSubstring().lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
