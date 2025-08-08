import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        // fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> result = new ArrayList<>();
        queenPath(board, n, 0, result);
        return result;
    }

    public static void queenPath(char[][] board, int tq, int row, List<List<String>> list) {
        if (tq == 0) {
            list.add(construct(board));
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isItSafe(board, row, col)) {
                board[row][col] = 'Q';
                queenPath(board, tq - 1, row + 1, list);
                board[row][col] = '.';
            }
        }
    }

    public static boolean isItSafe(char[][] board, int row, int col) {
        int r, c;

        // check vertical column
        r = row;
        while (r >= 0) {
            if (board[r][col] == 'Q') {
                return false;
            }
            r--;
        }

        // check left diagonal
        r = row;
        c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }

        // check right diagonal
        r = row;
        c = col;
        while (r >= 0 && c < board[0].length) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}
