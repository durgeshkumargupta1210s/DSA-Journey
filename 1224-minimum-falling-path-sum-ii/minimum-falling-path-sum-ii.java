class Solution {
    public int minFallingPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		for (int[] a : dp) {
			Arrays.fill(a, -1000000);
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < grid[0].length; i++) {
			ans = Math.min(ans, Falling_Path_Sum(grid, 0, i, dp));
		}
		return ans;
        
    }
    public static int Falling_Path_Sum(int[][] grid, int cr, int cc, int[][] dp) {
		if (cr == grid.length - 1) {
			return grid[cr][cc];
		}
		if (dp[cr][cc] != -1000000) {
			return dp[cr][cc];
		}
		
		int ans=Integer.MAX_VALUE;
		for(int i=0; i<grid[0].length; i++) {
			if(i==cc) {
				continue;
			}
			ans=Math.min(ans, Falling_Path_Sum(grid,cr+1,i,dp));
		}
		return dp[cr][cc]=ans+grid[cr][cc];
	}
}