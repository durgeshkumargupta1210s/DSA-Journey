class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValid(board, 0, 0);
    }

    public static boolean isValid(char[][] board, int row, int col) {
        if (col == 9) {
            col = 0;
            row++;
        }
        if (row == 9) {
            return true; // All cells checked
        }

        if (board[row][col] != '.') {
            char val = board[row][col];
            if (!isItSafe(board, row, col, val)) {
                return false;
            }
        }

        return isValid(board, row, col + 1);
    }

    public static boolean isItSafe(char[][] board, int row, int col, char val) {
        // Check row & column
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == val) return false;
            if (i != row && board[i][col] == val) return false;
        }

        // Check 3×3 subgrid
        int rStart = row - row % 3;
        int cStart = col - col % 3;
        for (int i = rStart; i < rStart + 3; i++) {
            for (int j = cStart; j < cStart + 3; j++) {
                if ((i != row || j != col) && board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
