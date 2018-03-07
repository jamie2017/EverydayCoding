package HighFrequency.TopK.MultipleSolutions;

/**
 * Created by JMYE on 11/25/16.
 */
public class BattleshipsinaBoard {
    // One pass, O(1) extra space
    /*
    X..X
    ...X
    ...X

    ans = 2
     */
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(board[i][j]=='X' && (i==0 || board[i-1][j]!='X') && (j==0 || board[i][j-1]!='X')) count++;
        return count;
    }
}
