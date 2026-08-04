class Solution {

    int[][] dp;

    public boolean stoneGame(int[] piles) {

        int sum = 0;
        for (int x : piles) {
            sum += x;
        }

        dp = new int[piles.length][piles.length];

        for (int i = 0; i < piles.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(piles, 0, piles.length - 1) > sum / 2;
    }

    public int solve(int[] piles, int i, int j) {

        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int take_i = piles[i] + Math.min(
                solve(piles, i + 2, j),
                solve(piles, i + 1, j - 1)
        );

        int take_j = piles[j] + Math.min(
                solve(piles, i, j - 2),
                solve(piles, i + 1, j - 1)
        );

        return dp[i][j] = Math.max(take_i, take_j);
    }
}