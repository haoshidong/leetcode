package 剑指offer.p001_p050;

public class p018_isPalindrome {
    public boolean isPalindrome(String s) {
        int end = s.length() - 1;
        int start = 0;
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
                } else {
                    return false;
                }
            }

        }
        return true;
    }
}
