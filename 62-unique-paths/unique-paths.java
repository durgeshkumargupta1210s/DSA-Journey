class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp=new int[m+1][n+1];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }

        return countPath(0,0,m,n,dp);
    }
    public int countPath(int cr, int cc,int m, int n, int [][] dp){
        if(cr>=m || cc >=n){
            return 0;
        }

        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }

        if(cr==m-1 && cc==n-1){
            return 1;
        }

       int down=countPath(cr+1, cc, m,n, dp);
       int right=countPath(cr, cc+1,m,n, dp);

       return dp[cr][cc]= down + right;
    }
}