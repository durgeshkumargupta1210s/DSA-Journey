class Solution {
    static long[][] dp;
    static int MOD = 1000000007;

    public int countPalindromicSubsequences(String s) {

        int n = s.length();

        dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return (int) solve(s, 0, n - 1);
    }

    public static long solve(String s, int i, int j) {

        if (i > j) {
            return 0;
        }

        if (i == j) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) != s.charAt(j)) {

            long left = solve(s, i + 1, j);
            long right = solve(s, i, j - 1);
            long both = solve(s, i + 1, j - 1);

            return dp[i][j] =
                (left + right - both + MOD) % MOD;
        }

        // s[i] == s[j]

        int left = i + 1;
        int right = j - 1;

        while (left <= right && s.charAt(left) != s.charAt(i)) {
            left++;
        }

        while (left <= right && s.charAt(right) != s.charAt(i)) {
            right--;
        }

        if (left > right) {

            return dp[i][j] =
                (2 * solve(s, i + 1, j - 1) + 2) % MOD;

        } else if (left == right) {

            return dp[i][j] =
                (2 * solve(s, i + 1, j - 1) + 1) % MOD;

        } else {

            return dp[i][j] =
                (2 * solve(s, i + 1, j - 1)
                - solve(s, left + 1, right - 1)
                + MOD) % MOD;
        }
    }
}