class Solution {

    // DP memo table
    Integer[][][] dp;

    public int minimumDistance(String word) {
        int n = word.length();

        // dp[index][left][right]
        // left/right range: 0-25 (A-Z) + 26 (not used yet)
        dp = new Integer[n][27][27];

        return solve(word, 0, 26, 26);
    }

    // Recursive DP
    private int solve(String word, int i, int left, int right) {
        // Base case
        if (i == word.length()) return 0;

        // Memo check
        if (dp[i][left][right] != null) {
            return dp[i][left][right];
        }

        int curr = word.charAt(i) - 'A';

        // Option 1: Use left finger
        int useLeft = getDist(left, curr) + solve(word, i + 1, curr, right);

        // Option 2: Use right finger
        int useRight = getDist(right, curr) + solve(word, i + 1, left, curr);

        // Store result
        return dp[i][left][right] = Math.min(useLeft, useRight);
    }

    // Calculate Manhattan distance on keyboard
    private int getDist(int a, int b) {
        // If finger not used yet → no cost
        if (a == 26) return 0;

        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}