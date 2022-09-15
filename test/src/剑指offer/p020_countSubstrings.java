package 剑指offer;

public class p020_countSubstrings {
    public int countSubstrings(String s) {
        if (s==null || s.length() ==0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //奇数字符串
            count += isPalindrome(s,i,i);
            //偶数字符串
            count += isPalindrome(s,i,i+1);
        }
        return count;
    }

    private int isPalindrome(String s, int start, int end){
        int count = 0;
        while (start>=0 && end<s.length()){
            if (s.charAt(start)==s.charAt(end)){
                start--;
                end++;
                count++;
            }
        }
        return count;
    }
}
