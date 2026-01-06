class Solution {

    // Entry method that initializes DP table
    public int longestCommonSubsequence(String text1, String text2) {

        // dp[i][j] stores the LCS length of substrings
        // text1[i...] and text2[j...]
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // Initialize DP table with -1 to indicate uncomputed states
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        // Start recursion from index 0 of both strings
        return lcs(text1, text2, 0, 0, dp);
    }

    // Variable to store result for current recursive call
    int ans = 0;

    // Recursive function to compute LCS length
    public int lcs(String s1, String s2, int i, int j, int[][] dp) {

        // Base case:
        // If either string is fully traversed,
        // no common subsequence can be formed
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        // If this subproblem is already solved, return stored value
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Case 1: Current characters match
        if (s1.charAt(i) == s2.charAt(j)) {

            // Include this matching character and move both pointers
            ans = 1 + lcs(s1, s2, i + 1, j + 1, dp);
        }

        // Case 2: Characters do not match
        else {

            // Option 1: Skip character from second string
            int f = lcs(s1, s2, i, j + 1, dp);

            // Option 2: Skip character from first string
            int s = lcs(s1, s2, i + 1, j, dp);

            // Take maximum of both options
            ans = Math.max(f, s);
        }

        // Store result in DP table and return
        return dp[i][j] = ans;
    }
}
