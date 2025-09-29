class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (isWordExist(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isWordExist(char[][] board, int cr, int cc, String word, int idx) {
        // ✅ if we matched full word
        if (idx == word.length()) {
            return true;
        }

        // boundary + mismatch check
        if (cr < 0 || cc < 0 || cr >= board.length || cc >= board[0].length 
            || board[cr][cc] != word.charAt(idx)) {
            return false;
        }

        // mark as visited
        char temp = board[cr][cc];
        board[cr][cc] = '#';

        // explore all directions
        boolean found = isWordExist(board, cr - 1, cc, word, idx + 1) ||
                        isWordExist(board, cr + 1, cc, word, idx + 1) ||
                        isWordExist(board, cr, cc - 1, word, idx + 1) ||
                        isWordExist(board, cr, cc + 1, word, idx + 1);

        // backtrack
        board[cr][cc] = temp;

        return found;
    }
}
