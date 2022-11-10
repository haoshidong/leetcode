/**
我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
 

 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表
示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。 

 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。 

 

 
示例 1:
输入: "(123)"
输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 

 
示例 2:
输入: "(00011)"
输出:  ["(0.001, 1)", "(0, 0.011)"]
解释: 
0.0, 00, 0001 或 00.01 是不被允许的。
 

 
示例 3:
输入: "(0123)"
输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)
"]
 

 
示例 4:
输入: "(100)"
输出: [(10, 0)]
解释: 
1.0 是不被允许的。
 

 

 提示: 

 
 4 <= S.length <= 12. 
 S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。 
 

 

 Related Topics 字符串 回溯 👍 81 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
}
//leetcode submit region end(Prohibit modification and deletion)
