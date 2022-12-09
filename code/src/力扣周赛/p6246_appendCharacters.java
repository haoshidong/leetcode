package 力扣周赛;

public class p6246_appendCharacters {
    public int appendCharacters(String s, String t) {
        int ans = t.length();
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (ch==t.charAt(i)){
                ans--;
                i++;
                if (ans==0){
                    return 0;
                }
            }
        }
        return ans;
    }
}
