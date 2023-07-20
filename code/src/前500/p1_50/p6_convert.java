package 前500.p1_50;

import java.util.ArrayList;

public class p6_convert {
    public String convert(String s, int numRows) {
        ArrayList<StringBuilder> raws = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            raws.add(new StringBuilder());
        }
        int raw = 0;
        int flag = -1;
        for (char ch : s.toCharArray()) {
            raws.get(raw).append(ch);
            if (raw == 0 || raw == numRows - 1) {
                flag = -flag;
            }
            raw += flag;
        }
        StringBuilder ans = new StringBuilder(numRows);
        for (StringBuilder arr : raws) {
            ans.append(arr);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String convert = new p6_convert().convert(s, numRows);
        System.out.println(convert);
    }
}
