package Hot100.p051_p100;

public class p394_decodeString {
    public String decodeString(String s) {
        return getStr(s, 0)[0];
    }

    private String[] getStr(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                // ex: s = "100[leetcode]"
                multi = multi * 10 + Integer.parseInt(String.valueOf(ch));
            } else if (ch=='[') {
                //递归调用
                String[] tmp = getStr(s,i+1);
                //更新后的i值，指向’]‘
                i = Integer.parseInt(tmp[0]);
                //更新res
                while (multi>0){
                    res.append(tmp[1]);
                    multi--;
                }
            } else if (ch==']') {
                //第一层不会进入到这里
                return new String[]{String.valueOf(i),res.toString()};
            }else {
                //若ch为小写字母，追加到res后面
                res.append(ch);
            }
            i++;
        }
        return new String[]{res.toString()};
    }

    public static void main(String[] args) {
        String s = "3[a]";
        String ans = new p394_decodeString().decodeString(s);
        System.out.println(ans);
    }
}
