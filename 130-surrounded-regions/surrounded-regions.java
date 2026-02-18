class Solution {

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // Step 1: Mark all border connected 'O' as SAFE ('#')

        // top and bottom row
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        // left and right column
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        // Step 2: Convert surrounded 'O' → 'X'
        // Step 3: Convert safe '#' → 'O'

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    public void dfs(char[][] board, int i, int j) {

        int m = board.length;
        int n = board[0].length;

        // Boundary check
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') {
            return;
        }

        // Mark as safe
        board[i][j] = '#';

        // Explore all 4 directions
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
