class Solution {
    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0);
    }

    public static boolean sudokuSolver(char[][] board, int row, int col) {
        if (col == 9) { // End of row
            col = 0;
            row++;
        }
        if (row == 9) { // Solved the board
            return true;
        }

        if (board[row][col] != '.') {
            return sudokuSolver(board, row, col + 1);
        }

        for (char val = '1'; val <= '9'; val++) {
            if (isItSafe(board, row, col, val)) {
                board[row][col] = val;
                if (sudokuSolver(board, row, col + 1)) {
                    return true; // Found a valid solution
                }
                board[row][col] = '.'; // Backtrack
            }
        }
        return false; // No number fits
    }

    public static boolean isItSafe(char[][] board, int row, int col, char val) {
        // Check row & column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val || board[i][col] == val) {
                return false;
            }
        }

        // Check 3×3 subgrid
        int rStart = row - row % 3;
        int cStart = col - col % 3;
        for (int i = rStart; i < rStart + 3; i++) {
            for (int j = cStart; j < cStart + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
