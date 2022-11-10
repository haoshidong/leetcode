/**
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 

 

 示例 1： 
 
 
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
"ABCCED"
输出：true
 

 示例 2： 
 
 
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
"SEE"
输出：true
 

 示例 3： 
 
 
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
"ABCB"
输出：false
 

 

 提示： 

 
 m == board.length 
 n = board[i].length 
 1 <= m, n <= 6 
 1 <= word.length <= 15 
 board 和 word 仅由大小写英文字母组成 
 

 

 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 

 Related Topics 数组 回溯 矩阵 👍 1475 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flag = flag || findWord(board, word, visited, i, j, 1);
                }
            }
        }
        return flag;
    }

    private boolean findWord(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        } else {
            visited[i][j] = true;
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            boolean find = false;
            for (int[] dir : dirs) {
                int row = i + dir[0], col = j + dir[1];
                if (row >= 0 && row < board.length && col >= 0 && col < board[0].length
                        && board[row][col] == word.charAt(index)
                        && !visited[row][col]) {
                    find = find || findWord(board,word,visited,row,col,index+1);
                }
            }
            visited[i][j] = false;
            return find;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
