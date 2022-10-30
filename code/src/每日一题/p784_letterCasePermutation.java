package 每日一题;

import java.util.LinkedList;
import java.util.List;

public class p784_letterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        List<String> res = new LinkedList<>();
        helper(chars, 0, res);
        return res;
    }

    private void helper(char[] chars, int i, List<String> res) {
        if (i == chars.length) {
            res.add(new String(chars));
        } else {
            helper(chars,i+1,res);
            //若当前位置的字符为字母，改变大小写。
            if (Character.isLetter(chars[i])){
                chars[i] ^= 1<<5;   //位运算符：异或。相同为0，不同为1. 作用：大写字母转小写，小写字母转大写。
                helper(chars,i+1,res);
            }
        }
    }

    /*public List<String> letterCasePermutation(String s) {
        List<String> res = new LinkedList<>();
        helper(s,0,new StringBuilder(),res);
        return res;
    }

    private void helper(String s, int i, StringBuilder sb, List<String> res) {
        if (sb.length()==s.length()){
            res.add(sb.toString());
        }else if (i<s.length()){
            char ch = s.charAt(i);
            if (ch-'a'>=0 && ch-'a'<26){
                sb.append(ch);
                helper(s,i+1,sb,res);
                sb.deleteCharAt(i);

                sb.append((char) (ch-'a'+'A'));
                helper(s,i+1,sb,res);
                sb.deleteCharAt(i);
            } else if (ch-'A'>=0 && ch-'A'<26) {
                sb.append(ch);
                helper(s,i+1,sb,res);
                sb.deleteCharAt(i);

                sb.append((char) (ch-'A'+'a'));
                helper(s,i+1,sb,res);
                sb.deleteCharAt(i);
            }else {
                sb.append(ch);
                helper(s,i+1,sb,res);
                sb.deleteCharAt(i);
            }
        }
    }*/
}
