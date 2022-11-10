package 每日一题;

import java.util.HashSet;
import java.util.Set;

public class p1684_countConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        //位运算
        int ans = 0;
        //用32位的int前26位表示allowed中的字符，若出现，对应位置为1。
        int mask = 0;
        for (char ch : allowed.toCharArray()) {
            mask |= 1 << (ch - 'a');
        }
        for (String word : words) {
            int mask_i = 0;
            for (char ch : word.toCharArray()) {
                mask_i |= 1 << (ch - 'a');
            }
            //若word是allowed的一致字符串，则mask_i和mask的与运算结果为mask
            if ((mask_i | mask) == mask) {
                ans++;
            }
        }
        return ans;

        /*
        //哈希表
        int ans = words.length;
        Set<Character> set = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            set.add(ch);
        }
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!set.contains(ch)){
                    ans--;
                    break;
                }
            }
        }
        return ans;*/
    }
}
