class Solution {
    public int minFallingPathSum(int[][] matrix) {
		int[][] dp = new int[matrix.length][matrix[0].length];
		for (int[] a : dp) {
			Arrays.fill(a, -1000000);
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < matrix[0].length; i++) {
			ans = Math.min(ans, Falling_Path_Sum(matrix, 0, i, dp));
		}
		return ans;
    }

    public static int Falling_Path_Sum(int[][] grid, int cr, int cc, int[][] dp) {
		if (cc < 0 || cc >= grid[0].length) {
			return Integer.MAX_VALUE;
		}
		if (cr == grid.length - 1) {
			return grid[cr][cc];
		}
		if (dp[cr][cc] != -1000000) {
			return dp[cr][cc];
		}
		int dl = Falling_Path_Sum(grid, cr + 1, cc - 1, dp);
		int dr = Falling_Path_Sum(grid, cr + 1, cc + 1, dp);
		int dwon = Falling_Path_Sum(grid, cr + 1, cc, dp);
		return dp[cr][cc] = Math.min(dl, Math.min(dr, dwon)) + grid[cr][cc];

	}
}