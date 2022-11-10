package 每日一题;

import java.util.ArrayList;
import java.util.List;

public class p816_ambiguousCoordinates {
    public List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        if (s.charAt(1) == '0') {
            splitIndex(s, ans, 1);
        }
        for (int i = 1; i < s.length() - 2; i++) {
            if (s.charAt(1)!='0') {
                splitIndex(s, ans, i);
            } else if (s.charAt(i) - '0' > 0) {
                splitIndex(s, ans, i);
            }
        }
        return ans;
    }

    private void splitIndex(String s, List<String> ans, int index) {
        String x = s.substring(1, index + 1);
        String y = s.substring(index + 1, s.length() - 1);
        List<String> first = coordinates(x, new ArrayList<>());
        List<String> second = coordinates(y, new ArrayList<>());
        if (second.size() != 0) {
            for (String n_x : first) {
                for (String n_y : second) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('(').append(n_x).append(", ").append(n_y).append(')');
                    ans.add(sb.toString());
                }
            }
        }
    }

    private List<String> coordinates(String coord, List<String> coors) {
        if (coord.length() == 1) {
            coors.add(coord);
        } else if (coord.charAt(0) == '0' && coord.charAt(coord.length() - 1) != '0') {
            coors.add(coord.replaceFirst("0", "0."));
        } else {
            if (coord.charAt(0)!='0') {
                coors.add(coord);
            }
            if (coord.charAt(coord.length() - 1) != '0') {
                for (int i = 0; i < coord.length() - 1; i++) {
                    String pre = coord.substring(0,i+1);
                    String post = coord.substring(i+1);
                    StringBuilder sb = new StringBuilder();
                    sb.append(pre).append('.').append(post);
                    coors.add(sb.toString());
                }
            }
        }
        return coors;
    }

    public static void main(String[] args) {
        String s = "(100)";
        List<String> ans = new p816_ambiguousCoordinates().ambiguousCoordinates(s);
        for (String a : ans) {
            System.out.println(a);
        }
    }
}
