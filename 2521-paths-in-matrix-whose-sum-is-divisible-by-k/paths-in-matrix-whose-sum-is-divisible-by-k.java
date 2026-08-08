class Solution {
    static int[][][] dp;
    static int MOD = 1000000007;

    public int numberOfPaths(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, grid, k, 0);
    }

    public static int solve(int cr, int cc, int[][] grid,
                            int k, int sum) {

        if (cr >= grid.length || cc >= grid[0].length) {
            return 0;
        }

        sum = (sum + grid[cr][cc]) % k;

        if (cr == grid.length - 1 &&
            cc == grid[0].length - 1) {

            if (sum == 0) {
                return 1;
            }

            return 0;
        }

        if (dp[cr][cc][sum] != -1) {
            return dp[cr][cc][sum];
        }

        int down = solve(cr + 1, cc, grid, k, sum);

        int right = solve(cr, cc + 1, grid, k, sum);

        return dp[cr][cc][sum] = (down + right) % MOD;
    }
}