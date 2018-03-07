package Backtracking;

/**
 * Created by JMYE on 9/16/16.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board,0,0);
    }

    private boolean solve(char[][] board, int i, int j) {
        if(i == 9 && j == 0) return true;
        if(board[i][j] != '.') return solve(board, (j+1) == 9? i+1 : i, (j+1) == 9? 0 : j+1);

        for(char num = '1'; num <= '9'; num++) {
            if(isValid(board, i, j, num)){
                board[i][j] = num;
                if(solve(board, (j+1) == 9? i+1 : i, (j+1) == 9? 0 : j+1)) return true;
                board[i][j] = '.';
            }
        }

        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for(int i=0; i<9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false;
            if(board[row][i] != '.' && board[row][i] == c) return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] != '.' && board[3*(row/3)+i/3][3*(col/3)+i%3] == c) return false;
        }
        return true;
    }
}
