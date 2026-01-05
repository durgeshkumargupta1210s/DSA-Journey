class Solution {

    // Main function: initializes DP and starts recursion from (0,0)
    public int calculateMinimumHP(int[][] grid) {

        // dp[r][c] = minimum health required to enter cell (r,c)
        int[][] dp = new int[grid.length][grid[0].length];

        // Initialize DP with 0
        // 0 indicates that the cell has not been computed yet
        for (int[] arr : dp) {
            Arrays.fill(arr, 0);
        }

        // Start recursive DP from top-left cell (0,0)
        return calculatehp(grid, 0, 0, dp);
    }

    // Recursive function to compute minimum health needed from cell (cr, cc)
    public int calculatehp(int[][] grid, int cr, int cc, int[][] dp) {

        // Base case 1:
        // If we go outside the grid boundaries,
        // return a very large value so this path is never chosen
        if (cr >= grid.length || cc >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        // Memoization check:
        // If already computed, return stored result
        if (dp[cr][cc] != 0) {
            return dp[cr][cc];
        }

        // Base case 2:
        // If we are at the destination cell (bottom-right),
        // we need at least 1 health after applying grid value
        if (cr == grid.length - 1 && cc == grid[0].length - 1) {
            return Math.max(1, 1 - grid[cr][cc]);
        }

        // Recursively calculate minimum health needed
        // if we move right
        int right = calculatehp(grid, cr, cc + 1, dp);

        // Recursively calculate minimum health needed
        // if we move down
        int down = calculatehp(grid, cr + 1, cc, dp);

        // Choose the better (minimum health requirement) of right or down
        int minHealthNeeded = Math.min(right, down);

        // Health required at current cell:
        // Subtract current cell's value and ensure health never drops below 1
        dp[cr][cc] = Math.max(1, minHealthNeeded - grid[cr][cc]);

        // Store and return the result
        return dp[cr][cc];
    }
}
