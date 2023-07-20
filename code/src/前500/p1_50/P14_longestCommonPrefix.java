package 前500.p1_50;

public class P14_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        char[] chars = strs[0].toCharArray();
        boolean flag = true;
        while (flag) {
            for (String str : strs) {
                if (i < str.length()) {
                    if (str.charAt(i) != chars[i]) {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            i++;
        }
        return String.valueOf(chars, 0, i - 1);
    }
}
