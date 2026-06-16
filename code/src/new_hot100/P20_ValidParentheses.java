package new_hot100;

class P20_ValidParentheses {

    
//IMPORTANT!! Submit Code Region Begin(Do not remove this line)
class Solution {
    public boolean isValid(String s) {
        int o = 0;
        int p = 0;
        int q = 0;
        for(char c : s.toCharArray()) {
            switch (c){
                case '(' : o++; break;
                case ')' : o--; if(o < 0) return false; break;
                case '[' : p++; break;
                case ']' : p--; if(p < 0) return false; break;
                case '{' : q++; break;
                case '}' : q--; if(q < 0) return false; break;
            }
        }
        return o == 0 && p == 0 && q == 0;
    }
}
//IMPORTANT!! Submit Code Region End(Do not remove this line)

    public static void main(String[] args) {
        // add your test code
        Solution solution = new P20_ValidParentheses().new Solution(); 
    }
}