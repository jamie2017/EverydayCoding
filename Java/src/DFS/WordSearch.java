package DFS;

/**
 * Created by JMYE on 9/3/16.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (exist(board, x, y, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int x, int y, char[] word, int i) {
        if (i == word.length) return true;
        if ( x < 0 || y < 0 || x == board.length || y == board[x].length) return false;
        if (board[x][y] != word[i]) return false;
        board[x][y] ^= 256; // mask to no valid
        boolean ifExist = exist(board, x, y + 1, word, i + 1)
                || exist(board, x, y - 1, word, i + 1)
                || exist(board, x + 1, y, word, i + 1)
                || exist(board, x - 1, y, word, i + 1);
        board[x][y] ^= 256; // reverse back to valid
        return ifExist;
    }
}
