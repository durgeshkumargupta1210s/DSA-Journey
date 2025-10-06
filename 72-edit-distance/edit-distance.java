class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // initialize dp with -1 (not computed)
        for (int x = 0; x <= m; x++) {
            for (int y = 0; y <= n; y++) {
                dp[x][y] = -1;
            }
        }

        return minimumPath(word1, word2, 0, 0, dp);
    }

    public int minimumPath(String w1, String w2, int i, int j, int[][] dp) {
        // Base cases
        if (i == w1.length()) {
            return w2.length() - j;   // insert remaining of w2
        }
        if (j == w2.length()) {
            return w1.length() - i;   // delete remaining of w1
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans;
        if (w1.charAt(i) == w2.charAt(j)) {
            // No operation needed, move both forward
            ans = minimumPath(w1, w2, i + 1, j + 1, dp);
        } else {
            // Insert
            int insert = minimumPath(w1, w2, i, j + 1, dp);
            // Delete
            int delete = minimumPath(w1, w2, i + 1, j, dp);
            // Replace
            int replace = minimumPath(w1, w2, i + 1, j + 1, dp);

            ans = Math.min(insert, Math.min(delete, replace)) + 1;
        }

        return dp[i][j] = ans;
    }
}
