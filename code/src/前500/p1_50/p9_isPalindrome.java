package 前500.p1_50;

public class p9_isPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int l = 0;
        int r = chars.length-1;
        while (l<r){
            if (chars[l]==chars[r]){
                l++;
                r--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 121;
        boolean palindrome = new p9_isPalindrome().isPalindrome(x);
        System.out.println(palindrome);
    }
}
