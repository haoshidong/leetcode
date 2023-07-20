package 前500.p1_50;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p51_solveNQueens {
    List<List<String>> chessBoards;

    int[] use;

    public List<List<String>> solveNQueens(int n){
        chessBoards = new ArrayList<>();
        use = new int[n];
        for (int i = 0; i < n; i++) {
            use[i] = -1;
        }
        List<String> path = new ArrayList<>();
        helper(0,n, path);
        return chessBoards;
    }

    private void helper(int row, int n, List<String> chessBoard) {
        if (row<n){
            //当前行用char数组保存
            char[] chars = new char[n];
            //初始化当前行
            for (int i = 0; i < n; i++) {
                chars[i] = '.';
            }
            //set保存当前行可插入的皇后位置，利用剪枝避免与之前插入的皇后在同一列
            Set<Integer> set = notUse(n);
            for (int col : set) {
//                set.remove(col);
                use[row] = col;
                chars[col] = 'Q';
                chessBoard.add(String.valueOf(chars));
                //如果当前行的皇后放置位置正确，则进入下一行
                if (isValid(row)) {
                    helper(row + 1, n, chessBoard);
                }
                chars[col] = '.';
                chessBoard.remove(row);
                use[row] = -1;
            }
        }else {
            chessBoards.add(new ArrayList<>(chessBoard));
        }
    }

    private Set<Integer> notUse(int n) {
        Set<Integer> notUse = new HashSet<>();
        for (int i = 0; i < n; i++) {
            notUse.add(i);
        }
        for (int num : use) {
            if (num != -1){
                notUse.remove(num);
            }
        }
        return notUse;
    }

    private boolean isValid(int row) {
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= row ; j++) {
                if (i==j){
                    continue;
                }else {
                    if (Math.abs(i - j) == Math.abs(use[i] - use[j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
class Main{
    public static void main(String[] args) {
        int n = 4;
        p51_solveNQueens nQueens = new p51_solveNQueens();
        List<List<String>> lists = nQueens.solveNQueens(n);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
        }
//        System.out.println(lists.toString());
    }
}
