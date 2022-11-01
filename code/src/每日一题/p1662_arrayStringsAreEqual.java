package 每日一题;

import 剑指offer.ListNode;

public class p1662_arrayStringsAreEqual {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        //遍历
        //p1和p2:数组中字符串的下标，i和j：字符串中字符的下标
        int i = 0, j = 0, p1 = 0, p2 = 0;
        while (p1 < word1.length && p2 < word2.length) {
            //字符不相等返回false
            if (word1[p1].charAt(i) != word2[p2].charAt(j)) {
                return false;
            }
            //字符相等，对i和j加1
            i++;
            if (i == word1[p1].length()) {  //若i到达当前字符串的末尾，字符串下标加1，i从新字符串的下标0开始扫描
                p1++;
                i = 0;
            }
            j++;
            if (j == word2[p2].length()) {  //若j到达当前字符串的末尾，字符串下标加1，j从新字符串的下标0开始扫描
                p2++;
                j = 0;
            }
        }
        return p1 == word1.length && p2 == word2.length;

        /*//拼接字符串
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        //拼接字符串
        for (String word : word1) {
            sb1.append(word);
        }
        //拼接字符串
        for (String word : word2) {
            sb2.append(word);
        }
        if (sb1.toString().equals(sb2.toString())) return true;
        else return false;*/
    }

    public static void main(String[] args) {
        String[] word1 = {"a", "bc"};
        String[] word2 = {"ab", "c"};
        boolean res = new p1662_arrayStringsAreEqual().arrayStringsAreEqual(word1, word2);
        System.out.println(res);
    }
}
