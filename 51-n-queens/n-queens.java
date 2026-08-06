class Solution {
    static List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {

        result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (char[] b : board) {
            Arrays.fill(b, '.');
        }

        solve(board, n, 0);

        return result;
    }

    public static void solve(char[][] board, int tq, int row) {

        if (tq == 0) {
            result.add(construct(board));
            return;
        }

        // Added
        if (row == board.length)
            return;

        for (int col = 0; col < board[0].length; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 'Q';

                solve(board, tq - 1, row + 1);

                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col) {

        int r = row;

        while (r >= 0) {

            if (board[r][col] == 'Q')
                return false;

            r--;
        }

        r = row;
        int c = col;

        while (r >= 0 && c >= 0) {

            if (board[r][c] == 'Q')
                return false;

            r--;
            c--;
        }

        r = row;
        c = col;

        while (r >= 0 && c < board[0].length) {

            if (board[r][c] == 'Q')
                return false;

            r--;
            c++;
        }

        return true;   // Fixed
    }

    private static List<String> construct(char[][] board) {

        List<String> res = new ArrayList<>();

        for (char[] row : board) {
            res.add(new String(row));
        }

        return res;
    }
}