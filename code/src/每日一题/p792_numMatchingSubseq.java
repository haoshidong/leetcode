package 每日一题;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class p792_numMatchingSubseq {
    public int numMatchingSubseq(String s, String[] words) {
        //桶排序
        Queue<String>[] queue = new Queue[26];
        //初始化桶
        for (int i = 0; i < 26; i++) {
            queue[i] = new ArrayDeque<>();
        }
        //words数组中的字符串按首字母入桶
        for (String w : words) {
            queue[w.charAt(0) - 'a'].offer(w);
        }
        int ans = 0;
        //遍历s中每个字符
        for (char ch : s.toCharArray()) {
            Queue<String> cur = queue[ch - 'a'];
            //关键！！！ i不能从0开始，因为cur.size()会变化，i需要一开始就取到cur.size()的值
            for (int i = cur.size(); i > 0; i--) {
                String t = cur.poll();
                //如果取出的字符串长度为1，结果加1
                if (t.length() == 1) {
                    ans++;
                } else {
                    //删除首字符，剩余字符串入对应桶
                    queue[t.charAt(1) - 'a'].offer(t.substring(1));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        int ans = new p792_numMatchingSubseq().numMatchingSubseq(s, words);
        System.out.println(ans);
    }
}
