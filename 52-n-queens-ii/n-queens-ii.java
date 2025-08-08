class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        // fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
      return  queenPath(board, n, 0);
    }

    public static int queenPath(char[][] board, int tq, int row) {
        if (tq == 0) {
            return 1;
        }
        int count=0;

        for (int col = 0; col < board[0].length; col++) {
            if (isItSafe(board, row, col)) {
                board[row][col] = 'Q';
                count += queenPath(board, tq - 1, row + 1);
                board[row][col] = '.';
            }
        }
        return count;
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
}