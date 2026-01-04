class Solution {

    // Main function that initializes DP and starts recursion
    public int longestPalindromeSubseq(String s) {

        // dp[i][j] will store the length of the Longest Palindromic Subsequence
        // in the substring s[i...j]
        int[][] dp = new int[s.length()][s.length()];

        // Initialize DP table with -1 to indicate uncomputed states
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        // Start recursion for the full string
        return lpsHelper(s, 0, s.length() - 1, dp);
    }

    // Global variable to store the result for current recursion state
    int ans = 0;

    // Recursive helper function to compute LPS length for substring s[i...j]
    private int lpsHelper(String s, int i, int j, int[][] dp) {

        // -------- Base Cases --------

        // If left index crosses right index → no characters left
        if (i > j) return 0;

        // If already computed, return stored result (memoization)
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If only one character remains, it is a palindrome of length 1
        if (i == j) return 1;

        // -------- Recursive Cases --------

        // Case 1: Characters at both ends match
        if (s.charAt(i) == s.charAt(j)) {

            // Include both characters and solve for inner substring
            ans = 2 + lpsHelper(s, i + 1, j - 1, dp);

        } else {

            // Case 2: Characters do not match
            // Try excluding one character from either end
            ans = Math.max(
                    lpsHelper(s, i + 1, j, dp),
                    lpsHelper(s, i, j - 1, dp)
            );
        }

        // Store result in DP table and return
        return dp[i][j] = ans;
    }
}
