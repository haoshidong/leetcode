package 剑指offer;

public class p005_maxProduct {

    public int maxProduct(String[] words) {
        int[] flags = new int[words.length];
        int ans = 0;
        for (int i=0;i< words.length;i++){
            for (char c:words[i].toCharArray()){
                flags[i] |= 1<<(c-'a');     //不能相加，否则或导致进位，按位与不会进位！！！
            }
        }
        for (int i=0;i< words.length;i++){
            for (int j=i+1;j< words.length;j++){
                if ((flags[i] & flags[j]) == 0){       //不能写“！= 1”，有相同字符的字符串大于等于1
                    int prod = words[i].length() * words[j].length();
                    ans = Math.max(prod, ans);
                }
            }
        }
        return ans;

        /*int n = words.length;
        boolean[][] flags = new boolean[n][26];
        for (int i = 0; i<n; i++){
            for (char c:words[i].toCharArray()){
                flags[i][c-'a'] = true;
            }
        }
        int result = 0;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                int k = 0;
                for (;k<26;k++){
                    if (flags[i][k]&&flags[j][k]){
                        break;
                    }
                }
                if (k==26){
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }
        return result;*/
    }

}
