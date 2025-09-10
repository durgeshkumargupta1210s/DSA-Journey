class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        
        // Initialize dp with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        
        return Minimum_Path(grid, 0, 0, dp);
    }
    
    public static int Minimum_Path(int[][] grid, int cr, int cc, int[][] dp) {
        // Base case: reached bottom-right cell
        if (cr == grid.length - 1 && cc == grid[0].length - 1) {
            return grid[cr][cc];
        }

        // Out of bounds
        if (cr >= grid.length || cc >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        // If already computed
        if (dp[cr][cc] != -1) {
            return dp[cr][cc];
        }

        // Move down
        int d = Minimum_Path(grid, cr + 1, cc, dp);
        // Move right
        int r = Minimum_Path(grid, cr, cc + 1, dp);

        // Store result in dp
        return dp[cr][cc] = Math.min(d, r) + grid[cr][cc];
    }
}
