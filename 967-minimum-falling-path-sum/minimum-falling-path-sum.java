import java.util.*;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        
        // Create dp table initialized with sentinel value
        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        // Try starting from each element in the first row
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, calculatePath(0, i, matrix, dp));
        }

        return ans;
    }

    // Recursive function with memoization
    public int calculatePath(int cr, int cc, int[][] matrix, int[][] dp) {
        int n = matrix.length;

        // If column index is out of bounds
        if (cc < 0 || cc >= n) {
            return Integer.MAX_VALUE;
        }

        // Base case: if we reach the last row
        if (cr == n - 1) {
            return matrix[cr][cc];
        }

        // Return already computed value
        if (dp[cr][cc] != Integer.MAX_VALUE) {
            return dp[cr][cc];
        }

        // Recursive calls for down, left diagonal, and right diagonal
        int down =calculatePath(cr + 1, cc, matrix, dp);
        int leftDiagonal =calculatePath(cr + 1, cc - 1, matrix, dp);
        int rightDiagonal =calculatePath(cr + 1, cc + 1, matrix, dp);

        // Memoize and return the minimum of three possible paths
        dp[cr][cc] = Math.min(down, Math.min(leftDiagonal, rightDiagonal))+matrix[cr][cc];
        return dp[cr][cc];
    }
}
