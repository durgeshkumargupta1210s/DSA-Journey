class Solution {
    public boolean winnerSquareGame(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    public static boolean solve(int n, int[] dp) {

        if (n == 0)
            return false;

        if (dp[n] != -1) {
            return dp[n] == 1;
        }

        for (int i = 1; i * i <= n; i++) {

            if (!solve(n - i * i, dp)) {
                dp[n] = 1;
                return true;
            }
        }

        dp[n] = 0;
        return false;
    }
}