class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][] dp=new int[m+1][n+1];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return countPath(0,0,obstacleGrid,dp);
        
    }
    public int countPath(int cr, int cc,int [][] og, int [][] dp){
        if(cr>=og.length || cc >=og[0].length || og[cr][cc]==1 ){
            return 0;
        }

        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }

        if(cr==og.length-1 && cc==og[0].length-1){
            return 1;
        }

       int down=countPath(cr+1, cc,og, dp);
       int right=countPath(cr, cc+1,og, dp);

       return dp[cr][cc]= down + right;
    }
}