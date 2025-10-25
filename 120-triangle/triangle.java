class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Initialize dp with a sentinel value (e.g., Integer.MAX_VALUE or -1)
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        return minimumPathSum(0, 0, triangle, dp);
    }

    private int minimumPathSum(int cr, int cc, List<List<Integer>> triangle, int[][] dp) {
        // Base case: last row
        if (cr == triangle.size() - 1) {
            return triangle.get(cr).get(cc);
        }

        // If already computed, return it
        if (dp[cr][cc] != Integer.MAX_VALUE) {
            return dp[cr][cc];
        }

        // Recursive calls for down and diagonal paths
        int down = triangle.get(cr).get(cc) + minimumPathSum(cr + 1, cc, triangle, dp);
        int diagonal = triangle.get(cr).get(cc) + minimumPathSum(cr + 1, cc + 1, triangle, dp);

        // Store and return the minimum
        dp[cr][cc] = Math.min(down, diagonal);
        return dp[cr][cc];
    }
}
