package 剑指offer.p001_p050;

public class p019_validPalindrome {
    public boolean validPalindrome(String s) {
        int end = s.length()-1;
        int start = 0;
        while (start <= end) {
            char startCh = s.charAt(start);
            char endCh = s.charAt(end);
            if (!Character.isLetterOrDigit(startCh)){
                start++;
            }else if (!Character.isLetterOrDigit(endCh)){
                end--;
            }else {
                startCh = Character.toLowerCase(startCh);
                endCh = Character.toLowerCase(endCh);
                if (startCh == endCh){
                    start++;
                    end--;
                }else {
                    break;
                }
            }
        }
        return start >= end
                || isPalindrome(s,start+1,end)
                || isPalindrome(s, start, end-1);
    }
    private boolean isPalindrome(String s, int start, int end){
        while (start <= end) {
            char startCh = s.charAt(start);
            char endCh = s.charAt(end);
            if (!Character.isLetterOrDigit(startCh)) {
                start++;
            } else if (!Character.isLetterOrDigit(endCh)) {
                end--;
            } else {
                startCh = Character.toLowerCase(startCh);
                endCh = Character.toLowerCase(endCh);
                if (startCh == endCh) {
                    start++;
                    end--;
                }else {
                    break;
                }
            }
        }
        return start >= end;
    }

    public static void main(String[] args) {
        String s = "abc";
        boolean flag = new p019_validPalindrome().validPalindrome(s);
        System.out.println(flag);
    }
}
