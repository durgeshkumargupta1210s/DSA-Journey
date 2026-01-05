class Solution {
    public int calculateMinimumHP(int[][] grid) {
        int [][] dp=new int[grid.length][grid[0].length];
        for(int [] arr : dp){
            Arrays.fill(arr,0);
        }
        return helper(0,0,grid, dp);
    }

    public int helper(int i, int j, int grid[][], int[][]dp){
        if(i>=grid.length || j>=grid[0].length){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j]!=0){
            return dp[i][j];
        }

        if(i==grid.length-1 && j==grid[0].length-1){
            return Math.max(1,1-grid[i][j]);
        }

        int right = helper(i,j+1,grid,dp);
        int down = helper(i+1,j,grid, dp);

        return dp[i][j]= Math.max(1,Math.min(right,down)-grid[i][j]);
    }
}