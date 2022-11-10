package Hot100.p001_p050;

import java.util.LinkedList;
import java.util.Queue;

public class p79_exist {
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
        //表示word.length()-1个字符已经匹配上
        if (index == word.length()) {
            return true;
        } else {
            //避免递归到下一层，又返回到上一层。
            visited[i][j] = true;
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            //find表示余下的字符是否得到匹配
            boolean find = false;
            //若当前字符的4个方向找到余下字符相匹配的，则find为true
            for (int[] dir : dirs) {
                int row = i + dir[0], col = j + dir[1];
                if (row >= 0 && row < board.length && col >= 0 && col < board[0].length
                        && board[row][col] == word.charAt(index)
                        && !visited[row][col]) {
                    find = find || findWord(board,word,visited,row,col,index+1);
                }
            }
            //恢复状态。
            visited[i][j] = false;
            return find;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        boolean ans = new p79_exist().exist(board,word);
        System.out.println(ans);
    }
}
