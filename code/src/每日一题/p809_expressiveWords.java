package 每日一题;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class p809_expressiveWords {
    public int expressiveWords(String s, String[] words) {
        int n = s.length(), ans = 0;
        //一次遍历
        out:for (String word : words) {
            int m = word.length(), i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) != word.charAt(j)) continue out;
                int a = i, b = j;
                while (a < n && s.charAt(a) == s.charAt(i)) a++;
                while (b < m && word.charAt(b) == word.charAt(j)) b++;
                a -= i; b -= j;
                if (a != b && (b > a || a < 3)) continue out;
                i += a; j += b;
            }
            if (i == n && j == m) ans++;
        }
        return ans;

        /*
        //两次遍历
        int ans = 0;
        //按顺序存放s中不同的字符
        List<Character> chars = new LinkedList<>();
        //s中不同字符的个数
        List<Integer> counts = new LinkedList<>();
        //初始化chars和counts
        for (int i = 1; i <= s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(j - 1)) {
                j++;
            }
            //下标j-1字符不等于下标j的字符
            chars.add(s.charAt(j - 1));
            //下标j-1字符在s字符串的连续个数
            counts.add(j - i + 1);
            i = j;
        }
        //遍历每个word
        for (String word : words) {
            //chars的下标
            int index = 0;
            //word的下标
            int i = 1;
            for (; i <= word.length() && index < chars.size(); i++, index++) {
                int j = i;
                //寻找下标i-1的右边界
                while (j < word.length() && word.charAt(j) == word.charAt(j - 1)) {
                    j++;
                }
                //下标i-1字符的连续长度
                int len = j - i + 1;
                int s_len = counts.get(index);
                //chars与i-1对应字符不相等；word中对应字符长度 > s长度；字符长度 < s长度且s长度 < 3
                if (chars.get(index) != word.charAt(j - 1) || len < s_len && s_len < 3 || len > s_len) {
                    break;
                }
                i = j;
            }
            //若index和i都遍历到自身字符串最后一个元素，则ans+1
            if (index == chars.size() && i == word.length() + 1) {
                ans++;
            }
        }
        return ans;*/
    }

    public static void main(String[] args) {
        String[] words = {"hello", "hi", "helo"};
        String s = "heeello";
        int ans = new p809_expressiveWords().expressiveWords(s, words);
        System.out.println(ans);
    }
}
