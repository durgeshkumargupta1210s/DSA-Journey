class Solution {

    int[][] grid;
    int m, n, k;
    Integer[][][] dp;

    public int maxPathScore(int[][] grid, int k) {
        this.grid = grid;
        this.k = k;
        m = grid.length;
        n = grid[0].length;

        dp = new Integer[m][n][k + 1];

        int ans = dfs(0, 0, 0);

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    public int dfs(int i, int j, int usedCost) {

        // Out of bounds
        if (i >= m || j >= n) return Integer.MIN_VALUE;

        int val = grid[i][j];
        int cost = (val == 0 ? 0 : 1);

        // If cost exceeds
        if (usedCost + cost > k) return Integer.MIN_VALUE;

        // Destination
        if (i == m - 1 && j == n - 1) {
            return val;
        }

        // Memo check
        if (dp[i][j][usedCost] != null) {
            return dp[i][j][usedCost];
        }

        int newCost = usedCost + cost;

        int right = dfs(i, j + 1, newCost);
        int down = dfs(i + 1, j, newCost);

        int best = Math.max(right, down);

        if (best == Integer.MIN_VALUE) {
            return dp[i][j][usedCost] = Integer.MIN_VALUE;
        }

        return dp[i][j][usedCost] = val + best;
    }
}